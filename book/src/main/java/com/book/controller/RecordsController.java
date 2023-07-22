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
import java.util.List;
import java.util.Map;

/**
 *
 */
@Controller
@RequestMapping("/records")
public class RecordsController {
    @Autowired
    @Qualifier("RecordsServiceImpl")
    private RecordsService recordsService;

    @Autowired
    @Qualifier("BooksServiceImpl")
    private BooksService booksService;

    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;

    @RequestMapping("records")
    public String newrecords() {
        return "records";
    }


    @RequestMapping("recordsconfirm")
    public String recordsconfirm() {
        return "confirm";
    }

    @RequestMapping("recordscurr")
    public String recordscurr() {
        return "currRecords";
    }

    @RequestMapping("recordsadd")
    public String recordadd() {
        return "records_add";
    }

    @RequestMapping("recordsList")
    @ResponseBody
    public List<Map<String, Object>> recordsList(HttpServletRequest request,String userName, String bookName, int status) {
        int userid = 0;
        if((int) request.getSession().getAttribute("role")!=1)
            userid = userService.getId((String) request.getSession().getAttribute("account"));
        List<Map<String, Object>> list = recordsService.queryAllRecords(userName, bookName, status, userid);
        return list;
    }

    @RequestMapping("currList")
    @ResponseBody
    public List<Map<String, Object>> currList(HttpServletRequest request,String userName, String bookName) {
        int userid = 0;
        if((int) request.getSession().getAttribute("role")!=1)
            userid = userService.getId((String) request.getSession().getAttribute("account"));
        List<Map<String, Object>> list = recordsService.currList(userName, bookName, userid);
        return list;
    }

    @RequestMapping("confirm")
    @ResponseBody
    public List<Map<String, Object>> confirm(HttpServletRequest request,String userName, String bookName) {
        int userid = 0;
        if((int) request.getSession().getAttribute("role")!=1)
            userid = userService.getId((String) request.getSession().getAttribute("account"));
        List<Map<String, Object>> list = recordsService.confirm(userName, bookName, userid);
        return list;
    }

    @RequestMapping("back")
    @ResponseBody
    public String back(int id){
        Records records = recordsService.queryRecordsById(id);
        SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
        records.setEnd(tempDate.format(new java.util.Date()));
        records.setIsreturn(2);
        int i = recordsService.updateRecords(records);
        if(i==0) return "error";
        return "success";
    }

    @RequestMapping("confirmback")
    @ResponseBody
    public String confirmback(int id){
        Records records = recordsService.queryRecordsById(id);
        records.setIsreturn(1);
        int i = recordsService.updateRecords(records);
        Books books = booksService.queryBooksById(records.getBookid());
        books.setStatus(0);
        booksService.updateBooks(books);
        if(i==0) return "error";
        return "success";
    }

    @RequestMapping("add")
    @ResponseBody
    public String add(int userid,int bookid,String start,String end,int isreturn){
        Records records = new Records();
        records.setIsreturn(isreturn);
        records.setEnd(end);
        records.setStart(start);
        records.setBookid(bookid);
        records.setUserid(userid);
        int i = recordsService.addRecords(records);
        if(i==0) return "error";
        return "success";
    }
}
