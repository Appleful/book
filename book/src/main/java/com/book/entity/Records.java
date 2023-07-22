package com.book.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 借阅记录实体类
 */
@Data
public class Records {
    private int id;
    private int userid;
    private int bookid;
    private String start;
    private String end;
    private int isreturn;

    public Records(int id, int userid, int bookid, String start, String end, int isreturn) {
        this.id = id;
        this.userid = userid;
        this.bookid = bookid;
        this.start = start;
        this.end = end;
        this.isreturn = isreturn;
    }

    public Records() {
    }
}
