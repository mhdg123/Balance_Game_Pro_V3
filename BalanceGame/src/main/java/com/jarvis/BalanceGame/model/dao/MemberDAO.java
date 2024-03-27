package com.jarvis.BalanceGame.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jarvis.BalanceGame.model.dto.MemberDTO;

@Repository
public class MemberDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;


	// 아이디 중복 체크 SQL
	private static final String SELECT_LOGIN_ID = "SELECT LOGIN_ID FROM MEMBER WHERE LOGIN_ID = ? ";

	// 로그인 SQL
	private static final String LOGIN = "SELECT LOGIN_ID, ROLE, COIN, NICKNAME FROM MEMBER WHERE LOGIN_ID = ? AND MEMBER_PASSWORD = ? ";

	// 유저 수 조회
	private static final String SELECT_CNT = "SELECT COUNT(1) AS MEMBER_CNT FROM MEMBER";

	// 유저 코인 조회
	private static final String SELECT_COIN = "SELECT COIN FROM MEMBER WHERE LOGIN_ID =?";
	
	// 유저 상세 조회
	private static final String SELECTONE_USER = "SELECT LOGIN_ID, NAME, NICKNAME, CELL_PHONE, EMAIL, ADDRESS, GENDER, AGE, GRADE, COIN, ADVERTISEMENT_STATUS "
			+ "FROM MEMBER WHERE LOGIN_ID = ?";

	// 소셜 로그인 
	private static final String SOCIAL_LOGIN = "SELECT LOGIN_ID, COIN, NICKNAME FROM MEMBER WHERE LOGIN_ID=?";

	// 마이페이지 조회 SQL
	private static final String MY_INFO = "SELECT LOGIN_ID, NAME, NICKNAME, CELL_PHONE, EMAIL, ADDRESS, GENDER, AGE, GRADE, COIN, ADVERTISEMENT_STATUS, MEMBER_DATE "
			+ "FROM MEMBER WHERE LOGIN_ID = ?";

	// 마이페이지 변경 조회
	private static final String MY_INFO_UPDATE_VIEW = "SELECT LOGIN_ID, NAME, NICKNAME, CELL_PHONE, EMAIL, ADDRESS, GENDER, AGE, GRADE, COIN, ADVERTISEMENT_STATUS, MEMBER_DATE "
			+ "FROM MEMBER WHERE LOGIN_ID = ? AND PASSWORD = ?";

	// 비밀번호 찾기에서 회원정보가 맞는 지 확인
	private static final String IS_INFO_CORRECT = "SELECT LOGIN_ID, EMAIL FROM MEMBER WHERE LOGIN_ID=? AND EMAIL=?";
	
	// 유저 전체 조회
	private static final String SELECTALL_USER = "SELECT \r\n" + "    M.LOGIN_ID, \r\n" + "    M.GENDER, \r\n"
			+ "    M.AGE," + "    M.ADDRESS, \r\n" + "    M.EMAIL, " + "    IFNULL(SUM(P.AMOUNT), 0) AS TOTAL, \r\n"
			+ "    CASE \r\n" + "        WHEN IFNULL(SUM(P.AMOUNT), 0) = 0 THEN NULL \r\n"
			+ "        ELSE CAST(RANK() OVER (ORDER BY IFNULL(SUM(P.AMOUNT), 0) DESC, MIN(P.PAYMENT_DATE)) AS CHAR) \r\n"
			+ "    END AS RANKING \r\n" + "FROM \r\n" + "    MEMBER M \r\n" + "LEFT JOIN \r\n"
			+ "    PAYMENT P ON M.LOGIN_ID = P.LOGIN_ID \r\n" + "GROUP BY \r\n" + "    M.LOGIN_ID, \r\n"
			+ "    M.GENDER, \r\n" + "    M.AGE," + "    M.ADDRESS," + "	   M.EMAIL";

	// 유저 랭킹 조회
	private static final String SELECTALL_RANKING = "SELECT M.LOGIN_ID, M.NICKNAME, IFNULL(SUM(P.AMOUNT), 0) AS TOTAL, "
			+ " CASE WHEN IFNULL(SUM(P.AMOUNT), 0) = 0 THEN NULL "
			+ " ELSE CAST(RANK() OVER (ORDER BY IFNULL(SUM(P.AMOUNT), 0) DESC, MIN(P.PAYMENT_DATE)) AS CHAR) "
			+ " END AS RANKING FROM MEMBER M LEFT JOIN PAYMENT P ON M.LOGIN_ID = P.LOGIN_ID GROUP BY M.NICKNAME, M.LOGIN_ID";

	// 회원가입 SQL
	private static final String INSERT = "INSERT INTO MEMBER (LOGIN_ID, MEMBER_PASSWORD, NAME, NICKNAME, EMAIL, ADDRESS, GENDER, CELL_PHONE, AGE) VALUES(?,?,?,?,?,?,?,?,?)";
	
	// 내정보 변경하기 SQL
	private static final String MY_INFO_UPDATE = "UPDATE MEMBER SET NAME = ?, EMAIL = ?, NICKNAME = ? WHERE LOGIN_ID = ? ";
	
	// 임시비밀번호로 변경
	private static final String TEMP_PW_UPDATE = "UPDATE MEMBER SET MEMBER_PASSWORD=? WHERE LOGIN_ID = ?";
	
	
	// 코인 추가
	private static final String MY_COIN_INCREASE = "UPDATE MEMBER\r\n"
			+ "SET coin = coin + (SELECT AMOUNT * 0.1 FROM PAYMENT WHERE LOGIN_ID = ? ORDER BY PAYMENT_DATE DESC LIMIT 1)\r\n"
			+ "WHERE LOGIN_ID = ?";
	
	// 코인 감소
	private static final String MY_COIN_DECREASE = "UPDATE MEMBER AS M JOIN ITEM AS I ON I.ITEM_ID = ? SET M.COIN = M.COIN - I.ITEM_PRICE "
			+ "WHERE M.LOGIN_ID = ?";
	
	// 유저 삭제
	private static final String DELETE = "DELETE FROM MEMBER WHERE LOGIN_ID = ?";

	// 회원 전체 검색
	public List<MemberDTO> selectAll(MemberDTO mDTO) {
		List<MemberDTO> members = null;
		if (mDTO.getSearchCondition().equals("viewAll")) {
			members = jdbcTemplate.query(SELECTALL_USER, new MemberRowMapper());
		} else if (mDTO.getSearchCondition().equals("ranking")) {
			members = jdbcTemplate.query(SELECTALL_RANKING, new MemberRowMapperRank());
		}
		return members;
	}

	// 회원 단일 검색
	public MemberDTO selectOne(MemberDTO mDTO) {

		MemberDTO member = null;
		if (mDTO.getSearchCondition().equals("viewOne")) {
			Object[] args = { mDTO.getLoginId() };
			System.out.println("" + mDTO.getLoginId());
			if (args != null) {
				try {
					member = jdbcTemplate.queryForObject(SELECTONE_USER, args, new MemberRowMapperDetail());
					System.out.println("유저 조회 쿼리 try / catch11" + member);
				} catch (Exception e) {
					System.out.println("유저 조회 쿼리 try / catch222" + member);
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
			Object[] args = { mDTO.getLoginId() };
			try {
				member = jdbcTemplate.queryForObject(MY_INFO, args, new MemberRowMapperDetail());
			} catch (Exception e) {
				System.out.println("내정보 결과 조회 실패");
			}
		}
		// 마이페이지 업데이트 페이지 조회
		else if (mDTO.getSearchCondition().equals("myInfoUpdateView")) {
			Object[] args = { mDTO.getLoginId(), mDTO.getMemberPassword() };
			try {
				member = jdbcTemplate.queryForObject(MY_INFO_UPDATE_VIEW, args, new MemberRowMapperDetail());
			} catch (Exception e) {
				System.out.println("내정보 결과 조회 실패");
			}
		} 
		// 멤버 수 조회
		else if (mDTO.getSearchCondition().equals("memberCount")) {
			try {
				member = jdbcTemplate.queryForObject(SELECT_CNT, new MemberRowMapperCnt());
			} catch (Exception e) {
				System.out.println("멤버수 결과 조회 실패");
			}
		} 
		// 소셜로그인
		else if (mDTO.getSearchCondition().equals("socialLogin")) {
			Object[] args = { mDTO.getLoginId() };
			try {
				System.out.println("소셜 로그인 dao");
				member = jdbcTemplate.queryForObject(SOCIAL_LOGIN, args, new MemberRowMapperSocialLogin());
			} catch (Exception e) {
				System.out.println("소셜로그인 실패");
			}
		}
		// 코인 조회
		else if(mDTO.getSearchCondition().equals("viewCoin")) {
			Object[] args = {mDTO.getLoginId()};
			try {
				member = jdbcTemplate.queryForObject(SELECT_COIN, args, new MemberRowMapperViewCoin());
			} catch (Exception e) {
				System.out.println("코인조회 실패");
			}
		}
		// 회원 비밀번호 찾기 전 회원 정보 확인
		else if(mDTO.getSearchCondition().equals("isMemberInfoCorrect")) {
			Object[] args = {mDTO.getLoginId(), mDTO.getEmail()};
			try {
				member = jdbcTemplate.queryForObject(IS_INFO_CORRECT, args, new MemberRowMapperIsInfoCorrect());
			} catch (Exception e) {
				System.out.println("회원정보가 일치하지 않습니다");
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
		int result = 0;
		if(mDTO.getSearchCondition().equals("modifyMyInfo")) {
			result = jdbcTemplate.update(MY_INFO_UPDATE, mDTO.getName(), mDTO.getEmail(), mDTO.getLoginId());
		}
		else if(mDTO.getSearchCondition().equals("increaseMyCoin")) {
			result = jdbcTemplate.update(MY_COIN_INCREASE, mDTO.getLoginId(), mDTO.getLoginId());
		}
		else if(mDTO.getSearchCondition().equals("decreaseMyCoin")) {
			result = jdbcTemplate.update(MY_COIN_DECREASE, mDTO.getItemId(), mDTO.getLoginId());
		}
		else if(mDTO.getSearchCondition().equals("updateTempPw")) {
			result = jdbcTemplate.update(TEMP_PW_UPDATE, mDTO.getMemberPassword(), mDTO.getLoginId());
		}
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
		member.setLoginId(rs.getString("LOGIN_ID"));
		member.setAge(rs.getString("AGE"));
		member.setGender(rs.getString("GENDER"));
		member.setTotal(rs.getInt("TOTAL"));
		member.setRanking(rs.getInt("RANKING"));
		member.setAddress(rs.getString("ADDRESS"));
		member.setEmail(rs.getString("EMAIL"));
		return member;
	}

}

class MemberRowMapperLogin implements RowMapper<MemberDTO> {

	@Override
	public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberDTO member = new MemberDTO();
		member.setLoginId(rs.getString("LOGIN_ID"));
		member.setRole(rs.getString("ROLE"));
		member.setCoin(rs.getInt("COIN"));
		member.setNickName(rs.getString("NICKNAME"));
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
		member.setLoginId(rs.getString("LOGIN_ID"));
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

class MemberRowMapperRank implements RowMapper<MemberDTO> {

	@Override
	public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberDTO member = new MemberDTO();
		member.setLoginId(rs.getString("LOGIN_ID"));
		member.setNickName(rs.getString("NICKNAME"));
		member.setTotal(rs.getInt("TOTAL"));
		member.setRanking(rs.getInt("RANKING"));
		return member;
	}
}

class MemberRowMapperCnt implements RowMapper<MemberDTO> {

	@Override
	public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberDTO member = new MemberDTO();
		member.setMemberCount(rs.getInt("MEMBER_CNT"));
		;
		return member;
	}
}

class MemberRowMapperSocialLogin implements RowMapper<MemberDTO> {

	@Override
	public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberDTO member = new MemberDTO();
		member.setLoginId(rs.getString("LOGIN_ID"));
		member.setNickName(rs.getString("NICKNAME"));
		member.setCoin(rs.getInt("COIN"));
		return member;
	}
}

class MemberRowMapperViewCoin implements RowMapper<MemberDTO>{

	@Override
	public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberDTO member = new MemberDTO();
		member.setCoin(rs.getInt("COIN"));
		return member;
	}
}

class MemberRowMapperIsInfoCorrect implements RowMapper<MemberDTO>{

	@Override
	public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberDTO member = new MemberDTO();
		member.setLoginId(rs.getString("LOGIN_ID"));
		member.setEmail(rs.getString("EMAIL"));
		return member;
	}
}