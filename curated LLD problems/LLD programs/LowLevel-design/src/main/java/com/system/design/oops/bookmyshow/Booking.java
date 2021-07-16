package com.system.design.oops.bookmyshow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    private String bookingId;
    private String userId;
    private String paymentId;
    private PaymentStatus paymentStatus;
    private String showId;
}
