package com.example.karaoke.entity.payload.response.dto;

import com.example.karaoke.entity.model.Group;

public class GroupDTO {

    private String groupName;
    private String groupUrl;

    public GroupDTO(){
    }

    public GroupDTO(Group group){
        this.groupName = group.getGroupName();
        this.groupUrl = "http://localhost:8080/randy-api/v1.0/karaoke/groups/"+group.getGroupId();
    }

}
