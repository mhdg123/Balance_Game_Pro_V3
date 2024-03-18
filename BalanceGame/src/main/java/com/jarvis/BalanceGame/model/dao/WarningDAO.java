package com.jarvis.BalanceGame.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jarvis.BalanceGame.model.dto.WarningDTO;


@Repository
public class WarningDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String SELECTALL = null;
	
	private static final String SELECTONE = null;
	
	private static final String INSERT = null;
	
	private static final String UPDATE = null;
	
	private static final String DELETE = null;
	
	public boolean insert(WarningDTO wDTO){
		int result = jdbcTemplate.update(INSERT);
		if(result<=0) {
			return false;
		}
		return true;
	}
	
	public boolean delete(WarningDTO wDTO) {
		int result = jdbcTemplate.update(DELETE);
		if(result<=0) {
			return false;
		}
		return true;
	}
	
}
