package com.example.karaoke.services.impl;

import com.example.karaoke.entity.model.Group;
import com.example.karaoke.entity.payload.request.GroupRequest;
import com.example.karaoke.repository.GroupRepository;
import com.example.karaoke.services.GroupService;
import com.example.karaoke.utils.SecurityUtil;
import com.example.karaoke.utils.VelocityUtil;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    VelocityUtil vu = VelocityUtil.getInstance();

    @Autowired
    GroupRepository groupRepository;

    SecurityUtil securityUtil = SecurityUtil.getInstance();

    private static final Logger LOGGER = LoggerFactory.getLogger(GroupServiceImpl.class);

    @Override
    public String addNewGroup(GroupRequest groupRequest) {
        LOGGER.info("=== Group Request : {}", JSONObject.wrap(groupRequest));
        Group group = new Group();
        group.setGroupId(vu.groupId());
        group.setGroupName(groupRequest.getGroupName());
        group.setGroupPass(
                groupRequest.getGroupPassword() == null ?
                        null :
                securityUtil.groupPasswordEncryptionMD5(groupRequest.getGroupPassword())
        );
        group.setGroupToken(
                groupRequest.getGroupPassword() != null ?
                securityUtil.groupAccessTokenEncryptionSHA512(
                        groupRequest.getGroupName(),
                        groupRequest.getGroupPassword()
                ) :
                        securityUtil.groupAccessTokenEncryptionSHA512(
                                groupRequest.getGroupName()
                        )
        );
        group.setCreatedAt(LocalDateTime.now());
        group.setDeletedAt(null);
        Group postedGroup = groupRepository.save(group);
        return postedGroup.getGroupToken();
    }

    @Override
    public List<Group> getAllGroups() {
        List<Group> groups = groupRepository.findAll();
        return groups;
    }

    @Override
    public Group getGroupByGroupId(String groupId) {
        List<Group> groups = getAllGroups();
        int index = -1;
        boolean search = false;
        for(int i = 0 ; i < groups.size() ; i++){
            if(groupId.equals(groups.get(i).getGroupId())){
                index = i;
                search = true;
            }
        }
        if(search == true){
            return groups.get(index);
        }
        return null;
    }

    @Override
    public Group getGroupByGroupToken(String groupToken) {
        List<Group> groups = getAllGroups();
        for(int i = 0 ; i < groups.size() ; i++){
            if(groupToken.equals(groups.get(i).getGroupToken())){
                return groups.get(i);
            }
        }
        return null;
    }
}
