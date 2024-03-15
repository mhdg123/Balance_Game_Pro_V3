package com.jarvis.BalanceGame.controller.user.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jarvis.BalanceGame.model.dto.CommentDTO;
import com.jarvis.BalanceGame.service.CommentService;

public class DeleteCommentAsync {

	@Autowired
	private CommentService commentService;

	@RequestMapping("/deleteCommentAsync")
	public @ResponseBody String deleteCommentAsync(CommentDTO cDTO, Model model) {

		boolean flag = commentService.delete(cDTO);

		if (!flag) {
			return "0";
		}
		return "1";

	}
}
