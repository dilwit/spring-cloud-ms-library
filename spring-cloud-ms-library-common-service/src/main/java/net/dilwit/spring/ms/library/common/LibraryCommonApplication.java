package net.dilwit.spring.ms.library.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LibraryCommonApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryCommonApplication.class, args);
	}
}
