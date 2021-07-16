package com.system.design.lld.hotelbooking.db;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class Payment {
    private int paymentId;
    private int reservationId;
    private int amount;
    private Date paymentDate;
}
