package com.demo.service;

import com.demo.entity.Book;


public interface BookService {
	String ping();
	
    Book selectBook(int id);

    int insert(Book book);

    int update(Book book);

    int delete(int id);
}
