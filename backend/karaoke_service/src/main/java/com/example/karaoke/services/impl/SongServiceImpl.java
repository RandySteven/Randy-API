package com.example.karaoke.services.impl;

import com.example.karaoke.entity.model.Group;
import com.example.karaoke.entity.model.Lyric;
import com.example.karaoke.entity.model.Song;
import com.example.karaoke.entity.payload.request.LyricRequest;
import com.example.karaoke.entity.payload.request.SongRequest;
import com.example.karaoke.enums.SongStatus;
import com.example.karaoke.repository.GroupRepository;
import com.example.karaoke.repository.SongRepository;
import com.example.karaoke.services.GroupService;
import com.example.karaoke.services.SongService;
import com.example.karaoke.utils.VelocityUtil;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    SongRepository songRepository;

    @Autowired
    GroupService groupService;

    VelocityUtil vu = VelocityUtil.getInstance();

    private static final Logger LOGGER = LoggerFactory.getLogger(SongServiceImpl.class);

    @Override
    public Song insertNewSong(SongRequest songRequest) {
        LOGGER.info("=== song request : {}", JSONObject.wrap(songRequest));
        Song song = new Song();
        song.setAdderName(
                songRequest.getAdderName() != null ?
                        songRequest.getAdderName() :
                        vu.generateRandomName()
        );
        song.setSongName(songRequest.getSongName());
        song.setLink(songRequest.getLink());
        song.setGroup(
                groupService.getGroupByGroupToken(songRequest.getGroupToken())
        );
        song.setSongStatus(SongStatus.WAITING_LIST);
        song.setSongId(vu.songId());
        song.setCreatedAt(LocalDateTime.now());
        song.setUpdatedAt(null);
        song.setDeletedAt(null);
        Song postedSong = songRepository.insert(song);
        LOGGER.info("=== post song request : {}", JSONObject.wrap(songRequest));
        return postedSong;
    }

    @Override
    public List<Song> getAllSongs(String groupId) {
        Group group = groupService.getGroupByGroupId(groupId);
        List<Song> songs = songRepository.findByGroup(group);
        return songs;
    }

    @Override
    public Song updateSongStatus(String id) {
        Song song = songRepository.findById(id).get();
        song.setSongStatus(SongStatus.DONE);
        songRepository.save(song);
        return song;
    }

    @Override
    public Song getSongBySongId(String songId) {
        Song song = songRepository.findSongBySongId(songId);
        return song;
    }

    @Override
    public Song addLyricToSong(String songId, LyricRequest lyricRequest) {
        Song song = getSongBySongId(songId);
        Lyric lyric = new Lyric();
        lyric.setLyricText(lyricRequest.getLyricText());
        lyric.setCreatedAt(LocalDateTime.now());
        if(song.getLyricMap() == null){
            song.setLyricMap(new HashMap<String, Lyric>(){{
                put(lyricRequest.getLanguage().getLanCode(), lyric);
            }});
        }else{
            song.getLyricMap().put(lyricRequest.getLanguage().getLanCode(), lyric);
        }

        Song updateSong = songRepository.save(song);
        return updateSong;
    }
}
