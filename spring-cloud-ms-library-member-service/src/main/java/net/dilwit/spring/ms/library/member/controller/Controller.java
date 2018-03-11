package net.dilwit.spring.ms.library.member.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
class Controller {	
	
	// @TODO: trigger refreshScope

    @Value("${system.version: Default version}")
    private String version;
    
    @Value("${system.welcome: Default welcome}")
    private String welcome;

    @RequestMapping("/systemInfo")
    String getMessage() {
    	
    	StringBuilder sb = new StringBuilder();
    	sb.append(this.version);
    	sb.append(" | ");
    	sb.append(this.welcome);
    	
        return sb.toString();
    }
}