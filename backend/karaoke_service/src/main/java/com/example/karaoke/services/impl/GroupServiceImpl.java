package com.example.karaoke.services.impl;

import com.example.karaoke.entity.model.Group;
import com.example.karaoke.repository.GroupRepository;
import com.example.karaoke.services.GroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    GroupRepository groupRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(GroupServiceImpl.class);

    @Override
    public String addNewGroup(Group group) {
        return null;
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
