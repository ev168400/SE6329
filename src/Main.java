import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static RestaurantSystemController restaurantSystemController;
    public static void main(String[] args) throws Exception {
        restaurantSystemController = new RestaurantSystemController();
       
        Scanner scanner = new Scanner(System.in);

        restaurantSystemController.DisplayTables();
        
        //Get User Input for Table selected
        int tableChosen = scanner.nextInt();
        restaurantSystemController.SelectTable(tableChosen);
        
        //Display Options (Add Item, Place Order, Order Payment)
        restaurantSystemController.DisplayOptions();
        //Get user input - option
        int option = scanner.nextInt();

        while(option == 1){
            ArrayList<String> categories = restaurantSystemController.DisplayCategories();
            
            int categoryChosen = scanner.nextInt();

            restaurantSystemController.DisplayItems(categories.get(categoryChosen-1));

            int itemChosen = scanner.nextInt();

            restaurantSystemController.AddItem(itemChosen, tableChosen, categories.get(categoryChosen-1));
            restaurantSystemController.DisplayOptions();

            //Get user input - option
            option = scanner.nextInt();
        }

        
        restaurantSystemController.SelectPlaceOrder(tableChosen);

        //Display Order Confirmation
        RestaurantSystemController.DisplayConfirmation();

        //Display order and cost
        RestaurantSystemController.DisplayOrderandCost(tableChosen);
        //Get User input

        RestaurantSystemController.DisplayPaymentInputFields();
        System.out.print("Enter Card Number: ");
        int cardNum = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Card Expiration Date: ");
        String ExpDate = scanner.nextLine();
        System.out.print("Enter Card CVC: ");
        int CVC = scanner.nextInt();

        restaurantSystemController.EnterPayment(cardNum, ExpDate, CVC, tableChosen);
        
        scanner.close();
    }
}
 