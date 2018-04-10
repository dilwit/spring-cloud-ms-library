package net.dilwit.spring.ms.library.payment.service.i;

import java.util.Map;

import net.dilwit.spring.ms.library.payment.domain.Payment.Status;

public interface IPaymentService {

	Status process(Map<String, String> paymentData);

}
