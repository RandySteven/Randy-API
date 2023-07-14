package com.example.karaoke.enums;

public enum Language {
    EN("en"),
    JP("jp"),
    CN("cn");

    private String lanCode;

    Language(String lanCode){
        this.lanCode = lanCode;
    }

    public String getLanCode(){
        return lanCode;
    }
}
