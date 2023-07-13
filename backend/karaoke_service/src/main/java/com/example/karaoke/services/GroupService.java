package com.example.karaoke.services;

import com.example.karaoke.entity.model.Group;

import java.util.List;

public interface GroupService {
    String addNewGroup(Group group);
    List<Group> getAllGroups();
    Group getGroupByGroupId(String groupId);
}
