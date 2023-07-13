package com.example.karaoke.services.impl;

import com.example.karaoke.entity.model.Song;
import com.example.karaoke.repository.SongRepository;
import com.example.karaoke.services.SongService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    SongRepository songRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(SongServiceImpl.class);

    @Override
    public Song insertNewSong(Song song) {
        return null;
    }

    @Override
    public List<Song> getAllSongs(String groupId) {
        return null;
    }
}
