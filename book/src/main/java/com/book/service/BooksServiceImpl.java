package com.book.service;

import com.book.dao.BookMapper;
import com.book.entity.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 *
 */
@Service
public class BooksServiceImpl implements BooksService {

    @Autowired
    private BookMapper bookMapper;

    public void setBooksMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public int addBooks(Books books) {
        return bookMapper.addBooks(books);
    }

    public int deleteBooksById(int id) {
        return bookMapper.deleteBooksById(id);
    }

    public int updateBooks(Books books) {
        return bookMapper.updateBooks(books);
    }

    public Books queryBooksById(int id) {
        return bookMapper.queryBookById(id);
    }

    public List<Books> queryAllBooks() {
        return bookMapper.queryAllBook();
    }

    public int updateStatus(int id){
        return bookMapper.updateStatus(id);
    }

    public List<Books> queryBook(String name, int status) {
        return bookMapper.queryBook(name,status);
    }

    public List<Books> newBook(String name, int status) {
        return bookMapper.newBook(name,status);
    }

    public List<Map<String, Object>> selectName() {
        return bookMapper.selectName();
    }
}
