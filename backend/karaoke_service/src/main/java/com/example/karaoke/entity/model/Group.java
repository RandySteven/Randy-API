package com.example.karaoke.entity.model;

import java.time.LocalDateTime;
import java.util.List;

public class Group {
    private String id;
    private String groupId;
    private String groupName;
    private String groupPass;
    private String groupToken;
    private List<Song> songs;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
