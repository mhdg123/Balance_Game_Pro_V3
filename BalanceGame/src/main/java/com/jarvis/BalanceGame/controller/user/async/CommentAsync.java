package com.jarvis.BalanceGame.controller.user.async;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.jarvis.BalanceGame.model.dto.CommentDTO;
import com.jarvis.BalanceGame.service.CommentService;
@Controller
@RequestMapping("/user")
public class CommentAsync {

	@Autowired
	private CommentService commentService;
	@PostMapping("/commentAsync")
	public @ResponseBody String commentAsync(CommentDTO cDTO, Model model, Gson gson) {
		cDTO.setSearchCondition("questionComments");
		List<CommentDTO> datas=commentService.selectAll(cDTO);
		String json =gson.toJson(datas);
		if (datas.isEmpty()) {
			System.out.println("실패");
		}else {
			System.out.println(json);
		}
		return gson.toJson(datas);
	}
	
}
