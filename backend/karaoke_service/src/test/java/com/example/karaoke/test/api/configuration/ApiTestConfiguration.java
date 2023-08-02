package com.example.karaoke.test.api.configuration;

import com.example.karaoke.test.api.test.action.GroupApiAction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiTestConfiguration {

    @Bean
    public GroupApiAction groupApiAction(){
        return new GroupApiAction();
    }

}
