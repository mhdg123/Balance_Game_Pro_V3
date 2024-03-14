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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(AdvertisementDTO aDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(AdvertisementDTO aDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<AdvertisementDTO> selectAll(AdvertisementDTO aDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdvertisementDTO selectOne(AdvertisementDTO aDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
