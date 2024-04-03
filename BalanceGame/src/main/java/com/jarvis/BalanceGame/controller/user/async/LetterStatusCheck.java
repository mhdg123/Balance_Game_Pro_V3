package com.jarvis.BalanceGame.controller.user.async;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.jarvis.BalanceGame.model.dto.LetterDTO;
import com.jarvis.BalanceGame.model.dto.PageInfoDTO;
import com.jarvis.BalanceGame.service.LetterService;
import com.jarvis.BalanceGame.service.PageInfoService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LetterStatusCheck {

    @Autowired
    private LetterService letterService;
    
    @Autowired
    private PageInfoService pageInfoService;
    
    // 사용자가 받은 편지의 상태를 확인하는 메서드
    @PostMapping("/letterCheckUnRead")
    public @ResponseBody String letterCheckUnRead(@RequestParam(value="letterCheck[]") List<String> letterCheck ,
    		LetterDTO lDTO, HttpSession session, Gson gson) {
    	// jsp에서 
        // 세션에서 로그인 ID 가져오기
        String loginId = (String)session.getAttribute("loginId");
        // 편지 확인
        // 편지 목록이 리스트로 전달됨
        // 우편의 주요 키(primary key)도 함께 전달됨
        // 반복문을 사용하여 읽음 또는 안 읽음 상태를 처리하고 삭제도 가능함
        boolean flag=false;
        for (String pk : letterCheck) {
            Integer letterDatas = Integer.valueOf(pk); // 문자열을 정수형으로 변환
            lDTO.setLetterId(letterDatas);
            lDTO.setSearchCondition("updateAllUnRead");
            flag=letterService.update(lDTO);
            
        }
        // Gson을 사용하여 결과 데이터를 다시 로드해야 함
        // 결과 데이터를 함께 반환해야 함
        String jsonResult = gson.toJson(flag); // 결과값을 JSON 형태로 변환
        return jsonResult;
    }
    
//    @PostMapping("letterCheckSelectAll")
//    public @ResponseBody String letterCheckSelectAll (LetterDTO lDTO, HttpSession session) {
//    	String loginId = (String)session.getAttribute("loginId");
//    	lDTO.setLoginId(loginId);
//    	lDTO.setSearchCondition("viewAllMessage");
//    	letterService.selectAll(lDTO);
//    	return "success";
//    }
    
    @PostMapping("/letterCheckRead")
    public @ResponseBody String letterCheckRead(@RequestParam(value="letterCheck[]") List<String> letterCheck ,
    		LetterDTO lDTO, HttpSession session,  Gson gson) {
    	
    	System.out.println("리스트 확인 : "+letterCheck);
    	// jsp에서 
        // 세션에서 로그인 ID 가져오기
        String loginId = (String)session.getAttribute("loginId");
        
        // 편지 확인
        // 편지 목록이 리스트로 전달됨
        // 우편의 주요 키(primary key)도 함께 전달됨
        // 반복문을 사용하여 읽음 또는 안 읽음 상태를 처리하고 삭제도 가능함
        boolean flag=false;
        for (String pk : letterCheck) {
            Integer letterDatas = Integer.valueOf(pk); // 문자열을 정수형으로 변환
            lDTO.setLetterId(letterDatas);
            lDTO.setSearchCondition("updateAllRead");
            System.out.println("체크된 pk 확인 : "+pk);
            flag=letterService.update(lDTO);
        }
        
        // Gson을 사용하여 결과 데이터를 다시 로드해야 함
        // 결과 데이터를 함께 반환해야 함
        String jsonResult = gson.toJson(flag); // 결과값을 JSON 형태로 변환
        
        return jsonResult;
        
    }
    
    @PostMapping("/letterCheckDelete")
    public @ResponseBody String letterCheckDelete(@RequestParam(value="letterCheck[]") List<String> letterCheck ,
    		LetterDTO lDTO, HttpSession session,  Gson gson) {
    	// jsp에서 
        // 세션에서 로그인 ID 가져오기
        String loginId = (String)session.getAttribute("loginId");
        // 편지 확인
        // 편지 목록이 리스트로 전달됨
        // 우편의 주요 키(primary key)도 함께 전달됨
        // 반복문을 사용하여 읽음 또는 안 읽음 상태를 처리하고 삭제도 가능함
        boolean flag=false;
        for (String pk : letterCheck) {
            Integer letterDatas = Integer.valueOf(pk); // 문자열을 정수형으로 변환
            lDTO.setLetterId(letterDatas);
            flag=letterService.delete(lDTO);
            
        }
        
        // Gson을 사용하여 결과 데이터를 다시 로드해야 함
        // 결과 데이터를 함께 반환해야 함
        String jsonResult = gson.toJson(flag); // 결과값을 JSON 형태로 변환
        return jsonResult;
    }
 
    @PostMapping("/letterAsync")
	public @ResponseBody String letterAsync(LetterDTO lDTO,PageInfoDTO pDTO, Model model, Gson gson, HttpSession session) {
		String loginId = (String)session.getAttribute("loginId");
		pDTO.setLoginId(loginId);
		if(pDTO.getCurrentPage() == 0) {
			pDTO.setCurrentPage(1);
		}
		pDTO.setPasingnationSize(10);
		pDTO.setOffset(pageInfoService.calculateOffset(pDTO));
		pDTO.setSearchCondition("viewAllMessage");
		List<PageInfoDTO> datas=pageInfoService.selectAll(pDTO);
		
		lDTO.setSearchCondition("messageCntMember");
		lDTO = letterService.selectOne(lDTO);
		System.out.println(lDTO);
		pDTO.setTotalRows(lDTO.getCnt());
		int totalPage = pageInfoService.calcTotalPages(pDTO);	// 총페이지 수
		
		
		if(datas != null) {
			model.addAttribute("letterDatas", datas);
			datas.get(0).setCurrentPage(pDTO.getCurrentPage());
			datas.get(0).setTotalPages(totalPage);
		}else {
			model.addAttribute("status", "fail");
			model.addAttribute("msg", "등록된 문제가 없습니다.");
			model.addAttribute("redirect", "");
			return "alert";
		}
		String json =gson.toJson(datas);
		if (datas.isEmpty()) {
			System.out.println("실패");
		}else {
			System.out.println(json);
		}
		return gson.toJson(datas);

	}
    
}
