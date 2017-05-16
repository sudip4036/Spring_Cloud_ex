package com.example;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import com.example.*;

@RefreshScope
@EnableDiscoveryClient
@SpringBootApplication
public class ReservationServiceApplication {
	
	@Value("${userList}")
	private String userList;
	
	@Bean
	CommandLineRunner dummyCLR(ReservationRepository reservationRepository) {
		String users[] = userList.split(",");
		return args -> {
			Stream.of(users)
					.forEach(name -> reservationRepository.save(new Reservation(name)));
			reservationRepository.findAll().forEach(System.out::println);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ReservationServiceApplication.class, args);
	}
}
