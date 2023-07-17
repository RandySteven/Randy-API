package com.example.karaoke.entity.payload.response.dto;

import com.example.karaoke.entity.model.Song;
import com.example.karaoke.enums.SongStatus;

import java.time.LocalDateTime;

public class SongDTO {
    private String adderName;
    private String link;
    private String songName;
    private SongStatus status;
    private LocalDateTime createdAt;
    private String hateoasURL;

    public String getHateoasURL() {
        return hateoasURL;
    }

    public void setHateoasURL(String hateoasURL) {
        this.hateoasURL = hateoasURL;
    }

    public SongDTO(Song song){
        this.adderName = song.getAdderName();
        this.songName = song.getSongName();
        this.status = song.getSongStatus();
        this.link = song.getLink();
        this.createdAt = song.getCreatedAt();
        this.hateoasURL = "http://localhost:8080/randy-steven/v1.0/karaoke/songs/song/" + song.getSongId();
    }

    public SongDTO(String adderName, String link, String songName, SongStatus status, LocalDateTime createdAt) {
        this.adderName = adderName;
        this.link = link;
        this.songName = songName;
        this.status = status;
        this.createdAt = createdAt;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
