package com.jarvis.BalanceGame;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Test {
	@GetMapping({"/test","","/"})
	public  String test() {
		System.out.println("TEST 로그>");
		
		return "test";
	}
}
