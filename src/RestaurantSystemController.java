import java.util.*;

/* 	Class Attributes
	 	+ floorPlanManagementSystem : FloorPlanManagementSystem
        + tableManagementSystem : TableManagementSystem
        + menuItemManagementSystem : MenuItemManagementSystem
        + orderManagementSystem : OrderManagementSystem
        + orderQueueManagementSystem : OrderQueueManagementSystem
*/

/*
 * + DisplayTables(): void
    + SelectTable(table_chosen: int): void
    + DisplayTableTab(table_tab: ArrayList<Menu_Item>)
    + DisplayOptions(): void
    + DisplayCategories(): ArrayList<String>
    + DisplayItems(c: String): 
    + AddItem(itemID: int, tableID: int, c: String): void
    + SelectPlaceOrder(tableID: int): void
    + DisplayConfirmation(): void
    + DisplayOrderandCost(tableID: int)
    + DisplayPaymentInputFields(): void
    + EnterPayment(CardNum: int, ExpDate: String, CVC: int, tableChosen: int)
    + ValidatePayment(CardNum: int, ExpDate: String, CVC: int, total : double)
    + DisplayReceipt(new_receipt: Receipt): void
 */

public class RestaurantSystemController {
    FloorPlanManagementSystem floorPlanManagementSystem;
    TableManagementSystem tableManagementSystem;
    static MenuItemManagementSystem menuItemManagementSystem;
    static OrderManagementSystem orderManagementSystem;
    OrderQueueManagementSystem orderQueueManagementSystem;

    public RestaurantSystemController(){
        this.floorPlanManagementSystem = new FloorPlanManagementSystem();
        this.tableManagementSystem = new TableManagementSystem();
        this.menuItemManagementSystem = new MenuItemManagementSystem();
        this.orderManagementSystem = new OrderManagementSystem();
        this.orderQueueManagementSystem = new OrderQueueManagementSystem();
    }
    
    public void DisplayTables(){
        ArrayList<String> tables = floorPlanManagementSystem.getTables();
        for(String t : tables){
            String[] parts = t.split(",");
            System.out.print("Table " + parts[0].trim() + "    ");
        }
        System.out.println();
        System.out.println("Please enter the id of the table you would like to select");
    }
    
    public void SelectTable(int t){
        ArrayList<String> tables = floorPlanManagementSystem.getTables();
        for(String table : tables){
            String[] parts = table.split(",");
            if(Integer.parseInt(parts[0].trim()) == t){
                DisplayTableTab(tableManagementSystem.SelectTable(table));
            }
        }        
    }

    public static void DisplayTableTab(ArrayList<Menu_Item> tabRecord){
        System.out.println();
        System.out.println("Table Tab");
        for(Menu_Item i : tabRecord){
            System.out.println(i.itemID + " "+ i.itemName + " - $" + i.price);
        }
        if(tabRecord.isEmpty()){
            System.out.println("Empty");
        }
    }

    public void DisplayOptions(){
        System.out.println();
        System.out.println("Please enter a number to choose an option");
        System.out.println("1. Add Items");
        System.out.println("2. Place Order");
    }

    public void AddItem(int itemID, int tableID, String c){
        ArrayList<String> menuItems = menuItemManagementSystem.getItems(c);
        String i = "";
        for(String item : menuItems){
            String[] parts = item.split(",");
            if(Integer.parseInt(parts[0]) == itemID){
                i = item;
            }
        }
        Menu_Item createdItem = menuItemManagementSystem.create(i);
        DisplayTableTab(tableManagementSystem.UpdateTable(createdItem, tableID));
    }

    public ArrayList<String> DisplayCategories(){
        System.out.println();
        ArrayList<String> categories = menuItemManagementSystem.getCategories();
        System.out.println("Please enter a number to choose a category");
        int i = 1;
        for(String c : categories){
            System.out.println( i + ". " + c);
            i++;
        }
        return categories;
    }
    public void DisplayItems(String c){
        System.out.println();
        ArrayList<String> menuItems = menuItemManagementSystem.getItems(c);
        System.out.println(c + "s");
        for(String i : menuItems){
            String[] parts = i.split(",");
            System.out.println(parts[0].trim() + " " + parts[2].trim() + " - $" + parts[4].trim());
        }
    }
    public void SelectPlaceOrder(int tableID){
        for(TableRecord t : tableManagementSystem.getTables()){
            if(t.table_ID == tableID){
                orderManagementSystem.SelectPlaceOrder(t);
            }
        }
    }

    public static void DisplayConfirmation(){
        System.out.println();
        System.out.println("Order placed");
    }

    public static void DisplayOrderandCost(int tableID){
        CustomerOrderRecord order = orderManagementSystem.getOrder(tableID);
        System.out.println("Order " + order.orderID);
        for(Menu_Item m : order.Items){
            System.out.print(m.itemID + " " + m.itemName + " - $" + m.price);
            System.out.println();
        }
        double formattedTotal = Double.parseDouble(String.format("%.2f", order.paymentTotal));
        System.out.println("Total: $" + formattedTotal);
    }

    public static void DisplayPaymentInputFields(){
        System.out.println();
        System.out.println("Please enter payment details");
    }
    
    public void EnterPayment(int CardNum, String ExpDate, int CVC, int tableChosen){
        CustomerOrderRecord order = orderManagementSystem.getOrder(tableChosen);
        if(ValidatePayment(CardNum, ExpDate, CVC, order.paymentTotal)){
            Payment payment = PaymentManagementSystem.CreatePayment(CardNum, ExpDate, CVC, order.paymentTotal);

            //Create the receipt
            Receipt receipt = new Receipt();
            receipt = receipt.CreateReceipt(payment, order);
            DisplayReceipt(receipt);
        }
        else{
            System.out.println("Payment Invalid");
        }
    }
    
    public static void DisplayReceipt(Receipt r) {
        System.out.println();
        System.out.println("Receipt");
        System.out.println("Order " + r.getOrderRecord().orderID);
        System.out.println("Paid with card " + r.getPayment().credit_card_number);
        for(Menu_Item m : r.getOrderRecord().Items){
            System.out.print(m.itemID + " " + m.itemName + " - $" + m.price);
            System.out.println();
        }
        double formattedTotal = Double.parseDouble(String.format("%.2f", r.getOrderRecord().paymentTotal));
        System.out.println("Total: $" + formattedTotal);
        System.out.println();
        System.out.println("End of Use Case");
    }

    public Boolean ValidatePayment(int CardNum, String ExpDate, int CVC, double total){
        return true;
    }

}