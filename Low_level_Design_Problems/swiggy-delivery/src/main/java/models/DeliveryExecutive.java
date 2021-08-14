package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@AllArgsConstructor
@ToString
public class DeliveryExecutive {
    private String id;
    private Location current_location;
    private Long last_delivered_order_time;

    public Double getPriority() {
        return (double) (System.currentTimeMillis() - last_delivered_order_time);
    }
}
