package com.system.design.oops.bookmyshow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    private String paymentId;
    private String Amount;
    private PaymentType paymentType;
    private String bookingId;

}
