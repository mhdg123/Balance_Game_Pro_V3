package com.jarvis.BalanceGame.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jarvis.BalanceGame.model.dto.PageInfoDTO;
import com.jarvis.BalanceGame.model.dto.QuestionDTO;

@Repository
public class PageInfoDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String SELECTALL = "SELECT Q.QUESTION_ID, Q.TITLE, Q.QUESTION_DATE, "
			+ "COUNT(DISTINCT W.LOGIN_ID) AS LIKE_COUNT, "
			+ "MAX(CASE WHEN W.LOGIN_ID = 'user1' THEN 1 ELSE 0 END) AS LIKE_ID\r\n"
			+ "FROM QUESTION Q LEFT JOIN WISH W ON W.QUESTION_ID = Q.QUESTION_ID "
			+ "WHERE Q.QUESTION_ACCESS = 'T' GROUP BY Q.QUESTION_ID, Q.TITLE, Q.QUESTION_DATE\r\n"
			+ "LIMIT ?, ?";
	
	public List<QuestionDTO> selectAll(PageInfoDTO pDTO){
		List<QuestionDTO> datas = null;
		if(pDTO.getSearchCondition().equals("viewAllOfQuestionList")) {
			Object[] args = {pDTO.getOffset(), pDTO.getPasingnationSize()};
			datas = jdbcTemplate.query(SELECTALL, args, new PageInfoRowMapper());
		}
		return datas;
	}
	
	// 토탈 페이지 계산 
	public int calcTotalPages(PageInfoDTO pDTO) { 
		if(pDTO.getTotalRows() <=0) { // 데이터가 없다면
			pDTO.setTotalPages(0); // 토탈페이지는 0
		}
		pDTO.setTotalPages(pDTO.getTotalRows()/pDTO.getPasingnationSize()); // 토탈 페이지 개수
		if(pDTO.getTotalRows() % pDTO.getPasingnationSize() > 0) { // 토탈 페이지 계산했을 때 나머지가 0보다 크다면
			pDTO.setTotalPages(pDTO.getTotalPages()+1); // 페이지 개수 1 증가
		}
		return pDTO.getTotalPages();
	}

	// 페이지 번호에 따른 offset 계산
	public int calculateOffset(PageInfoDTO pDTO) {
	    if (pDTO.getCurrentPage() <= 1) {
	       pDTO.setOffset(0);
	    } else {
	        pDTO.setOffset((pDTO.getCurrentPage()- 1) * pDTO.getPasingnationSize() - 1);
	    }
	    return pDTO.getOffset();
	}
}

class PageInfoRowMapper implements RowMapper<QuestionDTO>{

	@Override
	public QuestionDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		QuestionDTO data = new QuestionDTO();
		data.setQuestionId(rs.getInt("QUESTION_ID"));
		data.setTitle(rs.getString("TITLE"));
		data.setLikeCount(rs.getInt("LIKE_COUNT"));
		data.setWishId(rs.getInt("LIKE_ID"));
		data.setQuestionDate(rs.getDate("QUESTION_DATE"));
		return data;
	}
}
