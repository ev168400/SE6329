import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MenuItemManagementSystem {
    private ArrayList<Menu_Item> menuItems;
    private Map<String, ArrayList<Menu_Item>> categoryMap;

    public MenuItemManagementSystem() {
        this.menuItems = new ArrayList<>();
        this.categoryMap = new HashMap<>();
        initializeMenuItemsFromDB("MenuDB.csv");
    }

    private void initializeMenuItemsFromDB(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int itemID = Integer.parseInt(parts[0]);
                String itemName = parts[1].trim(); // Remove leading/trailing whitespaces
                String category = parts[2].trim(); // Remove leading/trailing whitespaces
                int quantityOrdered = Integer.parseInt(parts[3].trim()); // Remove leading/trailing whitespaces
                double price = Double.parseDouble(parts[4].trim()); // Remove leading/trailing whitespaces

                Menu_Item menuItem = new Menu_Item(itemID, itemName, category, quantityOrdered, price);
                menuItems.add(menuItem);

                if (!categoryMap.containsKey(category)) {
                    categoryMap.put(category, new ArrayList<>());
                }
                categoryMap.get(category).add(menuItem);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayMenu() {
        System.out.println("Menu Items:");
        for (Menu_Item menuItem : menuItems) {
            System.out.println("Item ID: " + menuItem.itemID +
                    ", Name: " + menuItem.itemName +
                    ", Category: " + menuItem.itemCategory +
                    ", Quantity Ordered: " + menuItem.quantityOrdered +
                    ", Price: " + menuItem.price);
        }
    }

    public ArrayList<Menu_Item> getMenuItemsByCategory(String category) {
        return categoryMap.getOrDefault(category, new ArrayList<>());
    }
}
