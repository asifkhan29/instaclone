package com.instaclone.TestMicroServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.instaclone.fiengCli.GetFieng;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private GetFieng getFieng;
	
	@GetMapping("/")
	public String st()
	{
		
		return getFieng.str();
		//return "str";
	}

}
