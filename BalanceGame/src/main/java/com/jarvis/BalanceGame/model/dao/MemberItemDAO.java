package com.jarvis.BalanceGame.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberItemDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String SELECTALL ="";
	private static final String INSERT ="";
	private static final String DELETE ="";
}
