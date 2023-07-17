package com.example.karaoke.entity.model;

import com.example.karaoke.entity.model.Lyric;
import com.example.karaoke.entity.payload.response.SongResponse;
import com.example.karaoke.entity.payload.response.dto.SongDTO;
import com.example.karaoke.enums.SongStatus;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Document(collection = "songs")
public class Song {
    @MongoId
    private String id;
    private String songId;
    private String songName;
    private String adderName;
    private String link;
    private Group group;
    private Map<String, Lyric> lyricMap;
    private SongStatus songStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    public Song(){}

    public Song(String id, String songId, String adderName, String link, Group group, Map<String, Lyric> lyricMap, SongStatus songStatus, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
        this.id = id;
        this.songId = songId;
        this.adderName = adderName;
        this.link = link;
        this.group = group;
        this.lyricMap = lyricMap;
        this.songStatus = songStatus;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Map<String, Lyric> getLyricMap() {
        return lyricMap;
    }

    public void setLyricMap(Map<String, Lyric> lyricMap) {
        this.lyricMap = lyricMap;
    }

    public SongStatus getSongStatus() {
        return songStatus;
    }

    public void setSongStatus(SongStatus songStatus) {
        this.songStatus = songStatus;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    public SongResponse songResponse(){
        return new SongResponse(this);
    }

    public static List<SongResponse> songResponses(List<Song> songs){
        List<SongResponse> songResponses = new ArrayList<>();
        for(Song song : songs){
            songResponses.add(song.songResponse());
        }
        return songResponses;
    }

    public SongDTO songDTO(){
        return new SongDTO(this);
    }

    public static List<SongDTO> songDTOs(List<Song> songs){
        List<SongDTO> songDTOs = new ArrayList<>();
        for(Song song : songs){
            songDTOs.add(song.songDTO());
        }
        return songDTOs;
    }
}
