package com.system.design.lld.library.model;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class Book {
    private String name;
    private String title;
    private String author;
    private Date publishedDate;
    private int quantity;
}
