public class Payment {

    /* 	Class Attributes
	 	+ credit_card_number: int
		+ expiration: int
		+ CVC: int
		+ paymentTotal: double
	 */
    int credit_card_number = 0;
    String expiration = "";
    int CVC = 0;
    double paymentTotal = 0.00;
    
    // Constructor
    Payment(int CardNum, String ExpDate, int CVC, double total) {
    	this.credit_card_number = CardNum;
    	this.expiration = ExpDate;
    	this.CVC = CVC;
    	this.paymentTotal = total;
    }
    
    // + Create(CardNum, ExpDate, CVC, total) : Payment
    public static Payment Create(int CardNum, String ExpDate, int CVC, double total) {
    	// Call the class constructor
    	Payment new_payment = new Payment(CardNum, ExpDate, CVC, total);
    	// Return the new instance
    	return new_payment;
    }
    
}
 