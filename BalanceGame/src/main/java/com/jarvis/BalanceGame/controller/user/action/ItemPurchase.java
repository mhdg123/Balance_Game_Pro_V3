package com.jarvis.BalanceGame.controller.user.action;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
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
	public String itemPurchase(MemberDTO mDTO, MemberItemDTO miDTO, ItemDTO iDTO, ItemLogDTO ilDTO, Model model,
			HttpSession session) {

		// 여기서 해야하는것
		// 유저 포인트 업데이트
		// 유저 아이템 갯수 추가
		// 아이템 로그 추가

		String loginId = (String) session.getAttribute("loginId");
		mDTO.setLoginId(loginId);
		miDTO.setLoginId(loginId);
		int coin = (int) session.getAttribute("coin");
		mDTO.setCoin(coin);
		iDTO.setSearchCondition("itemViewOne");
		iDTO = itemService.selectOne(iDTO);
		System.out.println(mDTO.getCoin());
		System.out.println(iDTO.getItemPrice());

		// 포인트 비교
		if (mDTO.getCoin() >= iDTO.getItemPrice()) {

			// 막기
			
			if (memberItemService.selectOne(miDTO) == null) {
				miDTO.setMemberItemCount(1);
				memberItemService.insert(miDTO);

				// 멤버 포인트 에서 아이템 포인트 차감하기
				mDTO.setSearchCondition("decreaseMyCoin");
				memberService.update(mDTO);
				
				// 맴버 업데이트 쿼리문 필요
				itemLogService.insert(ilDTO);

				mDTO.setSearchCondition("viewCoin");
				mDTO = memberService.selectOne(mDTO);
				session.setAttribute("coin", mDTO.getCoin());

				return "user/index";
			}
			miDTO.setSearchCondition("additionalPurchaseItem");
			memberItemService.update(miDTO);
			itemLogService.insert(ilDTO);
			
			// 한개라도 실패
			
			mDTO.setSearchCondition("decreaseMyCoin");
			memberService.update(mDTO);
			


			mDTO.setSearchCondition("viewCoin");
			mDTO = memberService.selectOne(mDTO);
			session.setAttribute("coin", mDTO.getCoin());
			// 성공!
			return "user/shop";
		}
		model.addAttribute("status", "fail");
		model.addAttribute("msg", "포인트가 부족합니다");
		model.addAttribute("redirect", "/");
		return "alert";
	}

	@PostMapping("/coinpurchase")
	public @ResponseBody String coinpurchase(MemberDTO mDTO, PaymentDTO pDTO, Model model, HttpSession session,
			Map<String, String> datas) {

		Gson gson = new Gson();
		String loginId = (String) session.getAttribute("loginId");
		mDTO.setLoginId(loginId);

		pDTO.setSearchCondition("purchasePoint");
		boolean logData = paymentService.insert(pDTO);

		mDTO.setSearchCondition("increaseMyCoin");
		boolean memberResult = memberService.update(mDTO);

		mDTO.setSearchCondition("viewCoin");
		MemberDTO memberData = memberService.selectOne(mDTO);
		session.setAttribute("coin", memberData.getCoin());
		System.out.println(memberData.getCoin() + "<<<<<<<<<<");

		if (memberResult && logData) {
			if (memberData != null) {
				// 포인트 충전 성공
				System.out.println("포인트 충전 성공");
				datas.put("status", "success");
			}
		} else {
			System.out.println("포인트 충전 실패");
			datas.put("status", "fail");
		}

		return gson.toJson(datas);
	}

}
