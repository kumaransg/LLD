package splitwise.model.expense;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author priyamvora
 * @created 19/04/2021
 */
public class Expense {
    private final String expenseId;
    private final String payerUserId;
    private String name;
    private List<String> images;
    private final Double totalAmount;
    private final ExpenseType expenseType;
    private final Map<String, Double> owerToAmountMap;

    public Expense(String payerUserId, Double totalAmount, ExpenseType expenseType, Map<String, Double> owerToAmountMap) {
        this.expenseId = UUID.randomUUID().toString();
        this.payerUserId = payerUserId;
        this.totalAmount = totalAmount;
        this.expenseType = expenseType;
        this.owerToAmountMap = owerToAmountMap;
    }

    public String getExpenseId() {
        return expenseId;
    }

    public String getPayerUserId() {
        return payerUserId;
    }


    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public Map<String, Double> getOwerToAmountMap() {
        return owerToAmountMap;
    }
}
