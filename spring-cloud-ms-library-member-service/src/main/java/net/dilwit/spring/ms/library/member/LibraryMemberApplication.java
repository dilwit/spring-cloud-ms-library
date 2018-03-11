package net.dilwit.spring.ms.library.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LibraryMemberApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryMemberApplication.class, args);
	}
}
