package com.jarvis.BalanceGame.controller.user.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class JoinPageController {
   
	@GetMapping("/joinPage")
   public String joinPageController() {
      System.out.println("회원가입 페이지 이동");
      return "/user/join";
   }
}
