package com.lbq.spring5.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lbq.spring5.tx.dao.BookDao;
import com.lbq.spring5.tx.dto.Book;

@Service
public class BookService {

	@Autowired
	private BookDao bookDao;
	
	public void addBook(Book book) {
		bookDao.add(book);
	}
}
