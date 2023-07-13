package com.example.karaoke.controllers;

import com.example.karaoke.services.GroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class GroupController {

    @Autowired
    GroupService groupService;

    private static final String ADD_GROUP_ENDPOINT = "";
    private static final String GET_ALL_GROUPS_ENDPOINT = "";
    private static final String GET_GROUP_BY_GROUP_ID_ENDPOINT = "";

    private static final Logger LOGGER = LoggerFactory.getLogger(GroupController.class);

}
