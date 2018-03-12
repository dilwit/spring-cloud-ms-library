package net.dilwit.spring.ms.library.member.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
class Controller {	
	
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
    	
        return sb.toString();
    }
}