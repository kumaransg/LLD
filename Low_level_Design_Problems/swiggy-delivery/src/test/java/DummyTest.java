import com.google.inject.Guice;
import com.google.inject.Injector;
import compute.GenerateAssignmentsOrderToDE;
import di.MainModule;
import models.DeliveryExecutive;
import models.Location;
import models.Order;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.Semaphore;

public class DummyTest {

    private Injector injector;
    private GenerateAssignmentsOrderToDE generateAssignmentsOrderToDE;

    @Before
    public void setup() throws Exception {
        injector = Guice.createInjector(new MainModule());
        generateAssignmentsOrderToDE = injector.getInstance(GenerateAssignmentsOrderToDE.class);
    }

    @Test
    public void testSingleEntry() {
        System.out.println(generateAssignmentsOrderToDE.generateAssignments(
                Arrays.asList(new Order("1", new Location(1L, 1L), 10L)),
                Arrays.asList(new DeliveryExecutive("1", new Location(1L, 1L), 10L))
        ));
    }

    @Test
    public void testMultipleOrderEntry() {
        System.out.println(generateAssignmentsOrderToDE.generateAssignments(
                Arrays.asList(new Order("1", new Location(1L, 1L), 10L),
                        new Order("2", new Location(10L, 10L), 10L)),
                Arrays.asList(new DeliveryExecutive("1", new Location(1L, 1L), 10L))
        ));
    }

    @Test
    public void testMultipleEntries() {
        System.out.println(generateAssignmentsOrderToDE.generateAssignments(
                Arrays.asList(new Order("1", new Location(1L, 1L), 10L),
                        new Order("2", new Location(10L, 10L), 10L)),
                Arrays.asList(new DeliveryExecutive("1", new Location(1L, 1L), 10L),
                        new DeliveryExecutive("2", new Location(1L, 1L), 7L))
        ));
    }

    @Test
    public void testMultipleEntriesWithDifferentTime() {
        System.out.println(generateAssignmentsOrderToDE.generateAssignments(
                Arrays.asList(new Order("1", new Location(1L, 1L), 10L),
                        new Order("2", new Location(10L, 10L), 10L),
                        new Order("3", new Location(1L, 1L), 500L),
                        new Order("4", new Location(10L, 10L), 600L)),
                Arrays.asList(new DeliveryExecutive("1", new Location(1L, 1L), 10L),
                        new DeliveryExecutive("2", new Location(1L, 1L), 10L),
                        new DeliveryExecutive("3", new Location(1L, 1L), 40L),
                        new DeliveryExecutive("4", new Location(1L, 1L), 500L))
        ));
    }
}
