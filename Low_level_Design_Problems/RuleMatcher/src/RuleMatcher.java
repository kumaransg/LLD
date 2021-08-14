import java.util.ArrayList;
import java.util.List;

public class RuleMatcher {
    public static List<Item> findItemsMatchingRule(Container container, Rule rule) {
        List<Item> filteredItemsInContainer = new ArrayList<>();
        for(Item item : container.getItems()) {
            if(rule.match(item)) {
                filteredItemsInContainer.add(item);
            }
        }

        for(Container childContainer : container.getChildContainers()) {
            filteredItemsInContainer.addAll(findItemsMatchingRule(container, rule));
        }
        return filteredItemsInContainer;
    }
}
