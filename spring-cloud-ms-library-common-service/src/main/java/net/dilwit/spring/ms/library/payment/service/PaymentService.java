package net.dilwit.spring.ms.library.payment.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import net.dilwit.spring.ms.library.payment.service.i.IPaymentService;

@Service
public class PaymentService implements IPaymentService {

	@Override
	public void process(Map<String, String> paymentData) {
		
	}
}
