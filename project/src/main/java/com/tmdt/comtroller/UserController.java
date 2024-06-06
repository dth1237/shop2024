package com.tmdt.comtroller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class UserController {
	@RequestMapping("/logon")
	public String logon() {
		return "/admin/logon";
	}
	@GetMapping("/logon")
	public String login() {
	    return "/admin/logon";
	
	}
	

}

