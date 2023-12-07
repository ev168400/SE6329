import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuItemManagementSystem {
    public MenuItemManagementSystem(){}

    public ArrayList<String> getCategories(){
        ArrayList<String> categories = new ArrayList<>();
        String filePath = "src\\DB\\MenuDB";
        Scanner scanner;
        try {
            scanner = new Scanner(new File(filePath));
        
            while(scanner.hasNextLine()){
                String menuItem = scanner.nextLine();
                String[] parts = menuItem.split(",");
                if(!categories.contains(parts[1])){
                    categories.add(parts[1]);
                }
            }
            scanner.close();    
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return categories;
    }

    public ArrayList<String> getItems(String c){
        ArrayList<String> items = new ArrayList<>();
        String filePath = "src\\DB\\MenuDB";
        Scanner scanner;
        try {
            scanner = new Scanner(new File(filePath));
        
            while(scanner.hasNextLine()){
                String menuItem = scanner.nextLine();
                String[] parts = menuItem.split(",");
                if(c.compareTo(parts[1]) == 0){
                    items.add(menuItem);
                }
            }
            scanner.close();    
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return items;
    }

    public Menu_Item create(String item){
        String[] parts = item.split(",");
        Menu_Item i = new Menu_Item(Integer.parseInt(parts[0]), parts[2], parts[1], 1, Double.parseDouble(parts[4]));
        return i;
    }
     
}
