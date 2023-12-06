import java.util.ArrayList;

public class CustomerOrderRecord
{
	static int orderID = 0;
	int tableID, numberOfItems;
	double paymentTotal;
	ArrayList<Menu_Item> Items;
	
	public CustomerOrderRecord(TableRecord tabRecord)
	{
		orderID++;
		tableID = tabRecord.table_ID;
		numberOfItems = tabRecord.table_tab.size();
		Items = tabRecord.table_tab;
		
		for(int i = 0; i < Items.size(); i++)
			paymentTotal += Items.get(i).price; 
	}
}
