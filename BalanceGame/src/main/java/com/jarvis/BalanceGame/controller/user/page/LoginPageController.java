package com.jarvis.BalanceGame.controller.user.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class LoginPageController {

   @GetMapping("/loginPage")
   public String loginPageController() {
      System.out.println("로그인 페이지 이동");
      return "/user/login";
   }
}