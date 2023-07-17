package com.example.karaoke.utils;

import com.example.karaoke.entity.model.Song;
import com.example.karaoke.entity.payload.response.GroupResponse;
import com.example.karaoke.entity.payload.response.SongResponse;
import com.example.karaoke.entity.payload.response.dto.GroupDTO;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
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
        responseMap.put(dataName, dataItem);
        responseMap.put("success", success);
        JSONObject response = new JSONObject(responseMap);
        LOGGER.info("==== response : {}" , response);
        return response;
    }

    public GroupResponse getGroupResponseDetail(String groupId, GroupDTO groupDTO, List<Song> songs){
        GroupResponse groupResponse = new GroupResponse();
        groupResponse.setGroupId(groupId);
        groupResponse.setGroupName(groupDTO.getGroupName());
        groupResponse.setSongs(Song.songResponses(songs));
        return groupResponse;
    }

}
