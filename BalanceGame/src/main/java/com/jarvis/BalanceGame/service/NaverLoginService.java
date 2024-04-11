package com.jarvis.BalanceGame.service;

import java.io.UnsupportedEncodingException;

import com.jarvis.BalanceGame.model.dto.MemberDTO;



public interface NaverLoginService {
    String getToken(String code, String state) throws UnsupportedEncodingException;
    String getUserProfile(String accessToken);
    MemberDTO processNaverLogin(String tokenJson, MemberDTO mDTO);
}
