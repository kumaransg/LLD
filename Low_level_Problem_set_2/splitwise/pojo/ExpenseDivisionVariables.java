package splitwise.pojo;

import java.util.List;

/**
 * @author priyamvora
 * @created 19/04/2021
 */
public class ExpenseDivisionVariables {
    private List<String> userIds;
    private Double totalAmount;
    private List<Double> divisions;

    public ExpenseDivisionVariables(List<String> userIds, Double totalAmount, List<Double> divisions) {
        this.userIds = userIds;
        this.totalAmount = totalAmount;
        this.divisions = divisions;
    }

    public ExpenseDivisionVariables(List<String> userIds, Double totalAmount) {
        this.userIds = userIds;
        this.totalAmount = totalAmount;
    }

    public List<String> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<String> userIds) {
        this.userIds = userIds;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<Double> getDivisions() {
        return divisions;
    }

    public void setDivisions(List<Double> divisions) {
        this.divisions = divisions;
    }
}
