package net.dilwit.spring.ms.library.payment.it;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) // This will load whole spring context.
public class PaymentIT {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void pay_onRegistration() throws Exception {
		// arrange
		
		// act
		ResponseEntity<Void> entity = restTemplate.getForEntity("/pay", Void.class);
		
		// assert
		Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

}
