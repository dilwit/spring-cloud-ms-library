package net.dilwit.spring.ms.library.member.service.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "spring-cloud-ms-library-payment-service", fallback = PaymentServiceClientFallBack.class)
public interface PaymentServiceClient {

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
    String hello();
	
	@RequestMapping(value = "/pay", method = RequestMethod.POST)
    String pay();
}
