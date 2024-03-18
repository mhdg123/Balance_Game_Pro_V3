package com.jarvis.BalanceGame.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jarvis.BalanceGame.model.dto.MemberDTO;

@Repository
public class MemberDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// 회원가입 SQL
	private static final String INSERT = "INSERT INTO MEMBER (LOGIN_ID, MEMBER_PASSWORD, NAME, NICKNAME, EMAIL, ADDRESS, GENDER, CELL_PHONE, AGE) VALUES(?,?,?,?,?,?,?,?,?)";

	// 아이디 중복 체크 SQL
	private static final String SELECT_LOGIN_ID = "SELECT LOGIN_ID FROM MEMBER WHERE LOGIN_ID = ? ";

	// 로그인 SQL
	private static final String LOGIN = "SELECT LOGIN_ID, ROLE FROM MEMBER WHERE LOGIN_ID = ? AND MEMBER_PASSWORD = ? ";

	// 유저 수 조회
	private static final String SELECT_CNT = "SELECT COUNT(1) AS CNT FROM MEMBER";

	// 유저 상세 조회
	private static final String SELECTONE_USER = "SELECT LOGIN_ID, NAME, NICKNAME, CELL_PHONE, EMAIL, ADDRESS, GENDER, AGE, GRADE, COIN, ADVERTISEMENT_STATUS "
			+ "FROM MEMBER WHERE LOGIN_ID = ?";

	// 마이페이지 SQL
	private static final String MY_INFO = "SELECT LOGIN_ID, NAME, NICKNAME, CELL_PHONE, EMAIL, ADDRESS, GENDER, AGE, GRADE, COIN, ADVERTISEMENT_STATUS "
			+ "FROM MEMBER WHERE LOGIN_ID = ? AND MEMBER_PASSWORD = ?";
	// 내정보 변경하기 SQL
	private static final String MY_INFO_UPDATE = "UPDATE MEMBER SET NAME = ?, EMAIL = ?, NICKNAME = ? WHERE LOGIN_ID = ? ";
	// 유저 전체 조회
	private static final String SELECTALL_USER = "SELECT M.LOGIN_ID, M.EMAIL, M.ADDRESS, M.GENDER, M.AGE,IFNULL(SUM(P.AMOUNT), 0) AS TOTAL, "
			+ " CASE WHEN IFNULL(SUM(S.AMOUNT), 0) = 0 THEN ELSE TO_CHAR(RANK() OVER (ORDER BY IFNULL(SUM(P.AMOUNT), 0) DESC, MIN(P.PAYMENT_DATE))) END AS RANKING "
			+ " FROM MEMBER M LEFT JOIN PAYMENT P ON M.LOGIN_ID = P.LOGIN_ID "
			+ " GROUP BY M.LOGIN_ID, M.EMAIL, M.ADDRESS, M.GENDER, M.AGE";

	// 유저 삭제
	private static final String DELETE = "DELETE FROM MEMBER WHERE LOGIN_ID = ?";

	// 회원 전체 검색
	public List<MemberDTO> selectAll(MemberDTO mDTO) {
		List<MemberDTO> members = null;
		if (mDTO.getSearchCondition().equals("viewAll")) {
			members = jdbcTemplate.query(SELECTALL_USER, new MemberRowMapper());
		}
		return members;
	}

	// 회원 단일 검색
	public MemberDTO selectOne(MemberDTO mDTO) {
		
		MemberDTO member = null;
		if (mDTO.getSearchCondition().equals("viewOne")) {
			Object[] args = { mDTO.getLoginId() };
			if (args != null) {
				try {
					member = jdbcTemplate.queryForObject(SELECTONE_USER, args, new MemberRowMapperDetail());
				} catch (Exception e) {
					System.out.println("결과가 없습니다");
				}
			}
		}
		// 로그인
		else if (mDTO.getSearchCondition().equals("login")) {
			System.out.println("loginDAO 실행");
			Object[] args = { mDTO.getLoginId(), mDTO.getMemberPassword() };
			System.out.println("loginDAO 실행2");
			if (args != null) {
				try {
					member = jdbcTemplate.queryForObject(LOGIN, args, new MemberRowMapperLogin());
				} catch (Exception e) {
					// 조회 결과가 없을 때 예외처리
					System.out.println("로그인 실패: 사용자가 존재하지 않습니다.");
				}
			}
		}
		// 아이디 중복확인
		else if (mDTO.getSearchCondition().equals("duplitcateCheck")) {
			System.out.println("아이디 중복확인 DAO 1");
			Object[] args = { mDTO.getLoginId() };
			System.out.println(mDTO.getLoginId() + "중복확인 요청한 아이디 " + mDTO.getLoginId());
			try {
				member = jdbcTemplate.queryForObject(SELECT_LOGIN_ID, args, new MemberRowMapperIdCheck());
				if (member.getLoginId().equals(mDTO.getLoginId())) {
					System.out.println("아이디 중복 DAO");
					return member;
				}
			} catch (Exception e) {
				// 결과가 없는 경우 처리
				System.out.println("결과가 없습니다.");
			}
		}
		// 마이페이지 조회
		else if (mDTO.getSearchCondition().equals("myInfo")) {
			Object[] args = { mDTO.getLoginId(), mDTO.getMemberPassword() };
			try {
				member = jdbcTemplate.queryForObject(MY_INFO, args, new MemberRowMapperDetail());
			} catch (Exception e) {
				System.out.println("내정보 결과 조회 실패");
			}
		}
		return member;
	}

	// 회원가입 LOGIN_ID, MEMBER_PASSWORD, NAME, NICKNAME, EMAIL, ADDRESS, GENDER,
	// CELL_PHONE, AGE
	public boolean insert(MemberDTO mDTO) {
		System.out.println(mDTO);
		int result = jdbcTemplate.update(INSERT, mDTO.getLoginId(), mDTO.getMemberPassword(), mDTO.getName(),
				mDTO.getNickName(), mDTO.getEmail(), mDTO.getAddress(), mDTO.getGender(), mDTO.getCellPhone(),
				mDTO.getAge());
		if (result <= 0) {
			return false;
		}
		return true;
	}

	// 개인정보 변경
	public boolean update(MemberDTO mDTO) {
		int result = jdbcTemplate.update(MY_INFO_UPDATE, mDTO.getName(), mDTO.getEmail(), mDTO.getLoginId());
		if (result <= 0) {
			return false;
		}
		return true;
	}

	// 회원탈퇴
	public boolean delete(MemberDTO mDTO) {
		int result = jdbcTemplate.update(DELETE, mDTO.getLoginId());
		if (result <= 0) {
			return false;
		}
		return true;
	}
}

class MemberRowMapper implements RowMapper<MemberDTO> {

	@Override
	public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberDTO member = new MemberDTO();
		member.setLoginId(rs.getString("LOGIN_ID "));
		member.setAge(rs.getString("AGE"));
		member.setGender(rs.getString("GENDER"));
		member.setEmail(rs.getString("EMAIL"));
		member.setAddress(rs.getString("ADDRESS"));
		member.setTotal(rs.getInt("TOTAL"));
		member.setRanking(rs.getInt("RANKING"));
		return member;
	}

}

class MemberRowMapperLogin implements RowMapper<MemberDTO> {

	@Override
	public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberDTO member = new MemberDTO();
		member.setLoginId(rs.getString("LOGIN_ID"));
		member.setRole(rs.getString("ROLE"));
		return member;
	}
}

class MemberRowMapperIdCheck implements RowMapper<MemberDTO> {

	@Override
	public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberDTO member = new MemberDTO();
		member.setLoginId(rs.getNString("LOGIN_ID"));
		return member;
	}
}

class MemberRowMapperDetail implements RowMapper<MemberDTO> {

	@Override
	public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberDTO member = new MemberDTO();
		member.setLoginId(rs.getString("LOGIN_ID "));
		member.setName(rs.getString("NAME"));
		member.setNickName(rs.getString("NICKNAME"));
		member.setAge(rs.getString("AGE"));
		member.setGender(rs.getString("GENDER"));
		member.setEmail(rs.getString("EMAIL"));
		member.setAddress(rs.getString("ADDRESS"));
		member.setCellPhone(rs.getString("CELL_PHONE"));
		member.setAdvertisementStatus(rs.getString("ADVERTISEMENT_STATUS"));
		member.setCoin(rs.getInt("COIN"));
		member.setGrade(rs.getInt("GRADE"));
		return member;
	}
}
