package com.example.karaoke.test.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
public class GroupControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private static final Logger LOGGER = LoggerFactory.getLogger(GroupControllerIntegrationTest.class);

    private static final String JSON_ADD_GROUP_PATH = "";

    private static final String JSON_ADD_GROUP_SCHEMA_PATH = "";

    public void addGroupTest() throws Exception {

    }

}
