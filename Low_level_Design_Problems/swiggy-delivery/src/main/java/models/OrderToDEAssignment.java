package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class OrderToDEAssignment {
//    private String orderId;
//    private String deId;
    private Order order;
    private DeliveryExecutive deliveryExecutive;
}
