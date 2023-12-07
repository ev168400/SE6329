import java.util.*;

public class OrderQueueManagementSystem {
    ArrayList<CustomerOrderRecord> orderQueue;

    public OrderQueueManagementSystem(){}

    public void placeOrder(CustomerOrderRecord order){
        orderQueue.add(order);
    }
    
}
 