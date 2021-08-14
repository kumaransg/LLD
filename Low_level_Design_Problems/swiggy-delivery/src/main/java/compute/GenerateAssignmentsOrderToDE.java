package compute;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import di.IDistanceCalculatorHandler;
import javafx.util.Pair;
import models.DeliveryExecutive;
import models.Order;
import models.OrderToDEAssignment;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.BinaryOperator;

public class GenerateAssignmentsOrderToDE implements GenerateAssignments<Order, DeliveryExecutive, OrderToDEAssignment> {

    private IDistanceCalculatorHandler iDistanceCalculatorHandler;

    @Inject
    public GenerateAssignmentsOrderToDE(IDistanceCalculatorHandler iDistanceCalculatorHandler) {
        this.iDistanceCalculatorHandler = iDistanceCalculatorHandler;
    }

    private BinaryOperator<Pair<DeliveryExecutive, Double>> reducer =
            (distanceDetails1, distanceDetails2) ->
                    distanceDetails1.getValue() >
                            distanceDetails2.getValue() ? distanceDetails1: distanceDetails2;

    @Override
    public List<OrderToDEAssignment> generateAssignments(List<Order> orders, List<DeliveryExecutive> deliveryExecutives) {
        Preconditions.checkNotNull(orders, "Orders is null");
        Preconditions.checkNotNull(deliveryExecutives, "Delivery executives is null");
        Set<DeliveryExecutive> remainingDeliveryExecutiveSet = new HashSet<>(deliveryExecutives);
        List<OrderToDEAssignment> orderToDEAssignments = new ArrayList<>();
        orders.forEach( order -> {
                if(remainingDeliveryExecutiveSet.size() == 0)
                    return;
                remainingDeliveryExecutiveSet
                        .stream()
                        .map(deliveryGuy ->
                                new Pair<>(deliveryGuy, iDistanceCalculatorHandler
                                    .getDiscountCalculator(order.getClass(), deliveryGuy.getClass())
                                        .getDistance(order, deliveryGuy)))
                        .reduce(reducer)
                        .ifPresent(deliveryExecutiveLongPair ->
                                {
                                    orderToDEAssignments.add(new OrderToDEAssignment(order, deliveryExecutiveLongPair.getKey()));
                                    remainingDeliveryExecutiveSet.remove(deliveryExecutiveLongPair.getKey());
                                }
                        );
            }
        );
        return orderToDEAssignments;
    }
}
