package net.dilwit.spring.ms.library.common.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
class Controller {	
	
    @RequestMapping("/welcome")
    String welcome() {
    	
    	StringBuilder sb = new StringBuilder("Welcome by common service");    	
        return sb.toString();
    }
}