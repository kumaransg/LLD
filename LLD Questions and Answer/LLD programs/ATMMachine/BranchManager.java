/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package ATMMachine;

import java.util.List;

public class BranchManager extends Person {
    String branchCode;
    List<String> atmIds;

    public BranchManager(String branchCode) {
        this.branchCode = branchCode;
    }

    public List<String> getAtmIds() {
        return atmIds;
    }

    public void setAtmIds(List<String> atmIds) {
        this.atmIds = atmIds;
    }
}
