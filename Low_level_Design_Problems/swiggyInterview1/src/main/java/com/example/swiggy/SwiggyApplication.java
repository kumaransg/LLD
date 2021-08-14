package com.example.swiggy;
import com.example.swiggy.managers.SwiggyDeliveryStrategy;
import com.example.swiggy.managers.SwiggyScoreCalculation;
import com.example.swiggy.model.*;
import com.example.swiggy.Service.*;
import java.util.ArrayList;
import java.util.List;


public class SwiggyApplication {
	static List<DeliveryExecutive> deliveryExecutiveList = new ArrayList<>();
	static List<Order> orderList = new ArrayList<>();

	public static List<DeliveryExecutive> getDeliveryExecutiveList() {
		return deliveryExecutiveList;
	}

	public static List<Order> getOrderList() {
		return orderList;
	}

	public static void main(String[] args) {
		buildDummyData();

		List<Order> orderList = getOrderList();
		for(Order order: orderList) {
			System.out.println(order);
		}

        DeliveryExecutiveScoreCalculationStrategy deliveryExecutiveScoreCalculationStrategy = new SwiggyScoreCalculation();
		AssignDeliveryExecutiveStrategy assignDeliveryExecutiveStrategy = new SwiggyDeliveryStrategy(deliveryExecutiveScoreCalculationStrategy);
        DeliveryExecutiveAssignmentServie deliveryExecutiveAssignmentServie = new DeliveryExecutiveAssignmentServie(assignDeliveryExecutiveStrategy);

        deliveryExecutiveAssignmentServie.assignDeliveryExecutives(getOrderList(), getDeliveryExecutiveList());

	}

	private static void buildDummyData() {
		deliveryExecutiveList.add(new DeliveryExecutive(1, new Location(12.9280027,77.5933021), 1531809702));
		deliveryExecutiveList.add(new DeliveryExecutive(2, new Location(12.2280027,77.3933021), 1531809702));
		deliveryExecutiveList.add(new DeliveryExecutive(3, new Location(12.1280027,77.4933021), 1531809702));

		Restaurant restaurant1 = new Restaurant(new Location(12.9280027,77.5933021));
		Restaurant restaurant2 = new Restaurant(new Location(12.1280027,77.1933021));

		SwiggyCustomer customer1 = new SwiggyCustomer(new Location(12.9280027,77.5933021));
		SwiggyCustomer customer2 = new SwiggyCustomer(new Location(12.9280027,77.5933021));

		orderList.add(new Order(101, customer1, restaurant1, 1531809702, OrderStates.ORDERED));
		orderList.add(new Order(102, customer2, restaurant1, 1531809703, OrderStates.ORDERED));
		orderList.add(new Order(103, customer2, restaurant1, 1531809703, OrderStates.ORDERED));
		orderList.add(new Order(104, customer2, restaurant1, 1531809703, OrderStates.ORDERED));
		orderList.add(new Order(105, customer2, restaurant1, 1531809703, OrderStates.ORDERED));

	}
}
