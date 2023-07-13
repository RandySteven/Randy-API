package com.example.karaoke.repository;

import com.example.karaoke.entity.model.Song;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SongRepository extends MongoRepository<Song, String> {
}
