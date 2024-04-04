package com.jarvis.BalanceGame.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.jarvis.BalanceGame.model.dto.ItemLogDTO;

@Mapper
public interface IItemLogDAO {
	public List<ItemLogDTO> selectAll();
	public int insert(Map<String, Integer> map);
}
