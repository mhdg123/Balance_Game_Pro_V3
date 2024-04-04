package com.jarvis.BalanceGame.controller.admin.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jarvis.BalanceGame.model.dto.CommentDTO;
import com.jarvis.BalanceGame.service.CommentService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminDeleteCommentAsync {

	@Autowired
	private CommentService commentService;

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
}
