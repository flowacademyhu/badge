package hu.flowacademy.badge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class BadgeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BadgeApplication.class, args);
	}

}

