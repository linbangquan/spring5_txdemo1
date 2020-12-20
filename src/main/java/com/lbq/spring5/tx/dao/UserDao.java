package com.lbq.spring5.tx.dao;

import java.util.List;
import java.util.Map;

import com.lbq.spring5.tx.dto.Account;

public interface UserDao {

	public int addMoney();
	public int reduceMoney();
	public int insert();
	public int update();
	public List<Map<String,Object>> list();
}
