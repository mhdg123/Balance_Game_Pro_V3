package com.jarvis.BalanceGame.controller.user.async;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.model.dto.WarningDTO;
import com.jarvis.BalanceGame.service.MemberService;
import com.jarvis.BalanceGame.service.WarningService;

@Controller
@RequestMapping("/user")
public class CommentReportAsync {

	@Autowired
	private WarningService warningService;

	@Autowired
	private MemberService memberService;

	@PostMapping("/commentReportAsync")
	public @ResponseBody String commentReportAsync(WarningDTO wDTO, MemberDTO mDTO) {
		// 신고자하고 댓글 id 비교
		String originReporter = wDTO.getRepoter(); // 신고한 유저 데이터 임시 저장
		String originCommentWriter = wDTO.getCommentWriter(); // 댓글 단 유저 데이터 임시 저장
		int originCommentId = wDTO.getCommentId(); // 댓글 PK 데이터 임시 저장

		System.out.println("신고할때 넘어온 데이터 : " + wDTO);
		System.out.println("유저가 신고한 비동기 기능 실행");
		System.out.println("신고한 유저 데이터 : " + wDTO.getRepoter());
		System.out.println("댓글 PK : " + wDTO.getCommentId());

		wDTO = warningService.selectOne(wDTO); // 처음 신고는 빈 객체를 wDTO저장
		System.out.println("신고를 한적이 있는지 데이터 :  " + wDTO);
		if (wDTO.getCommentId() <= 0) {
			// 데이터가 없으면 추가
			System.out.println("처음으로 신고");
			System.out.println("신고 데이터 : " + wDTO);
			wDTO.setCommentId(originCommentId);
			wDTO.setRepoter(originReporter);
			wDTO.setCommentWriter(originCommentWriter);
			System.out.println("데이터 다시 셋1 : " + wDTO.getCommentId());
			System.out.println("데이터 다시 셋2 : " + wDTO.getRepoter());
			List<WarningDTO> datas = warningService.selectAll(wDTO);
			if (datas.size() <= 0) {
				System.out.println("신고 됨");
				if (warningService.insert(wDTO)) {
					System.out.println("신고 데이터 저장 완료");
				}
			}
		} else {
			System.out.println("중복 신고 방지");
			// 데이터가 이미 있다면 실패
			return "fail";
		}
		return "success";
		// 셀렉하기
		// 신고하는 유저하고
		// 댓글 pk 확인하기
		// 한번만 가능하게 하기
	}
}
