package com.jarvis.BalanceGame.service;

import java.util.List;

import com.jarvis.BalanceGame.model.dto.AdvertisementDTO;

public interface AdvertisementService {
	public boolean insert();
	public boolean update();
	public boolean delete();
	public List<AdvertisementDTO> selectAll();
	public AdvertisementDTO selectOne();
}
