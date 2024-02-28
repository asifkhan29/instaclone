package com.instaclone.fiengCli;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "TESTMICRO" )
public interface GetFieng {
	
	@GetMapping("/get/")
	public String str();

}
