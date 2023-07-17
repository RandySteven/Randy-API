package com.example.karaoke.entity.payload.response.dto;

import com.example.karaoke.entity.model.Group;

public class GroupDTO {

    private String groupName;
    private String groupUrl;

    public GroupDTO(){
    }

    public GroupDTO(Group group){
        this.groupName = group.getGroupName();
        this.groupUrl = "http://localhost:8080/randy-steven/v1.0/karaoke/groups/"+group.getGroupId();
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupUrl() {
        return groupUrl;
    }

    public void setGroupUrl(String groupUrl) {
        this.groupUrl = groupUrl;
    }
}
