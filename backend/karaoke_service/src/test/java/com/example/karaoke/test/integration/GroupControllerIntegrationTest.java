package com.example.karaoke.test.integration;

import com.example.karaoke.controllers.GroupController;
import com.example.karaoke.entity.payload.request.GroupRequest;
import com.example.karaoke.services.GroupService;
import com.example.karaoke.services.SongService;
import com.example.karaoke.services.impl.GroupServiceImpl;
import com.example.karaoke.services.impl.SongServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import org.aspectj.apache.bcel.util.ClassPath;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
public class GroupControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    GroupService groupService;

    @MockBean
    SongService songService;

    private static final Logger LOGGER = LoggerFactory.getLogger(GroupControllerIntegrationTest.class);

    private static final String JSON_ADD_GROUP_PATH = "testcase/component/json/payload/AddGroup.request.json";
    private static final String JSON_ADD_GROUP_REQUEST_SCHEMA_PATH = "testcase/component/json/schema/AddGroupRequest.schema.json";
    private static final String JSON_ADD_GROUP_RESPONSE_SCHEMA_PATH = "testcase/component/json/schema/AddGroupResponse.schema.json";
    private static final String JSON_GET_ALL_GROUPS_SCHEMA_PATH = "testcase/component/json/schema/GetAllGroupsResponse.schema.json";

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void addGroupTest() throws Exception {
        Faker faker = new Faker();
        String groupName = faker.name().fullName();
        String groupPassword = faker.name().firstName() + "" + faker.number().digits(3);
        GroupRequest groupRequest = new GroupRequest();
        groupRequest.setGroupName(groupName);
        groupRequest.setGroupPassword(groupPassword);

        String expectedGroupToken = "random_group_token";

        when(groupService.addNewGroup(any(GroupRequest.class)))
                .thenReturn(expectedGroupToken);

        mockMvc.perform(post("/randy-steven/v1.0/karaoke/groups/add-group")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(groupRequest)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.data.groupAccessToken").value(expectedGroupToken))
                .andExpect(jsonPath("$.success").value(true));
    }

}
