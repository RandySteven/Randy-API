package com.example.karaoke.services;

import com.example.karaoke.entity.model.Song;

import java.util.List;

public interface SongService {
    Song insertNewSong(Song song);
    List<Song> getAllSongs(String groupId);
}
