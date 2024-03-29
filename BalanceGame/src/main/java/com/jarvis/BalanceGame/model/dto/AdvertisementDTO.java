package com.jarvis.BalanceGame.model.dto;

import org.jetbrains.annotations.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString 
public class AdvertisementDTO {
	@NotNull
    private int advertisementId; // 광고 PK
	@NotNull
    private String advertisementUrl; // 광고 주소
    private String advertisementImg; // 광고 이미지
    @NotNull
    private String advertisementStatus; // 광고 상태값
    
    //--------------------------------------------
    private String searchCondition; 
    private int advertisementNextId; // 다음 pk
}
