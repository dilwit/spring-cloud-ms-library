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
import net.dilwit.spring.ms.library.payment.service.PaymentGateway;
import net.dilwit.spring.ms.library.payment.service.PaymentService;
import net.dilwit.spring.ms.library.payment.service.repo.PaymentRepo;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PaymentServiceTest {
	
	@Mock
	private PaymentRepo paymentRepo;
	
	@Mock 
	private PaymentGateway paymentGateway;
	
	private PaymentService paymentService;
	
	@Before
	public void setup() {
		paymentService = new PaymentService(paymentRepo, paymentGateway);
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
		
		Map<String, String> paymentData = new HashMap<>();	
		paymentData.put("cardNumber", "1");
		paymentData.put("amount", "1");

		// given
		BDDMockito.given(paymentGateway.verify(paymentData.get("cardNumber"), paymentData.get("amouont"), "DEBIT")).willReturn(Payment.Status.SUCESS);
		
		Payment payment = new Payment();
		payment.setStatus(Payment.Status.SUCESS);
		BDDMockito.given(paymentRepo.save(any(Payment.class))).willReturn(payment);
		
		// when		
		Status paymentStatus = paymentService.process(paymentData);
		
		// then
		Assertions.assertThat(paymentStatus).isEqualTo(Payment.Status.SUCESS);
	}
	
	@Test
	public void process_shouldReturnFailOnFailedBankTransaction() {
		
		Map<String, String> paymentData = new HashMap<>();	
		paymentData.put("cardNumber", "1");
		paymentData.put("amount", "1");

		// given
		BDDMockito.given(paymentGateway.verify(paymentData.get("cardNumber"), paymentData.get("amouont"), "DEBIT")).willReturn(Payment.Status.FAILED);
		
		Payment payment = new Payment();
		payment.setStatus(Payment.Status.FAILED);
		BDDMockito.given(paymentRepo.save(any(Payment.class))).willReturn(payment);
		
		// when		
		Status paymentStatus = paymentService.process(paymentData);
		
		// then
		Assertions.assertThat(paymentStatus).isEqualTo(Payment.Status.FAILED);
	}

}
