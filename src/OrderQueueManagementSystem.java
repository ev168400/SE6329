import java.util.ArrayList;

public class OrderQueueManagementSystem
{
	static ArrayList<CustomerOrderRecord> orderQueue = new ArrayList<>();
	
	public static void placeOrder(CustomerOrderRecord order)
	{
		orderQueue.add(order);
	}
}
