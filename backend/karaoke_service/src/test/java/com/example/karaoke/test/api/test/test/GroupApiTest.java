package com.example.karaoke.test.api.test.test;

import com.example.karaoke.test.api.test.action.GroupApiAction;
import com.github.javafaker.Faker;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public class GroupApiTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(GroupApiTest.class);

    GroupApiAction groupApiAction = new GroupApiAction();

    @Test
    public void addGroupApiTest() throws Exception{
        Map<String, Object> requestBodyRewrite = new HashMap<>();
        Faker faker = new Faker();
        String groupName = faker.name().fullName();
        requestBodyRewrite.put("groupName", groupName);

        Map<String, String> requestHeader = new HashMap<>();
        requestHeader.put("Content-Type", "application/json");
        HttpResponse response = groupApiAction.addGroupApiAction(requestHeader, requestBodyRewrite);
        Assertions.assertEquals(HttpStatus.CREATED.value(), response.getCode());
    }

}
