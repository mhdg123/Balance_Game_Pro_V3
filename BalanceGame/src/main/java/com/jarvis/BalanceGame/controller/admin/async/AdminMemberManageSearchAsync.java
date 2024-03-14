//package com.jarvis.BalanceGame.controller.admin.async;
//
//import java.util.ArrayList;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.jarvis.BalanceGame.model.dto.MemberDTO;
//import com.jarvis.BalanceGame.service.MemberService;
//
//public class AdminMemberManageSearchAsync {
//
//	@Autowired
//	private MemberService memberService;
//	
//	@RequestMapping("/adminMemberManageSearchAsync")
//	public @ResponseBody String adminMemberManageSearchAsync(MemberDTO mDTO) {
//		
////		PrintWriter out = response.getWriter();
//
////		Gson gson = new Gson();
//		
//		
//		mDTO.setSearchCondition("아이디조회");
//		
//		ArrayList<MemberDTO> mdatas = memberService.selectAll(mDTO);
//		
////		String memberData = gson.toJson(mdatas);
//		
////		if(memberData != null) {
////			System.out.println("유저관리 데이터" + memberData);
////			out.print(memberData);
////		}
////		else {
////			out.print(gson.toJson(memberData));
////		
//		return "";
////	}
//		
////		int flag = 0;
////		if(mDTO == null) {
////			flag=1;
////		}
////	return String.valueOf(flag);
//}
