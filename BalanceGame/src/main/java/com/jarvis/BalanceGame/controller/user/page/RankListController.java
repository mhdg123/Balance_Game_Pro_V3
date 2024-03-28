package com.jarvis.BalanceGame.controller.user.page;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.model.dto.QuestionDTO;
import com.jarvis.BalanceGame.service.MemberService;

@Controller
@RequestMapping("/user")
public class RankListController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/rankListPage")
	public String rankListPage(MemberDTO mDTO, Model model) {
		System.out.println("랭킹페이지 이동");
		
		mDTO.setSearchCondition("rankingPoint");
		List<MemberDTO> datas = memberService.selectAll(mDTO);
		System.out.println(datas);
		
		
		
		if(datas != null) {
			model.addAttribute("memberDatas", datas);
		}else {
			model.addAttribute("status", "fail");
			model.addAttribute("msg", "출력할 회원이없습니다.");
			model.addAttribute("redirect", "");
			return "alert";
		}

		
		
		return "user/rankList";
	}
}
