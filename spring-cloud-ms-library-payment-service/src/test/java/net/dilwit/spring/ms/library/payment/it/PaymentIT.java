package net.dilwit.spring.ms.library.payment.it;

import java.util.HashMap;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import net.dilwit.spring.ms.library.payment.service.repo.PaymentRepo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) // This will load whole spring context.
public class PaymentIT {
	
	@Autowired
	private PaymentRepo repo;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void pay_shouldReturnOkOnSuccessfullRegistration() throws Exception {
		
		// arrange
		Map<String, String> paymentData = new HashMap<>();	
		paymentData.put("cardNumber", "1");
		paymentData.put("amount", "1");
		
		// act
		ResponseEntity<Void> result = restTemplate.postForEntity("/pay", paymentData, Void.class);
		
		// assert
		Assertions.assertThat(result.getStatusCode().is2xxSuccessful());
		
		// clean
		repo.deleteAll();
	}
}
