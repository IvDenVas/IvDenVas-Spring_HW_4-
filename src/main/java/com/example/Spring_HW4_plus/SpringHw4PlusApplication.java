package com.example.Spring_HW4_plus;

import com.example.Spring_HW4_plus.config.ConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(ConfigProperties.class)
@SpringBootApplication
public class SpringHw4PlusApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHw4PlusApplication.class, args);
	}

}
