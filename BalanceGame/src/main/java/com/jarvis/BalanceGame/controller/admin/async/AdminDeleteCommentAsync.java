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
	
	@PostMapping("/deleteAdminCommentAsync")
	public @ResponseBody String deleteAdminCommentAsync(CommentDTO cDTO) {
		System.out.println("관리자 댓글 삭제 파라미터 데이터 : " + cDTO);
		cDTO.setSearchCondition("adminCommentDelete");
		boolean flag = commentService.delete(cDTO);
		if (!flag) {
			return "fail";
		}
		return "success";

	}
	
	@PostMapping("/warningDeleteCommentAsync")
	public @ResponseBody String warningDeleteCommentAsync(CommentDTO cDTO, WarningDTO wDTO) {
		System.out.println("관리자 댓글 삭제 파라미터 데이터 : " + cDTO);
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
