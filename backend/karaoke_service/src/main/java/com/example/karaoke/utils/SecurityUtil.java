package com.example.karaoke.utils;

import com.example.karaoke.entity.payload.request.GroupRequest;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

@Component
public class SecurityUtil {

    public SecurityUtil(){}

    public static SecurityUtil getInstance(){
        return new SecurityUtil();
    }

    public String groupAccessTokenEncryptionSHA512(String groupName){
        String accessToken = "";
        String pass = groupName;
        int saltRange = 10;
        byte []salt = new byte[saltRange];
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt);
            byte []hashedPassword = md.digest(pass.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < hashedPassword.length ; i++){
                sb.append(Integer.toString((hashedPassword[i] & 0xff) + 0x100, 16)).substring(1);
            }
            accessToken = sb.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return accessToken;
    }

    public String groupAccessTokenEncryptionSHA512(String groupName, String groupPassword){
        String accessToken = "";
        String pass = groupName + groupPassword;
        int saltRange = groupPassword.length();
        SecureRandom secureRandom = new SecureRandom();
        byte []salt = new byte[saltRange];
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt);
            byte []hashedPassword = md.digest(pass.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < hashedPassword.length ; i++){
                sb.append(Integer.toString((hashedPassword[i] & 0xff) + 0x100, 16)).substring(1);
            }
            accessToken = sb.toString();
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
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < hashedPassword.length ; i++){
                sb.append(Integer.toString((hashedPassword[i] & 0xff) + 0x100, 16)).substring(1);
            }
            hashedPasswordStr = sb.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return hashedPasswordStr;
    }

    public boolean checkGroupAccessToken(String groupToken){
        return true;
    }

    public Map<String, Boolean> groupRequestValidation(GroupRequest groupRequest){
        boolean groupNameValidation = true;
        Map<String, Boolean> validationRequestMap = new HashMap<>();
        if(groupRequest.getGroupName().length() < 3 && groupRequest.getGroupName().length() > 32) {
            groupNameValidation = false;
        }
        validationRequestMap.put("groupName", groupNameValidation);
        return validationRequestMap;
    }

}
