package com.jarvis.BalanceGame.controller.user.action;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.service.MemberService;
import com.jarvis.BalanceGame.service.NaverLoginService;

import jakarta.servlet.http.HttpSession;

@Controller
public class NaverLoginController {

	@Autowired
	NaverLoginService naverLoginService;
	
	@Autowired
	MemberService memberService;

	@Value("${encrypted.clientId}")
    private String naverClientId;
	
	@GetMapping("/naverLogin")
	public String naverLoginController(MemberDTO mDTO, @RequestParam("code") String code,
			@RequestParam("state") String state, Model model, HttpSession session) throws UnsupportedEncodingException {

		
		// 로그인 callback
		String LoginToken = naverLoginService.getToken(code, state);

		mDTO=naverLoginService.processNaverLogin(LoginToken,mDTO);


		MemberDTO memberData= memberService.selectOne(mDTO);
		//회원가입 페이지 이동
		if(memberData == null) {
			model.addAttribute("memberData", mDTO);
			model.addAttribute("status", "socialJoin");
			return "user/naverLogin";
		}
		
		// 로그인 성공
		session.setAttribute("loginId", memberData.getLoginId());
		session.setAttribute("coin", memberData.getCoin());
		session.setAttribute("commentStatus", memberData.getWriteStatus());
		model.addAttribute("status", "success");
		model.addAttribute("msg", memberData.getNickName() + "님 로그인 하셨습니다.");
		model.addAttribute("redirect", "/");
		return "alert";
		
	}
	
	//회원가입 이동
	@PostMapping("/naver/join")
	public String naverJoinPageController(MemberDTO mDTO,Model model) throws UnsupportedEncodingException {
		System.out.println("회원가입하러 들어옴 : "+mDTO);
		mDTO.setSearchCondition("socialLogin");
		model.addAttribute("memberData", mDTO);
		model.addAttribute("status", "socialJoin");
		
		return "user/join";
	}
	
	//클라이언트 아이디
	 @GetMapping("/getNaverClientId")
	 public @ResponseBody String getNaverClientId() {
	     return naverClientId;
	 }
	
}
