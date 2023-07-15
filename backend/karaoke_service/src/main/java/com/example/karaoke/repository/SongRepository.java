package com.example.karaoke.repository;

import com.example.karaoke.entity.model.Group;
import com.example.karaoke.entity.model.Song;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends MongoRepository<Song, String> {
    List<Song> findByGroupId(String groupId);
    List<Song> findByGroup(Group group);
}
