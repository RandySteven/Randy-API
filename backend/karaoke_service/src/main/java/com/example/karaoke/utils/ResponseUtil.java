package com.example.karaoke.utils;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ResponseUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResponseUtil.class);

    public ResponseUtil(){}

    public static ResponseUtil getInstance(){
        return new ResponseUtil();
    }

    public JSONObject responseJSON(HttpStatus status, String dataName, Object dataItem, boolean success){
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("responseCode", status.value());
        responseMap.put("responseMessage", status.getReasonPhrase());
        responseMap.put("dataName", dataItem);
        responseMap.put("success", success);
        JSONObject response = new JSONObject(responseMap);
        LOGGER.info("==== response : {}" , response);
        return response;
    }

}
