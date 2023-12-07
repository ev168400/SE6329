import java.util.ArrayList;
 
public class TableRecord {
    int table_ID;
    String table_status;
    ArrayList<Menu_Item> table_tab;

    public TableRecord(String t){
        String[] parts = t.split(",");
        this.table_ID = Integer.parseInt(parts[0].trim());
        this.table_status = parts[1].trim();
    }

    public ArrayList<Menu_Item> initializeTab(int t){
        table_tab = new ArrayList<Menu_Item>();
        table_status = "Occupied";
        return table_tab;
    }
    public ArrayList<Menu_Item> updateTableTab(Menu_Item i){
        table_tab.add(i);
        return table_tab;
    }
}

/*
 * Changes
 * 1. changed return type of both
 */
