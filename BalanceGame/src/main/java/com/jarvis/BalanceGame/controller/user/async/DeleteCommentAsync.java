package com.jarvis.BalanceGame.controller.user.async;

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
@RequestMapping("/user")
public class DeleteCommentAsync {

	@Autowired
	private CommentService commentService;

	@PostMapping("/deleteCommentAsync")
	public @ResponseBody String deleteCommentAsync(CommentDTO cDTO, Model model, HttpSession session) {
		String loginId = (String)session.getAttribute("loginId");
		cDTO.setLoginId(loginId);
		System.out.println(cDTO.getCommentId());
		cDTO.setSearchCondition("userCommentDelete");
		boolean flag = commentService.delete(cDTO);

		if (!flag) {
			return "0";
		}
		return "1";

	}
}
