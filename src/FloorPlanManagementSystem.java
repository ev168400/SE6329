import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FloorPlanManagementSystem {
    public FloorPlanManagementSystem(){}

    public ArrayList<String> getTables(){
        ArrayList<String> tables = new ArrayList<>();
        String filePath = "src\\DB\\TableDB";
        Scanner scanner;
        try {
            scanner = new Scanner(new File(filePath));
        
        
            while(scanner.hasNextLine()){
                String tableInfo = scanner.nextLine();
                tables.add(tableInfo);
            }
            scanner.close();    
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return tables;
    }
}
 