package com.example.bct.EcommerceByArpit;

import com.example.bct.EcommerceByArpit.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class EcommerceByArpitApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceByArpitApplication.class, args);
	}

}
