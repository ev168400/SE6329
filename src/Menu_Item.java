public class Menu_Item {
    int itemID;
    String itemName;
    String itemCategory;
    int quantityOrdered;
    double price;

    public Menu_Item(int itemID, String itemName, String itemCategory, int quantityOrdered, double price){
        this.itemID = itemID;
        this.itemName = itemName;
        this.itemCategory = itemCategory;
        this.quantityOrdered = quantityOrdered;
        this.price = price;
    }
}
 