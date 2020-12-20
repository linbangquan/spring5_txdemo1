package com.lbq.spring5.tx.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lbq.spring5.tx.dto.Book;
import com.lbq.spring5.tx.service.BookService;

public class TestBook {

	@Test
	public void testJdbcTemplate() {
		ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		BookService bookService = context.getBean("bookService", BookService.class);
		Book book = new Book();
		book.setUserId(1L);
		book.setUsername("java");
		book.setUstatus("a");
		bookService.addBook(book);
	}
}
