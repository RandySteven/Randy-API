package com.example.karaoke.utils;

import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;

@Component
public class SecurityUtil {

    public String groupAccessTokenEncryptionSHA512(String groupName, String groupPassword){
        String accessToken = "";
        int saltRange = 10;
        String pass = groupName;
        if(groupPassword == "" || groupPassword == null){
            saltRange = groupPassword.length();
            pass += groupPassword;
        }
        SecureRandom secureRandom = new SecureRandom();
        byte []salt = new byte[saltRange];
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt);
            byte []hashedPassword = md.digest(pass.getBytes(StandardCharsets.UTF_8));
            accessToken = hashedPassword.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return accessToken;
    }

    public String groupPasswordEncryptionMD5(String groupPassword){
        byte []salt = new byte[10];
        String hashedPasswordStr = "";
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(salt);
            byte []hashedPassword = md.digest(groupPassword.getBytes(StandardCharsets.UTF_8));
            hashedPasswordStr = hashedPassword.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return hashedPasswordStr;
    }

}
