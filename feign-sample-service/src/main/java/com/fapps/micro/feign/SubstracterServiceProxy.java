package com.fapps.micro.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fapps.micro.RemoteSubstractResult;

@FeignClient(name="substracter-service")
@RibbonClient(name="substracter-service")
public interface SubstracterServiceProxy {

	@GetMapping("/substract/{a}/{b}")
	public RemoteSubstractResult substract2Numbers(@PathVariable("a") int a,@PathVariable("b") int b);
	
}
