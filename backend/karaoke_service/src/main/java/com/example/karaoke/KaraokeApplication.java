package com.example.karaoke;

import com.example.karaoke.configs.AppConfig;
import com.example.karaoke.utils.VelocityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@Import(AppConfig.class)
@EnableMongoRepositories("com.example.karaoke.repository")
public class KaraokeApplication {

	private static final VelocityUtil vu = VelocityUtil.getInstance();

	private static final Logger LOGGER = LoggerFactory.getLogger(KaraokeApplication.class);
	public static void main(String[] args) {
		LOGGER.info("================ Welcome To Karaoke Service ================");
		SpringApplication.run(KaraokeApplication.class, args);
	}

}
