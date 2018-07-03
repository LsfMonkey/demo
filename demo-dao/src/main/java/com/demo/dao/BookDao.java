package com.demo.dao;

import org.apache.ibatis.annotations.Param;

import com.demo.entity.Book;

public interface BookDao {
    int insert(Book book);

    int delete(@Param("id")int id);

    int update(Book book);

    Book selectBook(@Param("id")int id);
}
