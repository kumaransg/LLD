package StockBroking.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @author priyamvora
 * @created 26/04/2021
 */
public class Portfolio {
    private final List<PortfolioItem> portfolioItemList;

    public Portfolio() {
        this.portfolioItemList = new ArrayList<>();
    }

    public void addItemToPortfolio(PortfolioItem portfolioItem) {
        this.portfolioItemList.add(portfolioItem);
    }
    
}
