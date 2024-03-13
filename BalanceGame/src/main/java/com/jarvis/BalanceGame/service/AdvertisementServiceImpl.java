package com.jarvis.BalanceGame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarvis.BalanceGame.model.dao.AdvertisementDAO;
import com.jarvis.BalanceGame.model.dto.AdvertisementDTO;

@Service("advertisementService")
public class AdvertisementServiceImpl implements AdvertisementService{
	
	@Autowired
	AdvertisementDAO advertisementDAO;

}
