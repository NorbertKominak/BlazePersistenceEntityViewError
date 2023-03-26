package com.example.demo;

import com.example.demo.cat.Cat;
import com.example.demo.cat.CatRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner demonstrateError(CatRepository repository) {

		Logger log = LoggerFactory.getLogger(DemoApplication.class);

		return args -> {
			log.info("Initializing cat " + repository.save(new Cat(1, 10)));
			log.info("Loading cat " + repository.find(1));
		};
	}

}
