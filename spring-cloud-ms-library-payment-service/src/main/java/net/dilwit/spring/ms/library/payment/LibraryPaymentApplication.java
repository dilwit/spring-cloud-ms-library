package net.dilwit.spring.ms.library.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableDiscoveryClient
/*@EnableJpaAuditing*/
@EnableAutoConfiguration
public class LibraryPaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryPaymentApplication.class, args);
	}
}
