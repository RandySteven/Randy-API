package com.example.karaoke.entity.payload.request;

import com.example.karaoke.entity.model.Lyric;

import java.util.Map;

public class SongRequest {

    private String adderName;
    private String songName;
    private String link;
    private Map<String, Lyric> lyricMap;
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

    public Map<String, Lyric> getLyricMap() {
        return lyricMap;
    }

    public void setLyricMap(Map<String, Lyric> lyricMap) {
        this.lyricMap = lyricMap;
    }

    public String getGroupToken() {
        return groupToken;
    }

    public void setGroupToken(String groupToken) {
        this.groupToken = groupToken;
    }

    public SongRequest(){}
}
