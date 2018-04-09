package net.dilwit.spring.ms.library.payment.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.dilwit.spring.ms.library.payment.domain.Payment;
import net.dilwit.spring.ms.library.payment.service.i.IPaymentService;
import net.dilwit.spring.ms.library.payment.service.repo.PaymentRepo;

@Service
public class PaymentService implements IPaymentService {
	
	protected PaymentRepo repo;
	
	@Autowired
	public PaymentService(PaymentRepo repo) {
		this.repo = repo;
	}

	@Override
	public Long process(Map<String, String> paymentData) {
		Payment payment = new Payment(paymentData.get("cardNumber"), paymentData.get("amount"), Payment.Status.valueOf(paymentData.get("status")));
		return repo.save(payment).getId();
	}
}
