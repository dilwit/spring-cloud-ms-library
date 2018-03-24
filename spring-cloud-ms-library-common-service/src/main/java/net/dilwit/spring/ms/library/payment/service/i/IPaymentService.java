package net.dilwit.spring.ms.library.payment.service.i;

import java.util.Map;

public interface IPaymentService {

	void process(Map<String, String> paymentData);

}
