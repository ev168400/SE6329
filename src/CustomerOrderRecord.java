import java.util.*;

public class CustomerOrderRecord {
    int orderID;
    int numberOfItems;
    ArrayList<Menu_Item> Items;
    int tableID;
    double paymentTotal;

    public CustomerOrderRecord(){}

    public CustomerOrderRecord createOrderRecord(TableRecord tabRecord){
        this.orderID = Math.abs(UUID.randomUUID().hashCode());
        this.numberOfItems = tabRecord.table_tab.size();
        this.Items = tabRecord.table_tab;
        this.tableID = tabRecord.table_ID;
        for(Menu_Item m : tabRecord.table_tab){
            this.paymentTotal += m.price;
        }
        return this;
    }

    public CustomerOrderRecord getOrderInfo(){ return this;}
    
}
 