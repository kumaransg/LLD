package di;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.multibindings.MapBinder;
import core.IDistanceCalculator;
import core.OrderEntityAndDEDistanceCalculator;
import javafx.util.Pair;
import models.DeliveryExecutive;
import models.Order;

import java.util.HashMap;
import java.util.Map;

public class MainModule extends AbstractModule {
    @Override
    public void configure() {
//        Map<Pair<Class, Class>, IDistanceCalculator>
        Map<Pair<Class, Class>, IDistanceCalculator> map = new HashMap<>();
        map.put(new Pair<>(Order.class, DeliveryExecutive.class), new OrderEntityAndDEDistanceCalculator());
        IDistanceCalculatorHandler iDistanceCalculatorHandler = new IDistanceCalculatorHandler(map);

        bind(IDistanceCalculatorHandler.class).toInstance(iDistanceCalculatorHandler);
    }
}
