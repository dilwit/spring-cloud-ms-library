package net.dilwit.spring.ms.library.payment.service.test;

import java.util.HashMap;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import net.dilwit.spring.ms.library.payment.domain.Payment;
import net.dilwit.spring.ms.library.payment.domain.Payment.Status;
import net.dilwit.spring.ms.library.payment.exception.InvalidDataException;
import net.dilwit.spring.ms.library.payment.service.PaymentService;
import net.dilwit.spring.ms.library.payment.service.repo.PaymentRepo;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PaymentServiceTest {
	
	@Mock
	private PaymentRepo paymentRepo;
	
	private PaymentService paymentService;
	
	@Before
	public void setup() {
		paymentService = new PaymentService(paymentRepo);
	}
	
	@Test(expected = InvalidDataException.class)
	public void process_shouldThorwExceptionWhenInvalidDataProvided() {
		
		// given
		
		// when
		paymentService.process(null);
		
		// when
		Map<String, String> dataMap = new HashMap<>();	
		paymentService.process(dataMap);
		
		// then
	}
	
	
	@Test
	public void process_shouldReturnSuccessWhenPaymentProcessedSuccessfully() {
		
		Payment payment = new Payment();
		payment.setStatus(Payment.Status.SUCESS);

		// given
		BDDMockito.given(paymentRepo.save(any(Payment.class))).willReturn(payment);
		
		// when
		Map<String, String> paymentData = new HashMap<>();	
		paymentData.put("cardNumber", "1");
		paymentData.put("amount", "1");
		
		Status paymentStatus = paymentService.process(paymentData);
		
		// then
		Assertions.assertThat(paymentStatus).isEqualTo(Payment.Status.SUCESS);
	}

}
