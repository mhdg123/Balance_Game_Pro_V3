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

	@Override
	public boolean insert(AdvertisementDTO aDTO) {
		return advertisementDAO.insert(aDTO);
	}

	@Override
	public boolean update(AdvertisementDTO aDTO) {
		return advertisementDAO.update(aDTO);
	}

	@Override
	public boolean delete(AdvertisementDTO aDTO) {
		return advertisementDAO.delete(aDTO);
	}

	@Override
	public List<AdvertisementDTO> selectAll(AdvertisementDTO aDTO) {
		return advertisementDAO.selectAll(aDTO);
	}

	@Override
	public AdvertisementDTO selectOne(AdvertisementDTO aDTO) {
		return advertisementDAO.selectOne(aDTO);
	}

}
