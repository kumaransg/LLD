package com.system.design.lld.library.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Admin extends Person {
    public boolean addBook() {
        return true;
    }
    public boolean blockUser( Person person) {
        return true;
    }
    public boolean removeBook(){
        return true;
    }

    @Override
    public Book searchBookByTitle() {
        return null;
    }

    @Override
    public Book searchBookByAuthor() {
        return null;
    }
}
