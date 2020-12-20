package com.lbq.spring5.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lbq.spring5.tx.dto.Book;

@Repository
public class BookDaoImpl implements BookDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void add(Book book) {
		String sql = "INSERT INTO `t_book` (`user_id`, `username`, `ustatus`) VALUES (?, ?, ?)";
		int update = jdbcTemplate.update(sql, book.getUserId(), book.getUsername(), book.getUstatus());
		System.out.println(update);
	}
}
