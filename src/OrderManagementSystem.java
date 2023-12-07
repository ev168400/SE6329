import java.io.*;
import java.util.*;

public class OrderManagementSystem {
    ArrayList<CustomerOrderRecord> orders;

    public OrderManagementSystem(){ orders = new ArrayList<>();}
    
    public CustomerOrderRecord getOrder(int tableId){ 
        for(CustomerOrderRecord o : this.orders){
            if(o.tableID == tableId){
                return o;
            }
        }
        return null;
    }
 
    public void SelectPlaceOrder(TableRecord tabRecord){
        CustomerOrderRecord customerOrderRecord = new CustomerOrderRecord();
        orders.add(customerOrderRecord.createOrderRecord(tabRecord));
        OrderQueueManagementSystem orderQueueManagementSystem = new OrderQueueManagementSystem();
        orderQueueManagementSystem.placeOrder(customerOrderRecord);
        storeOrder(customerOrderRecord);
    }    
    public void storeOrder(CustomerOrderRecord order){
        try {
            String filePath = "src\\DB\\OrderDB";
			File new_file = new File(filePath);
			FileWriter writer = new FileWriter(new_file, true);
			// Customer Order attributes
			writer.write(order.orderID + ", ");
			writer.write(order.tableID + ", ");
			writer.write(order.numberOfItems + ", ");
			writer.write(order.Items.toString() + ", ");
			writer.write(order.paymentTotal + "\n");
			
			writer.close();
		} catch (IOException e) {
			System.out.println("Error occurred");
		}
    }
}
