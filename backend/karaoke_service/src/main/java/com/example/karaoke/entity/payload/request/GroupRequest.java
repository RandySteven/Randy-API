package com.example.karaoke.entity.payload.request;

public class GroupRequest {

    private String groupName;
    private String groupPassword;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupPassword() {
        return groupPassword;
    }

    public void setGroupPassword(String groupPassword) {
        this.groupPassword = groupPassword;
    }

    public GroupRequest(){}
}
