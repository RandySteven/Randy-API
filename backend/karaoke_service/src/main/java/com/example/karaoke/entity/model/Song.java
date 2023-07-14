package com.example.karaoke.entity.model;

import com.example.karaoke.enums.SongStatus;

import java.util.Map;

public class Song {
    private String id;
    private String songId;
    private String groupAccessToken;
    private String adderName;
    private String link;
    private Map<String, Lyric> songLyric;
    private SongStatus songStatus;
}
