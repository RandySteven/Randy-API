package com.example.karaoke.entity.payload.response;

import com.example.karaoke.entity.model.Song;

import java.util.List;

public class GroupResponse {

    private String groupId;
    private String groupName;
    private List<Song> songs;

    public GroupResponse() {}

    public GroupResponse(String groupId, String groupName, List<Song> songs) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.songs = songs;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
