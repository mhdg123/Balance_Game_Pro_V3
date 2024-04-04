package com.jarvis.BalanceGame.model.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageInfoDTO {

	private int totalRows; // 전체 행의 개수(글 개수)
	private int totalPages; // 총 페이지 개수
	private int currentPage; // 현재 페이지
	private int pasingnationSize; //페이지 처리할 개수
	//-----------------------------
	private int offset;
	private String searchCondition;
	
	//question--------------------------
	private int questionId;
	private String title;
	private int likeCount;
	private int wishId;
	private Date questionDate;
	private String writer;
	private String explanation;
	
	//Member----------------------------
	private String loginId;
	private String nickName;
	private int total;
	private int ranking;
	private String age;
	private String gender;
	private String address;
	private String email;
	
	//Letter-----------------------------
	private int letterId;
	private String sender;
	private Date letterDate;
	private String letterStatus;
	private String letterType;
	
	//Comment
	private int commentId;
	private String comments;
	private int memberGrade;
	private Date commentDate;
	
	//payment----------------------------
	private Date paymentDate;
	private int paymentAmount;
	
}
