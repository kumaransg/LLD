package com.system.design.lld.library.model;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@Builder
public class Member extends Person {
    @Autowired
    private BookingService booking;

    private boolean makeBooking( Book book) {
        return booking.makeBooking( book);
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
