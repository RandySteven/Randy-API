package com.example.karaoke.entity.payload.request;

public class GroupTokenRequest {

    private String groupToken;

    public String getGroupToken() {
        return groupToken;
    }

    public GroupTokenRequest(){

    }

    public GroupTokenRequest(String groupToken){
        this.groupToken = groupToken;
    }

}
