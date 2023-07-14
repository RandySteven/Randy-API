package com.example.karaoke;

import com.example.karaoke.configs.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(AppConfig.class)
public class KaraokeApplication {

	public static void main(String[] args) {
		SpringApplication.run(KaraokeApplication.class, args);
	}

}
