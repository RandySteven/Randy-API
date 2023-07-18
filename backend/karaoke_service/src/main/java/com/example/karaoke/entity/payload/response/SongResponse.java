package com.example.karaoke.entity.payload.response;

import com.example.karaoke.entity.model.Lyric;
import com.example.karaoke.entity.model.Song;
import com.example.karaoke.enums.SongStatus;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.util.Map;

public class SongResponse {

    private String adderName;
    private String link;
    private String songName;
    private SongStatus status;
    private JSONObject lyric;
    private LocalDateTime createdAt;

    public SongResponse(String adderName, String link, String songName, SongStatus status, JSONObject lyric, LocalDateTime createdAt) {
        this.adderName = adderName;
        this.link = link;
        this.songName = songName;
        this.status = status;
        this.lyric = lyric;
        this.createdAt = createdAt;
    }

    public SongResponse(Song song){
        this.adderName = song.getAdderName();
        this.link = song.getLink();
        this.songName = song.getSongName();
        this.status = song.getSongStatus();
        this.lyric = new JSONObject(song.getLyricMap());
        this.createdAt = song.getCreatedAt();
    }

    public String getAdderName() {
        return adderName;
    }

    public void setAdderName(String adderName) {
        this.adderName = adderName;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public SongStatus getStatus() {
        return status;
    }

    public void setStatus(SongStatus status) {
        this.status = status;
    }

    public JSONObject getLyric() {
        return lyric;
    }

    public void setLyric(JSONObject lyric) {
        this.lyric = lyric;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
