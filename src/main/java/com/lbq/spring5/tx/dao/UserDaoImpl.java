package com.lbq.spring5.tx.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lbq.spring5.tx.dto.Account;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int addMoney() {
		String sql = "UPDATE `t_account` SET `money` = `money` + ? WHERE `username` = ?";
		return jdbcTemplate.update(sql, 100, "lucy");
		
	}

	@Override
	public int reduceMoney() {
		String sql = "UPDATE `t_account` SET `money` = `money` - ? WHERE `username` = ?";
		return jdbcTemplate.update(sql, 100, "mary");
		
	}

	@Override
	public int insert() {
		String sql = "INSERT INTO `t_account` (`id`, `username`, `money`) VALUES (?, ?, ?)";
		return jdbcTemplate.update(sql, "lin", "aaa", 1000);
	}

	@Override
	public int update() {
		String sql = "UPDATE `t_account` SET `money` = ? WHERE `username` = ?";
		return jdbcTemplate.update(sql, 100, "aaa");
	}

	@Override
	public List<Map<String,Object>> list() {
		String sql = "SELECT `id`, `username`, `money` FROM `t_account`";
//		return jdbcTemplate.queryForList(sql, Account.class);
		return jdbcTemplate.queryForList(sql);
	}
	
	
}
