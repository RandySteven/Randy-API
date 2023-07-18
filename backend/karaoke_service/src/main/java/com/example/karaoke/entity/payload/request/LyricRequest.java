package com.example.karaoke.entity.payload.request;

import com.example.karaoke.enums.Language;

public class LyricRequest {

    private Language language;
    private String lyricText;

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getLyricText() {
        return lyricText;
    }

    public void setLyricText(String lyricText) {
        this.lyricText = lyricText;
    }
}
