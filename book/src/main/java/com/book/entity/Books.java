package com.book.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 书籍实体类
 */
@Data
public class Books {
    private int id;
    private String name;
    private int status;
    private String time;
    private String comment;

    public Books(int id, String name, int status, String time, String comment) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.time = time;
        this.comment = comment;
    }

    public Books() {
    }
}
