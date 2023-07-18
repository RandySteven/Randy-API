package com.example.karaoke.controllers;

import com.example.karaoke.entity.model.Group;
import com.example.karaoke.entity.model.Song;
import com.example.karaoke.entity.payload.request.GroupRequest;
import com.example.karaoke.entity.payload.response.GroupResponse;
import com.example.karaoke.entity.payload.response.dto.GroupDTO;
import com.example.karaoke.services.GroupService;
import com.example.karaoke.services.SongService;
import com.example.karaoke.utils.ResponseUtil;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/randy-steven/v1.0/karaoke/groups/")
public class GroupController {

    @Autowired
    GroupService groupService;

    @Autowired
    SongService songService;

    private static final String ADD_GROUP_ENDPOINT = "add-group";
    private static final String GET_ALL_GROUPS_ENDPOINT = "/";
    private static final String GET_GROUP_BY_GROUP_ID_ENDPOINT = "/{groupId}";

    private static final Logger LOGGER = LoggerFactory.getLogger(GroupController.class);

    ResponseUtil responseUtil = ResponseUtil.getInstance();

    ResponseEntity<Map<String, Object>> responseEntity;

    @PostMapping(ADD_GROUP_ENDPOINT)
    public ResponseEntity addNewGroup(@RequestBody GroupRequest groupRequest) {
        String groupAccessToken = groupService.addNewGroup(groupRequest);
        JSONObject response = new JSONObject();
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String dataName = null;
        Object dataItem = null;
        boolean success = false;
        if(groupAccessToken != ""){
            status = HttpStatus.OK;
            dataName = "groupAccessToken";
            dataItem = groupAccessToken;
            success = true;
        }
        response = responseUtil.responseJSON(status, dataName, dataItem, success);
        responseEntity = ResponseEntity.status(status).body(response.toMap());
        return responseEntity;
    }

    @GetMapping(GET_ALL_GROUPS_ENDPOINT)
    public ResponseEntity getAllGroups(){
        List<Group> groups = groupService.getAllGroups();
        List<GroupDTO> groupDTOS = new ArrayList<>();
        for (Group group : groups){
            groupDTOS.add(group.groupDTO());
        }
        JSONObject response = responseUtil.responseJSON(HttpStatus.OK, "groups", groupDTOS, true);
        responseEntity = ResponseEntity.status(HttpStatus.OK).body(response.toMap());
        return responseEntity;
    }

    @GetMapping(GET_GROUP_BY_GROUP_ID_ENDPOINT)
    public ResponseEntity getGroupByGroupId(@PathVariable String groupId){
        Group group = groupService.getGroupByGroupId(groupId);
        HttpStatus status = HttpStatus.NOT_FOUND;
        String dataName = null;
        boolean success = false;
        Object dataItem = null;
        if(group != null){
            status = HttpStatus.OK;
            dataName = "groups";
            success = true;
            GroupDTO groupDTO = group.groupDTO();
            List<Song> songs =  songService.getAllSongs(groupId);
            GroupResponse groupResponse = responseUtil.getGroupResponseDetail(groupId, groupDTO, songs);
            dataItem = groupResponse;
        }
        JSONObject response = responseUtil.responseJSON(status, dataName, dataItem, success);
        responseEntity = ResponseEntity.status(status).body(response.toMap());
        return responseEntity;
    }

}
