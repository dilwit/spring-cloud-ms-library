package net.dilwit.spring.ms.library.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LibraryInventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryInventoryApplication.class, args);
	}
}
