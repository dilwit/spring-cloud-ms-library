package net.dilwit.spring.ms.library.payment.service.i;

import java.util.Map;

public interface IPaymentService {

	Long process(Map<String, String> paymentData);

}
