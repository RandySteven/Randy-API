package com.example.karaoke.test.api.action;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpResponse;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public abstract class ApiAction {

    protected static final String API_HOST = "http://localhost:8080";

    protected static URL url;

    protected static CloseableHttpClient httpClient;

    ObjectMapper objectMapper = new ObjectMapper();

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiAction.class);

    static {
        try {
            url = new URL(API_HOST);
            httpClient = HttpClients.createDefault();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    protected void init(){
        LOGGER.info("====== Just iniataion of API Action =====");
    }

    protected HttpPost post(String endpoint) {
        String url = API_HOST + endpoint;
        LOGGER.info("===== url : " + url);
        HttpPost post = new HttpPost(url);
        return post;
    }

    protected String createRequestBody(String jsonPath, Map<String, Object> contextOverwrite) throws FileSystemNotFoundException,
            FileNotFoundException, IOException {
        String requestBodyJson = new String(Files.readAllBytes(Paths.get(jsonPath)));
        Map<String, Object> dataMap = objectMapper.readValue(requestBodyJson, Map.class);
        for(Map.Entry<String, Object> context : contextOverwrite.entrySet()){
            dataMap.put(context.getKey(), context.getValue());
        }
        String updatedRequestBodyJson = objectMapper.writeValueAsString(dataMap);
        return updatedRequestBodyJson;
    }

    public abstract HttpResponse post(String endpoint, Map<String, String> requestHeader, String requestBody);

    public abstract HttpResponse post(String endpoint, Map<String, String> requestHeader, JSONObject requestBody);

    public abstract HttpResponse post(String endpoint, Map<String, String> requestHeader, Map<String, String> requestBody);

    public abstract HttpResponse get();

}
