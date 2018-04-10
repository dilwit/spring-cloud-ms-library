package net.dilwit.spring.ms.library.payment.controller;

import java.util.Map;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import net.dilwit.spring.ms.library.payment.exception.InvalidDataException;
import net.dilwit.spring.ms.library.payment.service.i.IPaymentService;

@RefreshScope
@RestController
public class Controller {	
	
	private IPaymentService paymentService;
	
	public Controller(IPaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
    @RequestMapping("/welcome")
    String welcome() {
    	
    	StringBuilder sb = new StringBuilder("Welcome by common service");    	
        return sb.toString();
    }
    
    @RequestMapping(name = "/pay", method = RequestMethod.POST)
    public ResponseEntity<Void> pay(@Validated @RequestBody Map<String, String> paymentData) {
    	paymentService.process(paymentData);
    	return ResponseEntity.ok().build();
    }
    
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private void dataValidationHandler(InvalidDataException e){}
    
    
}