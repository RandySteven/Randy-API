package com.example.karaoke.utils;

import com.example.karaoke.enums.ServiceId;

import java.util.Properties;

public class VelocityUtil {

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBER = "0123456789";

    Properties properties = new Properties();

    public VelocityUtil(){

    }

    public static VelocityUtil getInstance(){
        return new VelocityUtil();
    }

    private String idGenerator(){
        StringBuilder id = new StringBuilder();
        String alphaNumeric = ALPHABET + NUMBER;
        for(int i = 0 ; i < 16 ; i++){
            char character = alphaNumeric.charAt((int)(Math.random() * alphaNumeric.length()));
            id.append(character);
        }
        return id.toString();
    }

    public Object p(String key){
        return properties.getProperty(key);
    }

    public String groupId(){
        return ServiceId.GRP.toString() + idGenerator();
    }

    public String songId(){
        return ServiceId.SNG.toString() + idGenerator();
    }

    public String lyricId(){
        return ServiceId.LYR.toString() + idGenerator();
    }

}
