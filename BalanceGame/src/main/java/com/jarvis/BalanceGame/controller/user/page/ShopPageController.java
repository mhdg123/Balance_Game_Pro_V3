package com.jarvis.BalanceGame.controller.user.page;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.ItemDTO;
import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.service.ItemService;
import com.jarvis.BalanceGame.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class ShopPageController {
   
   @Autowired
   private ItemService itemService;
   
   @Autowired
   private MemberService memberService;
   
  

   @GetMapping("/shopPage")
   public String shopPageController(ItemDTO iDTO, MemberDTO mDTO, Model model, HttpSession session) {
      System.out.println("상점 페이지 이동");
      
//       페이지 이동시 selectAll
//      
//       아이템 PK
//       아이템 이름
//       아임템 가격
//       로그인 아이디
//       이미지 url
//       유저 가지고 있는 포인트

      
      List<ItemDTO> data =  itemService.selectAll(iDTO);
//      MemberDTO loginData = memberService.selectOne(mDTO);
      model.addAttribute(data);
      
      String loginId = (String)session.getAttribute("loginId");
      mDTO.setLoginId(loginId);
      
      
      
      
      return "user/shop";
   }
}
