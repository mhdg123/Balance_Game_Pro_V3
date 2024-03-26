package com.jarvis.BalanceGame.controller.user.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jarvis.BalanceGame.model.dto.WarningDTO;
import com.jarvis.BalanceGame.service.CommentService;
import com.jarvis.BalanceGame.service.WarningService;

@Controller
@RequestMapping("/user")
public class CommentReportAsync {

	
	@Autowired
	private WarningService warningService;
	
	@PostMapping("/CommentReportAsync")
	public @ResponseBody String commentReportAsync(WarningDTO wDTO) {
		
		warningService.insert(wDTO);
		
		return "success";
	}
}
