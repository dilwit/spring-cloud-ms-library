package net.dilwit.spring.ms.library.payment.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.dilwit.spring.ms.library.payment.service.i.IPaymentService;

@RefreshScope
@RestController
class Controller {	
	
	@Autowired
	IPaymentService paymentService;
	
    @RequestMapping("/welcome")
    String welcome() {
    	
    	StringBuilder sb = new StringBuilder("Welcome by common service");    	
        return sb.toString();
    }
    
    @RequestMapping("/pay")
    public ResponseEntity<Void> register(@RequestBody Map<String, String> paymentData) {
    	paymentService.process(paymentData);
    	return ResponseEntity.ok().build();
    }
}