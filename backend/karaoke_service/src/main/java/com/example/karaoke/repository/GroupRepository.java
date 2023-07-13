package com.example.karaoke.repository;

import com.example.karaoke.entity.model.Group;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GroupRepository extends MongoRepository<Group, String> {
}
