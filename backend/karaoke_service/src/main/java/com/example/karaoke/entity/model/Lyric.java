package com.example.karaoke.entity.model;

import com.example.karaoke.enums.Language;

import java.time.LocalDateTime;

public class Lyric {

    private String lyricText;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    public String getLyricText() {
        return lyricText;
    }

    public void setLyricText(String lyricText) {
        this.lyricText = lyricText;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }


    public Lyric(){}
}
