package com.jarvis.BalanceGame.controller.user.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jarvis.BalanceGame.model.dto.ItemDTO;
import com.jarvis.BalanceGame.model.dto.ItemLogDTO;
import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.model.dto.MemberItemDTO;
import com.jarvis.BalanceGame.model.dto.PaymentDTO;
import com.jarvis.BalanceGame.service.ItemLogService;
import com.jarvis.BalanceGame.service.ItemService;
import com.jarvis.BalanceGame.service.MemberItemService;
import com.jarvis.BalanceGame.service.MemberService;
import com.jarvis.BalanceGame.service.PaymentService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class ItemPurchase {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private ItemLogService itemLogService;
	
	@Autowired
	private MemberItemService memberItemService;
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("/itemPurchase")
	public String itemPurchase(MemberDTO mDTO, MemberItemDTO miDTO, ItemDTO iDTO, ItemLogDTO ilDTO, Model model, HttpSession session) {
		
		// 여기서 해야하는것
		// 유저 포인트 업데이트
		// 유저 아이템 갯수 추가
		// 아이템 로그 추가
		
		
		String loginId = (String)session.getAttribute("loginId");
		mDTO.setLoginId(loginId);
		miDTO.setLoginId(loginId);
		
		
		//포인트 비교

		//막기
		
		
		
		if(memberItemService.selectOne(miDTO) == null) {
			miDTO.setMemberItemCount(1);
			memberItemService.insert(miDTO);
			mDTO.setSearchCondition("decreaseMyCoin");
			memberService.update(mDTO);
			itemLogService.insert(ilDTO);
			return "user/index";
		}
		miDTO.setSearchCondition("additionalPurchaseItem");
		memberItemService.update(miDTO);
		mDTO.setSearchCondition("decreaseMyCoin");
		memberService.update(mDTO);
		itemLogService.insert(ilDTO);
		
		//한개라도 실패
		
		
		
		mDTO.setSearchCondition("viewCoin");
		mDTO = memberService.selectOne(mDTO);
		session.setAttribute("coin", mDTO.getCoin());
		//성공!
		return "user/index";
	}
	
	@PostMapping("/coinpurchase")
	public String coinpurchase(MemberDTO mDTO, PaymentDTO pDTO, Model model, HttpSession session) {
		
		
		String loginId = (String)session.getAttribute("loginId");
		mDTO.setLoginId(loginId);
		
		paymentService.insert(pDTO);
		
		mDTO.setSearchCondition("increaseMyCoin");
		memberService.update(mDTO);
		
		mDTO.setSearchCondition("viewCoin");
		mDTO = memberService.selectOne(mDTO);
		
		session.setAttribute("coin", mDTO.getCoin());
		
		
		return "user/index";
	}
	
	
}
