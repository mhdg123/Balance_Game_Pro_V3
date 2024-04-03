package com.jarvis.BalanceGame.controller.user.page;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.CommentDTO;
import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.model.dto.MemberItemDTO;
import com.jarvis.BalanceGame.model.dto.PageInfoDTO;
import com.jarvis.BalanceGame.service.CommentService;
import com.jarvis.BalanceGame.service.MemberItemService;
import com.jarvis.BalanceGame.service.MemberService;
import com.jarvis.BalanceGame.service.PageInfoService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class MyPageController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MemberItemService memberItemService;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private PageInfoService pageInfoService;
	
	@GetMapping("/myInfoPage")
	public String myPageController(MemberDTO mDTO,PageInfoDTO pDTO, CommentDTO cDTO, Model model,MemberItemDTO miDTO, HttpSession session) {
		System.out.println("마이페이지 들어옴");
		mDTO.setLoginId((String)session.getAttribute("loginId"));
		miDTO.setLoginId((String)session.getAttribute("loginId"));
		cDTO.setLoginId((String)session.getAttribute("loginId"));
		
		mDTO.setSearchCondition("myInfo");
		System.out.println(session.getAttribute("loginId"));
		
		String loginId = (String)session.getAttribute("loginId");
		mDTO.setLoginId(loginId);
		model.addAttribute("memberData", memberService.selectOne(mDTO));
		System.out.println(memberService.selectOne(mDTO)+"<<<<<<");
		
		List<MemberItemDTO> midatas = memberItemService.selectAll(miDTO);
		
		
		if(pDTO.getCurrentPage() == 0) {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<");
			pDTO.setCurrentPage(1);
		}
		
		pDTO.setLoginId(loginId);
		pDTO.setPasingnationSize(10);
		
		pDTO.setOffset(pageInfoService.calculateOffset(pDTO));
		System.out.println(pDTO.getOffset());
		pDTO.setSearchCondition("userComments");
		System.out.println("pDTO" + pDTO);
		List<PageInfoDTO> datas = pageInfoService.selectAll(pDTO);
		
		cDTO.setSearchCondition("commentsCntMember");
		cDTO = commentService.selectOne(cDTO);
		System.out.println(cDTO);
		pDTO.setTotalRows(cDTO.getCnt());
		int totalPage = pageInfoService.calcTotalPages(pDTO);	// 총페이지 수
		

		System.out.println(totalPage);
		
			model.addAttribute("commentDatas", datas);
			model.addAttribute("totalPage", totalPage);
			model.addAttribute("memberItemDatas", midatas);
			model.addAttribute("page", pDTO.getCurrentPage());


		System.out.println(datas);
		
		
		return "user/myInfo";
	}
}