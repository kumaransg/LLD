package SystemDesign.LogisticsDesign;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Apptest {

    public static void main(String[] args)
    {

        User user = new User();
        user.setUserId(1);
        user.setName("Ajay");
        user.setEmailId("Ajay@gmail.com");

        Item item1 = new Item();
        item1.setName("item1");
        item1.setPrice(20);

        Item item2 = new Item();
        item2.setName("item2");
        item2.setPrice(40);

        List<Item> items = new ArrayList<Item>();
        items.add(item1);
        items.add(item2);

        PaymentDetails paymentDetails = new PaymentDetails();
        paymentDetails.setAmount(100);
        paymentDetails.setPaymentMode(PaymentMode.CREDIT_CARD);
        paymentDetails.setCardNumber("12345678");

        Location destination = new Location();
        destination.setLatitude(73.23);
        destination.setLongitude(132.34);

        Order order = new Order();
        order.setOrderId(1);
        order.setItems(items);
        order.setCurrentStatus(OrderStatus.PROCESSING);
        order.setDestination(destination);
        order.setPaymentDetails(paymentDetails);
        order.setTimeOfOrderDelivery(new Date());

        LogisticsSystem logisticsSystem = new LogisticsSystem();
        logisticsSystem.registerNewUser(user);
        logisticsSystem.takeAnOrder(order);
        logisticsSystem.processOrder(order);
    }
}

