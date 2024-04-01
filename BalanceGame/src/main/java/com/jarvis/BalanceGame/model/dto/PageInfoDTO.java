package com.jarvis.BalanceGame.model.dto;

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

	public PageInfoDTO(int totalRows, int totalPages, int currentPage, int pasingnationSize) {
		this.totalRows = totalRows;
		this.totalPages = totalPages;
		this.currentPage = currentPage;
		this.pasingnationSize = 10;
		calcTotalPages();
	}
	
	private void calcTotalPages() {
		if(totalRows <=0) {
			totalPages =0;
		}
		totalPages = totalRows / pasingnationSize;
		if(totalRows % pasingnationSize > 0) {
			totalPages++;
		}
	}
}
