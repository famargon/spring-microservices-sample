package com.fapps.micro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubstracterController {

	@Autowired
	Environment environment;
	
	@GetMapping("/substract/{a}/{b}")
	public SubstractResult substract2Numbers(@PathVariable int a,@PathVariable int b) {
		int serverPort = Integer.parseInt(environment.getProperty("local.server.port"));
		return new SubstractResult(a-b, serverPort);
	}
	
}
