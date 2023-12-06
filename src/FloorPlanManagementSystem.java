import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FloorPlanManagementSystem {
    private Map<Integer, TableRecord> floorPlan;

    public FloorPlanManagementSystem() {
        this.floorPlan = new HashMap<>();
        initializeFloorPlanFromDB("TableDB.csv");
    }

    private void initializeFloorPlanFromDB(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int tableID = Integer.parseInt(parts[0]);
                String tableStatus = parts[1].trim(); // Remove leading/trailing whitespaces

                TableRecord table = new TableRecord();
                table.initializeTab(tableID);
                table.table_status = tableStatus;

                floorPlan.put(tableID, table);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayFloorStatus() {
        System.out.println("Floor Status:");
        for (Map.Entry<Integer, TableRecord> entry : floorPlan.entrySet()) {
            int tableID = entry.getKey();
            TableRecord table = entry.getValue();
            System.out.println("Table ID: " + tableID + ", Status: " + table.table_status);
        }
    }

    public TableRecord getTable(int tableID) {
        return floorPlan.get(tableID);
    }
}
