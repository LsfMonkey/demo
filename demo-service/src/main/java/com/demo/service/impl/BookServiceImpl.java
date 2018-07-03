package com.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.BookDao;
import com.demo.entity.Book;
import com.demo.service.BookService;

@Service("bookService")
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    public Book selectBook(int id) {
        return bookDao.selectBook(id);
    }

    public int insert(Book book) {
        return bookDao.insert(book);
    }

    public int update(Book book) {
        return bookDao.update(book);
    }

    public int delete(int id) {
        return bookDao.delete(id);
    }

	public String ping() {
		return "PONG";
	}
}
