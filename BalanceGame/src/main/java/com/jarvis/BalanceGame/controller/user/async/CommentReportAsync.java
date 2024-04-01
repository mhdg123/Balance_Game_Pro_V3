package com.jarvis.BalanceGame.controller.user.async;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jarvis.BalanceGame.model.dto.LetterDTO;
import com.jarvis.BalanceGame.model.dto.MemberDTO;
import com.jarvis.BalanceGame.model.dto.WarningDTO;
import com.jarvis.BalanceGame.service.LetterService;
import com.jarvis.BalanceGame.service.MemberService;
import com.jarvis.BalanceGame.service.WarningService;

@Controller
@RequestMapping("/user")
public class CommentReportAsync {

	@Autowired
	private LetterService letterService;

	@Autowired
	private WarningService warningService;

	@Autowired
	private MemberService memberService;

	@PostMapping("/commentReportAsync")
	public @ResponseBody String commentReportAsync(WarningDTO wDTO, MemberDTO mDTO, LetterDTO lDTO) {
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
			List<WarningDTO> datas = warningService.selectAll(wDTO); // 신고횟수 조회하기
			System.out.println("신고 됨");
			if (warningService.insert(wDTO)) {
				System.out.println("신고 데이터 저장 완료");

			}
			if (datas.size() >= 3) { // 신고회수 3번 이상인지 확인
				// 신고를 3번 당해서 관리자에게 메세지를 보냄

				// 신고하는사람
				lDTO.setSender(originReporter);

				// 신고 건의사항 제목
				lDTO.setTitle("신고합니다.");

				// 신고 당하는 사람
				String content = "";
				content += originCommentWriter + "신고합니다.";
				lDTO.setLetterContents(originCommentWriter + "신고합니다.");

				// 누구를 신고하는지 신고 내용
				lDTO.setLetterContents(content);

				// 쪽지 받는사람 (관리자)
				lDTO.setLoginId("admin");
				// 건의사항 타입 : 신고하기
				lDTO.setLetterType("REPORT");
				boolean flag = letterService.insert(lDTO);
				if (flag) {
					System.out.println("신고 3번당해서 관리자에게 건의사항으로 메세지 보냄");
					return "success";
				}
			}
		} else {
			System.out.println("중복 신고 방지");
			// 이미 신고를 함
			return "fail";
		}
		return "success";
		// 셀렉하기
		// 신고하는 유저하고
		// 댓글 pk 확인하기
		// 한번만 가능하게 하기
	}
}
