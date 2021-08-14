package com.system.design.lld.library.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Person {
    private String name;
    private String emailId;
    private String phoneNumber;
    private Account account;
    public abstract Book searchBookByTitle();
    public abstract Book searchBookByAuthor();
}
