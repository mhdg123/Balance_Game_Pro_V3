package com.jarvis.BalanceGame.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString 
public class AdvertisementDTO {
    private int advertisementId; // 광고 PK
    private String advertisementUrl; // 광고 주소
    private String advertisementImg; // 광고 이미지
}
