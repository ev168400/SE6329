import java.io.*;
public class Receipt {

    /* Class Attributes
	 * - order : Customer Order Record
	 *- p : Payment
	 */
	private Payment p = null;
	private CustomerOrderRecord order = null;
	
	// Constructor
	public Receipt(){}
	public Receipt(Payment current_payment, CustomerOrderRecord current_order) {
		this.p = current_payment;
		this.order = current_order;
	}
	
	//+ CreateReceipt(order : Customer Order Record, p : Payment) : Receipt
	public static Receipt CreateReceipt(Payment given_payment, CustomerOrderRecord given_order) {
		Receipt new_receipt = new Receipt(given_payment, given_order);
		storeReceipt(new_receipt);
		return new_receipt;
	}
	
	//- storeReceipt(r : Receipt)
	private static void storeReceipt(Receipt given_receipt) {
		try {
			String filePath = "src\\DB\\ReceiptsDB";
			File new_file = new File(filePath);
			FileWriter writer = new FileWriter(new_file, true);
			// Customer Order attributes
			writer.write((given_receipt.order).orderID + ", ");
			writer.write((given_receipt.order).tableID + ", ");
			writer.write((given_receipt.order).numberOfItems + ", ");
			writer.write((given_receipt.order).Items.toString() + ", ");
			writer.write((given_receipt.order).paymentTotal + ", ");
			
			// Payment attributes
			writer.write((given_receipt.p).credit_card_number + ", ");
			writer.write((given_receipt.p).expiration + ", ");
			writer.write((given_receipt.p).CVC + ", ");
			writer.write((given_receipt.p).paymentTotal + "\n");
			writer.close();
		} catch (IOException e) {
			System.out.println("Error occurred");
		}
	}
	
	public Payment getPayment() {
		return p;
	}
	 
	public void setPayment (Payment new_payment) {
		this.p = new_payment;
	}
	
	public CustomerOrderRecord getOrderRecord() {
		return order;
	}
	
	public void setOrderRecord (CustomerOrderRecord new_order) {
		this.order = new_order;
	}

}
