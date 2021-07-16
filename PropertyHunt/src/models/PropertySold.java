package models;

public class PropertySold {

    String soldto;
    int soldPrice;

    public PropertySold() {
        this.soldto = null;
        this.soldPrice = 0;
    }

    public String getSoldto() {
        return soldto;
    }

    public void setSoldto(String soldto) {
        this.soldto = soldto;
    }

    public int getSoldPrice() {
        return soldPrice;
    }

    public void setSoldPrice(int soldPrice) {
        this.soldPrice = soldPrice;
    }
}
