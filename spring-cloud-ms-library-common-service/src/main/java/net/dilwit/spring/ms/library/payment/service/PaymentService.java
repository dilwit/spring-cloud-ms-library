package net.dilwit.spring.ms.library.payment.service;

import java.util.Map;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.dilwit.spring.ms.library.payment.domain.Payment;
import net.dilwit.spring.ms.library.payment.exception.InvalidDataException;
import net.dilwit.spring.ms.library.payment.service.i.IPaymentService;
import net.dilwit.spring.ms.library.payment.service.repo.PaymentRepo;

@Service
public class PaymentService implements IPaymentService {
	
	private PaymentRepo repo;
	
	@Autowired
	public PaymentService(PaymentRepo repo) {
		this.repo = repo;
	}

	@Override
	public Payment.Status process(Map<String, String> paymentData) {
		
		if(paymentData == null)
			throw new InvalidDataException();
		
		String cardNumber = paymentData.get("cardNumber");
		String amount = paymentData.get("amount");
		if(!ObjectUtils.allNotNull(cardNumber, amount))
			throw new InvalidDataException();
		
		// TODO@dilusha - Talk to bank to find out result
		
		Payment payment = new Payment(cardNumber, amount, Payment.Status.SUCESS);
		return repo.save(payment).getStatus();
	}
}
