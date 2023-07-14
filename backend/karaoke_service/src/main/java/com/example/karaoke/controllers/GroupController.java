package com.example.karaoke.controllers;

import com.example.karaoke.entity.payload.request.GroupRequest;
import com.example.karaoke.services.GroupService;
import com.example.karaoke.utils.ResponseUtil;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/randy-steven/v1.0/karaoke/groups/")
public class GroupController {

    @Autowired
    GroupService groupService;

    private static final String ADD_GROUP_ENDPOINT = "add-group";
    private static final String GET_ALL_GROUPS_ENDPOINT = "/";
    private static final String GET_GROUP_BY_GROUP_ID_ENDPOINT = "/{groupId}";

    private static final Logger LOGGER = LoggerFactory.getLogger(GroupController.class);

    ResponseUtil responseUtil = ResponseUtil.getInstance();

    ResponseEntity responseEntity;

    @PostMapping(ADD_GROUP_ENDPOINT)
    public ResponseEntity addNewGroup(@RequestBody GroupRequest groupRequest) {
        String groupAccessToken = groupService.addNewGroup(groupRequest);
        JSONObject response = responseUtil.responseJSON(HttpStatus.CREATED, "groupAccessToken", groupAccessToken, true);
        responseEntity = ResponseEntity.status(HttpStatus.CREATED).body(response);
        return responseEntity;
    }
}
