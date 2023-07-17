package com.example.karaoke.services;

import com.example.karaoke.entity.model.Song;
import com.example.karaoke.entity.payload.request.LyricRequest;
import com.example.karaoke.entity.payload.request.SongRequest;

import java.util.List;

public interface SongService {
    Song insertNewSong(SongRequest songRequest);
    List<Song> getAllSongs(String groupId);
    Song updateSongStatus(String id);
    Song getSongBySongId(String songId);
    Song addLyricToSong(String songId, LyricRequest lyricRequest);
}
