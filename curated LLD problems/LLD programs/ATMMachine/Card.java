/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package ATMMachine;

public class Card {

    String cardNumber;
    String ccv;
    String cardHolderName;
    String barCode;

    public Card(String cardNumber, String ccv, String cardHolderName, String barCode) {
        this.cardNumber = cardNumber;
        this.ccv = ccv;
        this.cardHolderName = cardHolderName;
        this.barCode = barCode;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCcv() {
        return ccv;
    }

    public void setCcv(String ccv) {
        this.ccv = ccv;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }
}
