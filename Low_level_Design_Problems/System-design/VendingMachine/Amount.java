package Nav;

/**
 * Amount supported by Vending Machine.
 * @author Abhimanyu Sharma
 */

public enum Amount {
	
	HUNDRED(100), FIVEHUNDRED(500), THOUSAND(1000);
	
	private int amount;
	   
    private Amount(int amount){
        this.amount = amount;
    }
   
    public int getDenomination(){
        return amount;
    }
}
