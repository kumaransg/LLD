package di;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import core.IDistanceCalculator;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

@Singleton
public class IDistanceCalculatorHandler {

    // You can also use a map binder
    private Map<Pair<Class, Class>, IDistanceCalculator> classToIDistanceCalculatorMap;

    @Inject
    public IDistanceCalculatorHandler(Map<Pair<Class, Class>, IDistanceCalculator> handlerMap) {
        this.classToIDistanceCalculatorMap = new HashMap<>(handlerMap);
    }

    public IDistanceCalculator getDiscountCalculator(Class klass1, Class klass2) {
        Pair<Class, Class> incomingPair = new Pair<>(klass1, klass2);
        if(classToIDistanceCalculatorMap.containsKey(incomingPair)) {
            return classToIDistanceCalculatorMap.get(incomingPair);
        } else
            throw new IllegalStateException("No discount calculator present for the given objects");
    }
}
