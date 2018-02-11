package com.fapps.micro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fapps.micro.feign.SubstracterServiceProxy;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class FeignSampleServiceController {

	private static Logger LOG = LoggerFactory.getLogger(FeignSampleServiceController.class);
	
	@Autowired
	private SubstracterServiceProxy proxy;
	
	@HystrixCommand(fallbackMethod="localSubstract")
	@GetMapping("/remoteSubstract/{a}/{b}")
	public RemoteSubstractResult remoteSubstract(@PathVariable int a,@PathVariable int b) {

		RemoteSubstractResult result = proxy.substract2Numbers(a, b);
		result.setServiceData("hello world");
		
		return result;
	}
	
	public RemoteSubstractResult localSubstract(int a, int b) {
		LOG.error("remote substract failed, using local substract");
		RemoteSubstractResult rsr = new RemoteSubstractResult();
		rsr.setResult(a-b);
		return rsr;
	}

}
