package com.example.karaoke.utils;

import com.example.karaoke.enums.ServiceId;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.util.Properties;
import java.util.Random;

public class VelocityUtil {

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBER = "0123456789";

    private Random rand = new Random();

    Properties properties = new Properties();

    @Autowired
    Environment env;
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
        return properties.get(key);
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

    public String generateRandomName(){
        String []animals = new String[]{
                "PANDA",
                "RACOON",
                "OWL",
                "PENGUIN",
                "PUPPY",
                "CAT",
                "BUFFALO"
        };
        String animal = animals[(int)(Math.random()*animals.length)];
        return animal + " " + rand.nextInt(100);
    }

    public String generateNumberDigits(int len){
        String numberDigits = "01234567890";
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for(int i = 0 ; i < len ; i++){
            char numberDigit = numberDigits.charAt(random.nextInt(10));
            builder.append(numberDigit);
        }
        return builder.toString();
    }

    public String jsonToJsonString(Object object){
        JSONObject json = new JSONObject(object);
        return json.toString();
    }
}
