package com.example.karaoke.controllers;

import com.example.karaoke.services.SongService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class SongController {

    @Autowired
    SongService songService;

    private static final String INSERT_SONG_ENDPOINT = "";
    private static final String GET_ALL_SONGS_ENDPOINT = "";
    private static final String GET_SONG_BY_GROUP_ID_ENDPOINT = "";

    private static final Logger LOGGER = LoggerFactory.getLogger(SongController.class);
}
