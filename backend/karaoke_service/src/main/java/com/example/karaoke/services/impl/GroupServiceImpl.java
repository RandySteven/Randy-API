package com.example.karaoke.services.impl;

import com.example.karaoke.entity.model.Group;
import com.example.karaoke.entity.payload.request.GroupRequest;
import com.example.karaoke.repository.GroupRepository;
import com.example.karaoke.services.GroupService;
import com.example.karaoke.utils.SecurityUtil;
import com.example.karaoke.utils.VelocityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    VelocityUtil vu = VelocityUtil.getInstance();

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    SecurityUtil securityUtil;

    private static final Logger LOGGER = LoggerFactory.getLogger(GroupServiceImpl.class);

    @Override
    public String addNewGroup(GroupRequest groupRequest) {
        Group group = new Group();
        group.setGroupId(vu.groupId());
        group.setGroupName(groupRequest.getGroupName());
        group.setGroupPass(
                securityUtil.groupPasswordEncryptionMD5(groupRequest.getGroupPassword())
        );
        group.setGroupToken(
                securityUtil.groupAccessTokenEncryptionSHA512(
                        groupRequest.getGroupName(),
                        groupRequest.getGroupPassword()
                )
        );
        group.setCreatedAt(LocalDateTime.now());
        group.setDeletedAt(null);
        Group postedGroup = groupRepository.insert(group);
        return postedGroup.getGroupToken();
    }

    @Override
    public List<Group> getAllGroups() {
        return null;
    }

    @Override
    public Group getGroupByGroupId(String groupId) {
        return null;
    }
}
