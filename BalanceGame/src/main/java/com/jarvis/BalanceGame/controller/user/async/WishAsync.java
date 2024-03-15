//package com.jarvis.BalanceGame.controller.user.async;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.jarvis.BalanceGame.model.dto.WishDTO;
//import com.jarvis.BalanceGame.service.WishService;
//
//import jakarta.servlet.http.HttpSession;
//
//public class WishAsync {
//
//	@Autowired
//	private WishService wishService;
//	
//	
//	@RequestMapping("/wishAsync")
//	public @ResponseBody String wishAsync(WishDTO wDTO, HttpSession session) {
//		
//		wDTO.setLoginId((String)session.getAttribute("loginId"));
//		
//		boolean flag=false; 
//		String src="";
//		if (wishService.selectOne(wDTO) == null) {
//			flag = wishService.insert(wDTO);
//			if (flag) {
//				src="찜o.png";
//			}
//		}else {
//			wDTO.setSearchCondition("qm찜삭제");
//			flag= wishService.delete(wDTO);
//			if (flag) {
//				src="찜x.png";
//			}
//		}
//
//		if(!flag) {
//			
//			System.out.println("실패");
//			return "실패";
//		}
//			System.out.println(src);
//
//		return src;
//	}
//}