package com.jarvis.BalanceGame.controller.user.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.service.MemberService;

public class IdCheckAsync {
	
	@Autowired
	private MemberService memberService;
	
	
	@RequestMapping("/idCheckAsync")
	public @ResponseBody String idCheckAsync(MemberDTO mDTO, Model model) {
		
		mDTO.setSearchCondition("중복확인");
		MemberDTO idDoubleCheckRes = memberService.selectOne(mDTO);
		
		if (idDoubleCheckRes != null) {
			System.out.println(idDoubleCheckRes.getLoginId() + " 는 중복된 아이디 ");
			return "1";
			
		}
	
		System.out.println("사용 가능한 아이디");
		return "0";


}
}