package com.jarvis.BalanceGame.controller.admin.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jarvis.BalanceGame.model.dto.CommentDTO;
import com.jarvis.BalanceGame.model.dto.WarningDTO;
import com.jarvis.BalanceGame.service.CommentService;
import com.jarvis.BalanceGame.service.WarningService;

@Controller
@RequestMapping("/admin")
public class AdminDeleteCommentAsync {

	@Autowired
	private CommentService commentService;
	
	@Autowired
	private WarningService warningService;
	
	// 관리자가 댓글을 비동기적으로 삭제
	@PostMapping("/deleteAdminCommentAsync")
	public @ResponseBody String deleteAdminCommentAsync(CommentDTO cDTO) {
		System.out.println("관리자 댓글 삭제 파라미터 데이터 : " + cDTO);
		// 검색 조건을 설정하여 해당 댓글을 삭제
		cDTO.setSearchCondition("adminCommentDelete");
		boolean flag = commentService.delete(cDTO);
		if (!flag) {
			return "fail";
		}
		return "success";
		
	}
	// 경고를 받은 댓글을 관리자가 비동기적으로 삭제
	@PostMapping("/warningDeleteCommentAsync")
	public @ResponseBody String warningDeleteCommentAsync(CommentDTO cDTO, WarningDTO wDTO) {
		System.out.println("관리자 댓글 삭제 파라미터 데이터 : " + cDTO);
		// 검색 조건을 설정하여 해당 댓글을 삭제
		cDTO.setSearchCondition("adminCommentDelete");
		commentService.delete(cDTO);
		int cId = cDTO.getCommentId();
		wDTO.setCommentId(cId);
		boolean flag = warningService.delete(wDTO);
		
		if (!flag) {
			return "fail";
		}
		return "success";

	}
}
