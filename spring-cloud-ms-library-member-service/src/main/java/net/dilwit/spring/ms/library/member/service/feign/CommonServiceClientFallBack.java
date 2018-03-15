package net.dilwit.spring.ms.library.member.service.feign;

import org.springframework.stereotype.Component;

@Component
public class CommonServiceClientFallBack implements CommonServiceClient {

	@Override
	public String hello() {
		return "Service not available";
	}

}
