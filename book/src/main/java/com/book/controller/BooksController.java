package com.book.controller;

import com.book.entity.Books;
import com.book.entity.Records;
import com.book.service.BooksService;
import com.book.service.RecordsService;
import com.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 */
@Controller
@RequestMapping("/books")
public class BooksController {
    @Autowired
    @Qualifier("BooksServiceImpl")
    private BooksService booksService;

    @Autowired
    @Qualifier("RecordsServiceImpl")
    private RecordsService recordsService;

    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;

    @RequestMapping("newBook")
    public String newBook(){
        return "newBook";
    }

    @RequestMapping("bookadd")
    public String bookadd(){
        return "book_add";
    }

    @RequestMapping("bookedit")
    public String bookedit(HttpServletRequest request,int id){
        Books books = booksService.queryBooksById(id);
        request.getSession().setAttribute("bookid",id);
        return "book_edit";
    }

    @RequestMapping("bookList")
    @ResponseBody
    public List<Books> bookList(){
        List<Books> list = booksService.queryAllBooks();
        return list;
    }

    @RequestMapping("borrow")
    @ResponseBody
    public String borrow(HttpServletRequest request,int id){
        Books books = booksService.queryBooksById(id);
        if(books.getStatus()==1)
            return "error";
        booksService.updateStatus(id);
        Records records = new Records();
        records.setUserid(userService.getId((String) request.getSession().getAttribute("account")));
        records.setBookid(id);
        SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
        records.setStart(tempDate.format(new Date()));
        records.setIsreturn(0);
        recordsService.addRecords(records);
        return "success";
    }

    @RequestMapping("search")
    @ResponseBody
    public List<Books> search(String name,int status){
        List<Books> list = booksService.queryBook(name, status);
        return list;
    }

    @RequestMapping("newsearch")
    @ResponseBody
    public List<Books> newsearch(String name,int status){
        List<Books> list = booksService.newBook(name, status);
        return list;
    }

    @RequestMapping("delete")
    @ResponseBody
    public String delete(int id){
        int i = booksService.deleteBooksById(id);
        if(i==0) return "error";
        return "success";
    }

    @RequestMapping("add")
    @ResponseBody
    public String add(String name,String comment){
        Books books = new Books();
        books.setName(name);
        books.setComment(comment);
        books.setStatus(0);
        SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
        books.setTime(tempDate.format(new Date()));
        int i = booksService.addBooks(books);
        if(i==0) return "error";
        return "success";
    }

    @RequestMapping("edit")
    @ResponseBody
    public String edit(int id,String name,String comment,int status,String time ){
        Books books = new Books();
        books.setId(id);
        books.setName(name);
        books.setComment(comment);
        books.setStatus(status);
        books.setTime(time);
        int i = booksService.updateBooks(books);
        if(i==0) return "error";
        return "success";
    }

    @RequestMapping("selectName")
    @ResponseBody
    public List<Map<String,Object>> selectName(){
        List<Map<String, Object>> maps = booksService.selectName();
        return maps;
    }

    @RequestMapping("bookinfo")
    @ResponseBody
    public Books bookinfo(int id){
        return booksService.queryBooksById(id);
    }
}
