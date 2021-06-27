import java.util.ArrayList;
import java.util.List;

public class RuleMatcherApplication {
    public static void main(String[] args) {
        List<Item> result = new ArrayList<>();
        Container container = new Container();
        Rule rule = new RuleMatchAnd(RlueMatchWeight(50),RuleMatchCategory(Category.BOOKS));
        result = RuleMatcher.findItemsMatchingRule(container,rule);
        for(Item item : result){
            System.out.println(item.getName());
        }
    }
}
