public class PaymentManagementSystem {

    // + CreatePayment(CardNum, ExpDate, CVC, total) : Payment
	public static Payment CreatePayment(int CardNum, String ExpDate, int CVC, double total) {
		// Call the Payment class Create method
		// Return the newly created Payment object
		return Payment.Create(CardNum, ExpDate, CVC, total);
	}

}
 