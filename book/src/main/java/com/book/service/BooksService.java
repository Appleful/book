package com.book.service;

import com.book.dao.BookMapper;
import com.book.entity.Books;

import java.util.List;
import java.util.Map;

/**
 *
 */
public interface BooksService {

    public void setBooksMapper(BookMapper bookMapper) ;

    //增加
    public int addBooks(Books books);

    //删除
    public int deleteBooksById(int id);

    //修改
    public int updateBooks(Books books);

    //查询
    public Books queryBooksById(int id);

    //查询全部
    public List<Books> queryAllBooks();

    public int updateStatus(int id);

    public List<Books> queryBook(String name,int status);

    public List<Books> newBook(String name, int status);

    public List<Map<String ,Object>> selectName();
}
