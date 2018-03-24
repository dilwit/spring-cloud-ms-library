package net.dilwit.spring.ms.library.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.dilwit.spring.ms.library.member.controller.vm.RegistrationVM;
import net.dilwit.spring.ms.library.member.service.feign.PaymentServiceClient;
import net.dilwit.spring.ms.library.member.service.i.IMeberService;

@RefreshScope
@RestController
class Controller {	
	
	@Autowired
	PaymentServiceClient commonServiceClient;
	
	@Autowired
	IMeberService memberService;
	
	// @TODO: trigger refreshScope
    
    @Value("${system.welcome: Default welcome}")
    private String welcome;
    
    @Value("${spring.application.name}")
    private String appName;

    @RequestMapping("/welcome")
    String welcome() {
    	
    	StringBuilder sb = new StringBuilder();    	
    	sb.append(this.welcome);
    	sb.append(" | ");
    	sb.append(this.appName);
    	sb.append(" | ");
    	sb.append("And I'm connecting with - ");
    	sb.append(commonServiceClient.hello());
    	
        return sb.toString();
    }
    
    @RequestMapping("/register")
    public ResponseEntity<Void> register(@RequestBody RegistrationVM registrationVM) {
    	memberService.register(registrationVM);
    	return ResponseEntity.ok().build();
    }
}