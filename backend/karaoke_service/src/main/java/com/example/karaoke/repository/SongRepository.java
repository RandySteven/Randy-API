package com.example.karaoke.repository;

import com.example.karaoke.entity.model.Song;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@EnableMongoRepositories
public interface SongRepository extends MongoRepository<Song, String> {
}
