package com.example.karaoke.services;

import com.example.karaoke.entity.model.Group;
import com.example.karaoke.entity.payload.request.GroupRequest;

import java.util.List;

public interface GroupService {
    String addNewGroup(GroupRequest groupRequest);
    List<Group> getAllGroups();
    Group getGroupByGroupId(String groupId);
    Group getGroupByGroupToken(String groupToken);
    void deleteGroupByGroupId(String groupId);
}
