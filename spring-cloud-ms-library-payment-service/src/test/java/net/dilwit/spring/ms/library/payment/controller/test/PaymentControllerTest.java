package net.dilwit.spring.ms.library.payment.controller.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.autoconfigure.RefreshAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.dilwit.spring.ms.library.payment.controller.Controller;
import net.dilwit.spring.ms.library.payment.domain.Payment;
import net.dilwit.spring.ms.library.payment.exception.InvalidDataException;
import net.dilwit.spring.ms.library.payment.service.PaymentService;

@RunWith(SpringRunner.class)
@WebMvcTest(Controller.class) // This annotation only load provided controller, not whole spring context
@ImportAutoConfiguration(RefreshAutoConfiguration.class)
public class PaymentControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PaymentService paymentService;
	
	@Test
	public void pay_shouldMakePaymentSuccessFully() throws Exception {
		
		// given
		Map<String, String> dataMap = new HashMap<>();	
		BDDMockito.given(paymentService.process(dataMap)).willReturn(Payment.Status.SUCESS);
		
		// when
		String content = new ObjectMapper().writeValueAsString(dataMap);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/pay")
						.contentType(MediaType.APPLICATION_JSON)
						.content(content))
		
		// then
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void pay_shouldThrow400ErrorWhenInvalidDataProvided() throws Exception {
		
		// given
		Map<String, String> dataMap = new HashMap<>();	
		BDDMockito.given(paymentService.process(dataMap)).willThrow(new InvalidDataException());
		
		// when
		String content = new ObjectMapper().writeValueAsString(dataMap);
		mockMvc.perform(MockMvcRequestBuilders.post("/pay")
						.contentType(MediaType.APPLICATION_JSON)
						.content(content))
		
		// then
		.andExpect(MockMvcResultMatchers.status().is4xxClientError());	
	}

}
