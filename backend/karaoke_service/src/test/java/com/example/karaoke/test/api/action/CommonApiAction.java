package com.example.karaoke.test.api.action;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class CommonApiAction extends ApiAction{

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonApiAction.class);

    @Override
    public HttpResponse post(String endpoint, Map<String, String> requestHeader, String requestBody) {
        HttpPost post = post(endpoint);
        if(requestHeader == null)
            LOGGER.info("===== You are not overwrite this value =====");
        for(Map.Entry<String, String> request : requestHeader.entrySet()){
            post.setHeader(request.getKey(), request.getValue());
        }
        post.setEntity(new StringEntity(requestBody));
        CloseableHttpResponse response = null;
        try{
            response = httpClient.execute(post);
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public HttpResponse post(String endpoint, Map<String, String> requestHeader, JSONObject requestBody) {
        HttpPost post = post(endpoint);
        if(requestHeader == null)
            LOGGER.info("===== You are not overwrite this value =====");
        for(Map.Entry<String, String> request : requestHeader.entrySet()){
            post.setHeader(request.getKey(), request.getValue());
        }
        String requestBodyString = requestBody.toString();
        post.setEntity(new StringEntity(requestBodyString));
        CloseableHttpResponse response = null;
        try{
            response = httpClient.execute(post);
        }catch(Exception e){
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public HttpResponse post(String endpoint, Map<String, String> requestHeader, Map<String, String> requestBody) {

        return null;
    }

    @Override
    public HttpResponse get(String endpoint, Map<String, String> requestHeader) {
        HttpGet get = get(endpoint);
        if(requestHeader == null)
            LOGGER.info("==== You are not overwrite this value ====");
        for(Map.Entry<String, String> request : requestHeader.entrySet()){
            get.setHeader(request.getKey(), request.getValue());
        }
        CloseableHttpResponse response = null;
        try{
            response = httpClient.execute(get);
        }catch(Exception e){
            e.printStackTrace();
        }
        return response;
    }
}
