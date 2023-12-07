import java.io.FileWriter;

public class OrderManagementSystem
{
	public static CustomerOrderRecord SelectPlaceOrder(TableRecord tabRecord)
	{
		CustomerOrderRecord order = new CustomerOrderRecord(tabRecord);
		storeOrder(order);
		OrderQueueManagementSystem.placeOrder(order);
		return order;
	}
	
	public static void storeOrder(CustomerOrderRecord order)
	{
		try
		{
			FileWriter fw = new FileWriter("src/DB/OrderDB", true);

			fw.write(CustomerOrderRecord.orderID + ", ");
			fw.write(order.tableID + ", ");
			fw.write(order.numberOfItems + ", ");
			for(int i = 0; i < order.Items.size(); i++)
			{
				if(i == 0)
					fw.write("[" + order.Items.get(i).name + ", ");
				else if(i == (order.Items.size() - 1))
					fw.write(order.Items.get(i).name + "], ");
				else
					fw.write(order.Items.get(i).name + ", ");
			}
			fw.write(order.paymentTotal + "\n");
    
            		fw.close(); 
       		} 
        	catch (Exception e)
		{ 
         		e.getStackTrace(); 
        	}
	}
}
