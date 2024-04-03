package com.jarvis.BalanceGame.controller.user.page;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.model.dto.PageInfoDTO;
import com.jarvis.BalanceGame.service.MemberService;
import com.jarvis.BalanceGame.service.PageInfoService;

@Controller
@RequestMapping("/user")
public class RankListController {

	@Autowired
	private MemberService memberService;

	@Autowired
	private PageInfoService pageInfoService;

	@GetMapping("/rankListPage")
	public String rankListPage(MemberDTO mDTO, PageInfoDTO pDTO, Model model) {
		System.out.println("랭킹페이지 이동");

		if (Integer.valueOf(pDTO.getCurrentPage()) == null) {
			pDTO.setCurrentPage(1);
		}
		pDTO.setPasingnationSize(10);
		pageInfoService.calculateOffset(pDTO);
		pDTO.setSearchCondition("rankingPoint");
		List<PageInfoDTO> datas = pageInfoService.selectAll(pDTO);

		System.out.println(datas);

		mDTO.setSearchCondition("memberCnt");
		mDTO = memberService.selectOne(mDTO);
		System.out.println(mDTO);
		pDTO.setTotalRows(mDTO.getMemberCount());
		int totalPage = pageInfoService.calcTotalPages(pDTO); // 총페이지 수

		System.out.println(totalPage);

		if (datas != null) {
			model.addAttribute("memberDatas", datas);
			model.addAttribute("totalPage", totalPage);
			model.addAttribute("page", pDTO.getCurrentPage());
		} else {
			model.addAttribute("status", "fail");
			model.addAttribute("msg", "출력할 회원이없습니다.");
			model.addAttribute("redirect", "");
			return "alert";
		}

		return "user/rankList";
	}
}
