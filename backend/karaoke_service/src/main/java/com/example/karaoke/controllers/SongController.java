package com.example.karaoke.controllers;

import com.example.karaoke.entity.model.Song;
import com.example.karaoke.entity.payload.request.SongRequest;
import com.example.karaoke.services.SongService;
import com.example.karaoke.utils.ResponseUtil;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/randy-steven/v1.0/karaoke/songs/")
public class SongController {

    @Autowired
    SongService songService;

    private static final String INSERT_SONG_ENDPOINT = "insert-song";
    private static final String GET_ALL_SONGS_ENDPOINT = "";
    private static final String GET_SONG_BY_GROUP_ID_ENDPOINT = "{groupId}";
    private static final String UPDATE_SONG_STATUS_BY_ID_ENDPOINT = "update-status/{id}";

    private static final Logger LOGGER = LoggerFactory.getLogger(SongController.class);

    ResponseEntity<Map<String, Object>> response;

    ResponseUtil responseUtil = ResponseUtil.getInstance();

    @PostMapping(INSERT_SONG_ENDPOINT)
    public ResponseEntity<Map<String, Object>> insertSong(@RequestBody SongRequest songRequest){
        Song song = songService.insertNewSong(songRequest);
        JSONObject responseJson = responseUtil.responseJSON(
                HttpStatus.CREATED,
                "song",
                song,
                true
        );
        response = ResponseEntity.status(HttpStatus.CREATED).body(responseJson.toMap());
        return response;
    }

    @GetMapping(GET_SONG_BY_GROUP_ID_ENDPOINT)
    public ResponseEntity<Map<String, Object>> getSongByGroupId(@PathVariable String groupId){
        LOGGER.info("=========== groupId : " + groupId);
        List<Song> songs = songService.getAllSongs(groupId);
        JSONObject responseJson = responseUtil.responseJSON(
                HttpStatus.OK,
                "songs",
                Song.songResponses(songs),
                true
        );
        response = ResponseEntity.status(HttpStatus.OK).body(responseJson.toMap());
        return response;
    }

    @PatchMapping(UPDATE_SONG_STATUS_BY_ID_ENDPOINT)
    public ResponseEntity<Map<String, Object>> updateSongStatus(@PathVariable String id){
        Song song = songService.updateSongStatus(id);
        JSONObject responseJson = responseUtil.responseJSON(
                HttpStatus.OK,
                "song",
                song.songResponse(),
                true
        );
        response = ResponseEntity.status(HttpStatus.OK).body(responseJson.toMap());
        return response;
    }

}
