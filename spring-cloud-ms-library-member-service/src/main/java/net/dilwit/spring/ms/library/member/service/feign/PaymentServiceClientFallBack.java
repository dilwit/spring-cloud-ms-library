package net.dilwit.spring.ms.library.member.service.feign;

import org.springframework.stereotype.Component;

@Component
public class PaymentServiceClientFallBack implements PaymentServiceClient {

	@Override
	public String hello() {
		return "Service not available";
	}

	@Override
	public String pay() {
		// TODO Auto-generated method stub
		return null;
	}

}
