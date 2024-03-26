package com.jarvis.BalanceGame.controller.user.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jarvis.BalanceGame.model.dto.CommentDTO;
import com.jarvis.BalanceGame.model.dto.WarningDTO;
import com.jarvis.BalanceGame.service.CommentService;
import com.jarvis.BalanceGame.service.WarningService;

@Controller
@RequestMapping("/user")
public class CommentReportAsync {

	@Autowired
	private CommentService commentService;
	
	@Autowired
	private WarningService warningService;
	
	@GetMapping("/CommentReportAsync")
	public @ResponseBody String commentReportAsync(CommentDTO cDTO, WarningDTO wDTO) {
		
		commentService.insert(cDTO);
		
		return "success";
	}
}
