package com.example.karaoke.test.unit;

import com.example.karaoke.controllers.GroupController;
import com.example.karaoke.entity.model.Group;
import com.example.karaoke.entity.payload.request.GroupRequest;
import com.example.karaoke.repository.GroupRepository;
import com.example.karaoke.services.GroupService;
import com.example.karaoke.services.impl.GroupServiceImpl;
import com.example.karaoke.utils.SecurityUtil;
import com.example.karaoke.utils.VelocityUtil;
import com.github.javafaker.Faker;
import org.assertj.core.api.Assert;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * <h2>Group Service Unit Test</h2>
 * @author : <b>randy.steven</b>
 * @description :
 * <p>Test the group service unit test function.</p>
 */
@TestPropertySource(locations = "classpath:application.properties")
@ExtendWith(MockitoExtension.class)
@SpringBootTest
@ActiveProfiles("test")
public class GroupControllerUnitTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(GroupControllerUnitTest.class);

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    GroupServiceImpl groupService;

    private SecurityUtil securityUtil = SecurityUtil.getInstance();

    private VelocityUtil vu = VelocityUtil.getInstance();

    /**
     * <h3>Test Add Group Normal Scenario</h3>
     * @throws Exception
     * @author <b>Randy Steven</b>
     * @description
     * <p>Happy path to add group scenario, with request groupName only
     * {"groupName":""}
     * </p>
     */
    @Test
    public void addGroupTest() throws Exception {
        GroupRequest request = new GroupRequest();
        Faker faker = new Faker();
        String groupName = faker.name().fullName();
        request.setGroupName(groupName);
        JSONObject requestJson = new JSONObject(request);
        LOGGER.info("request body {}", requestJson);
        String expectedGroupToken = securityUtil.groupAccessTokenEncryptionSHA512(groupName);
        String groupAccessToken = groupService.addNewGroup(request);
        LOGGER.info("=== groupAccessToken : " + groupAccessToken);
        Assertions.assertNotNull(groupAccessToken);
        Assertions.assertEquals(expectedGroupToken, groupAccessToken);
    }

    @Test
    public void addGroupWithPasswordTest() throws Exception{
        GroupRequest request = new GroupRequest();
        Faker faker = new Faker();
        String groupName = faker.name().fullName();
        String groupPassword = faker.name().firstName()+faker.number().digits(3).toString();
        request.setGroupName(groupName);
        request.setGroupPassword(groupPassword);
        LOGGER.info("=== group request : {}", JSONObject.wrap(request));
        String groupAccessToken = groupService.addNewGroup(request);
        String expectedGroupToken = securityUtil.groupAccessTokenEncryptionSHA512(groupName, groupPassword);
        Assertions.assertNotNull(groupAccessToken);
        Assertions.assertEquals(expectedGroupToken, groupAccessToken);
    }

    public void groupPasswordValidationTest() throws Exception {
        GroupRequest request = new GroupRequest();
        Faker faker = new Faker();
        String groupName = faker.name().fullName();
        String groupPassword = faker.name().firstName()+faker.number().digits(3).toString();
        request.setGroupName(groupName);
        request.setGroupPassword(groupPassword);
        groupService.addNewGroup(request);
        String expectedGroupPassword = securityUtil.groupPasswordEncryptionMD5(groupPassword);
    }

    @Test
    public void groupRequestValidationWithGroupNameMinLenTest() throws Exception{
        String groupName = vu.generateNumberDigits(2);
        boolean success = true;
        int groupNamelen = groupName.length();
        if(groupNamelen < 3 || groupNamelen > 32){
            success = false;
        }
        GroupRequest request = new GroupRequest();
        request.setGroupName(groupName);
        Map<String, Boolean> groupRequestValidation = securityUtil.groupRequestValidation(request);
        String result = groupService.addNewGroup(request);
        LOGGER.info("=== groupRequestValidation : " + groupRequestValidation.get("groupName"));
        Assertions.assertEquals(groupRequestValidation.get("groupName"), success);
        Assertions.assertEquals("", result);
    }

    @Test
    public void groupRequestValidationWithGroupNameMaxLenTest() throws Exception{
        String groupName = vu.generateNumberDigits(33);
        boolean success = true;
        int groupNamelen = groupName.length();
        if(groupNamelen < 3 || groupNamelen > 32){
            success = false;
        }
        GroupRequest request = new GroupRequest();
        request.setGroupName(groupName);
        Map<String, Boolean> groupRequestValidation = securityUtil.groupRequestValidation(request);
        String result = groupService.addNewGroup(request);
        LOGGER.info("=== groupRequestValidation : " + groupRequestValidation.get("groupName"));
        Assertions.assertEquals(groupRequestValidation.get("groupName"), success);
        Assertions.assertEquals("", result);
    }

    @Test
    public void getAllGroupsTest() throws Exception {
        List<Group> groups = groupService.getAllGroups();
        Faker faker = new Faker();
        String groupName = faker.name().fullName();
        String groupPassword = faker.name().firstName()+faker.number().digits(3).toString();
        GroupRequest groupRequest = new GroupRequest();
        groupRequest.setGroupName(groupName);
        groupRequest.setGroupPassword(groupPassword);
        groupService.addNewGroup(groupRequest);
        Assertions.assertNotNull(groups);
        Assertions.assertNotEquals(0, groups.size());
        Assertions.assertEquals((groups.size()+1), groupService.getAllGroups().size());
    }

    @Test
    public void getGroupByGroupIdTest() throws Exception {
        List<Group> groupList = groupService.getAllGroups();
        int len = groupList.size();
        Random rand = new Random();
        int index = rand.nextInt(len - 1);
        Group expectedGroup = groupList.get(index);
        String expectedGroupId = expectedGroup.getGroupId();

        Group actualGroup = groupService.getGroupByGroupId(expectedGroupId);
        String actualGroupId = actualGroup.getGroupId();

        JSONObject expectedGroupJson = new JSONObject(expectedGroup);
        JSONObject actualGroupJson = new JSONObject(actualGroup);

        String expectedGroupJsonString = expectedGroupJson.toString();
        String actualGroupJsonString = actualGroupJson.toString();

        Assertions.assertEquals(expectedGroupId, actualGroupId);
        Assertions.assertEquals(expectedGroupJsonString, actualGroupJsonString);
    }

    @Test
    public void getGroupByGroupToken() throws Exception {
        List<Group> groupList = groupService.getAllGroups();
        int len = groupList.size();
        Random rand = new Random();
        int index = rand.nextInt(len - 1);
        Group expectedGroup = groupList.get(index);

        GroupRequest testRequest = new GroupRequest();
        testRequest.setGroupName(expectedGroup.getGroupName());
        testRequest.setGroupPassword(expectedGroup.getGroupPass());
        String actualToken = null;
        if(testRequest.getGroupPassword() == null){
            actualToken = securityUtil.groupAccessTokenEncryptionSHA512(testRequest.getGroupName());
        }else{
            actualToken = securityUtil.groupAccessTokenEncryptionSHA512(testRequest.getGroupName(),
                    testRequest.getGroupPassword());
        }

        Group expectedResult = groupService.getGroupByGroupToken(expectedGroup.getGroupToken());
        Group actualGroupResult = groupService.getGroupByGroupToken(actualToken);

        Assertions.assertEquals(
                new JSONObject(expectedGroup).toString(),
                new JSONObject(actualGroupResult).toString()
        );
        Assertions.assertEquals(
                vu.jsonToJsonString(expectedResult),
                vu.jsonToJsonString(actualGroupResult)
        );
        if(actualToken == expectedGroup.getGroupToken())
            Assertions.assertEquals(expectedGroup.getGroupToken(), actualToken);
    }

}
