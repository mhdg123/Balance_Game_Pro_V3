package com.jarvis.BalanceGame.model.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jarvis.BalanceGame.model.dto.AnswerDTO;

@Repository
public class AnswerDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// 해당 문제에 대한 질문 저장 
	private static final String INSERT = "INSERT INTO ANSWER (QUESTION_ID, LOGIN_ID, ANSWER) VALUES (?,?,?)";

	private ArrayList<AnswerDTO> selectAll(AnswerDTO aDTO) {
		return null;
	}

	private AnswerDTO selectOne(AnswerDTO aDTO) {
		return null;
	}

	// 해당 회원이 푼 답변을 해당 문제에 저장
	public boolean insert(AnswerDTO aDTO) {
		int result = 0;

		if (aDTO.getSearchCondition().equals("saveAnswer")) {
			result = jdbcTemplate.update(INSERT, aDTO.getQuestionId(), aDTO.getLoginId(), aDTO.getAnswer());
		}
		if (result <= 0) {
			return false;
		}
		return true;
	}
	
	private boolean update(AnswerDTO aDTO) {
		return false;
	}

	private boolean delete(AnswerDTO aDTO) {
		return false;
	}

}
