package com.example.karaoke.test.api.test.action;

import com.example.karaoke.test.api.action.CommonApiAction;
import org.apache.hc.core5.http.HttpResponse;
import org.bson.json.JsonObject;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class GroupApiAction extends CommonApiAction {


    private static final String ADD_GROUP_ENDPOINT = "/randy-steven/v1.0/karaoke/groups/add-group";
    private static final String GET_ALL_GROUPS_ENDPOINT = "/";
    private static final String GET_GROUP_BY_GROUP_ID_ENDPOINT = "/{groupId}";
    private static final String GET_GROUP_BY_GROUP_TOKEN_ENDPOINT = "/validate";
    private static final String DELETE_GROUP_BY_GROUP_ID_ENDPOINT = "/delete-group/{groupId}";

    private static final Logger LOGGER = LoggerFactory.getLogger(GroupApiAction.class);

    private static final String REQUEST_ADD_GROUP_JSON_PATH = "src/test/resources/testcase/component/json/payload/AddGroup.request.json";

    public HttpResponse addGroupApiAction(Map<String, String> requestHeader,
                                          Map<String, Object> contextOverwrite) throws Exception{
        String requestBody = createRequestBody(REQUEST_ADD_GROUP_JSON_PATH, contextOverwrite);
        LOGGER.info("=== request body : {}", new JSONObject(requestBody));
        HttpResponse response = post(ADD_GROUP_ENDPOINT, requestHeader, requestBody);
        LOGGER.info("=== response : {}", new JSONObject(response));
        return response;
    }

    public HttpResponse getAllGroupsApiAction(){
        return null;
    }

}
