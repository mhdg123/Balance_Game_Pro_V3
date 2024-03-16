package com.jarvis.BalanceGame.controller.user.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.service.MemberService;

@Controller
@RequestMapping("/user")
public class IdCheckAsync {

	@Autowired
	private MemberService memberService;

	@PostMapping("/idCheckAsync")
	public @ResponseBody String idCheckAsync(MemberDTO mDTO) {
		System.out.println("아이디 중복확인 비동기 컨트롤러 ");
		mDTO.setSearchCondition("duplitcateCheck");
		MemberDTO idDoubleCheckRes = memberService.selectOne(mDTO);

		if (idDoubleCheckRes != null) {
			System.out.println(idDoubleCheckRes.getLoginId() + " 는 중복된 아이디 ");
			return "1";
		}

		System.out.println("사용 가능한 아이디");
		return "0";

	}
}