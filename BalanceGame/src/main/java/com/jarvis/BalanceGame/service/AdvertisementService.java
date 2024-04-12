package com.jarvis.BalanceGame.service;

import java.util.List;

import com.jarvis.BalanceGame.model.dto.AdvertisementDTO;

public interface AdvertisementService {
	public List<AdvertisementDTO> selectAll(AdvertisementDTO aDTO);
	public AdvertisementDTO selectOne(AdvertisementDTO aDTO);
	public boolean insert(AdvertisementDTO aDTO);
	public boolean update(AdvertisementDTO aDTO);
	public boolean delete(AdvertisementDTO aDTO);
}
