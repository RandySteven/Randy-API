package com.example.karaoke;

import com.example.karaoke.configs.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@Import(AppConfig.class)
@EnableMongoRepositories("com.example.karaoke.repository")
public class KaraokeApplication {

	public static void main(String[] args) {
		SpringApplication.run(KaraokeApplication.class, args);
	}

}
