package com.jarvis.BalanceGame.model.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.jarvis.BalanceGame.model.dto.AnswerDTO;

public class AnswerDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// 답변 저장시 질문 pk ,로그인ID ,답변 저장하는 SQL
	private static final String INSERT = "INSERT INTO ANSWERS (AID,QID,LOGIN_ID,ANSWER) VALUES ((SELECT NVL(MAX(AID),0) + 1 FROM ANSWERS),?,?,?)";

	// 회원탈퇴시 'Answers'을 null 값으로 변경하는 SQL
	private static final String AS_UPDATE = "UPDATE ANSWERS SET LOGIN_ID = NULL WHERE LOGIN_ID = ?";

	private ArrayList<AnswerDTO> selectAll(AnswerDTO aDTO) {
		return null;
	}

	private AnswerDTO selectOne(AnswerDTO aDTO) {
		return null;
	}

	private int result = 0;

	public boolean insert(AnswerDTO aDTO) { // INSERT : 문제를 풀때 유저의 정보와 문제번호, 문제의 답변을 저장

		if (aDTO.getSearchCondition().equals("saveAnswer")) {
			result = jdbcTemplate.update(INSERT, aDTO.getQuestionId(), aDTO.getLoginId(), aDTO.getAnswer());
		}
		if (result <= 0) {
			return false;
		}
		return true;
	}

	public boolean update(AnswerDTO aDTO) { // 업데이트 (이용자가 풀었던 문제값 null로 변환)

		if (aDTO.getSearchCondition().equals("answer_null")) {
			result = jdbcTemplate.update(AS_UPDATE, aDTO.getLoginId());
		}
		if (result <= 0) {
			return false;
		}
		return true;
	}

	// 댓글 삭제하기 TODO 추후 구현 예정
	private boolean delete(AnswerDTO aDTO) {
		return false;
	}

}
