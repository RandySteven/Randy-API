package com.example.karaoke.entity.payload.request;

import java.util.Map;

public class SongRequest {

    private String adderName;
    private String songName;
    private String link;
    private String groupToken;

    public String getAdderName() {
        return adderName;
    }

    public void setAdderName(String adderName) {
        this.adderName = adderName;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getGroupToken() {
        return groupToken;
    }

    public void setGroupToken(String groupToken) {
        this.groupToken = groupToken;
    }

    public SongRequest(){}
}
