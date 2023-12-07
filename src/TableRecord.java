import java.util.ArrayList;

public class TableRecord {
    int table_ID;
    String table_status;
    ArrayList<Menu_Item> table_tab;

    public TableRecord(){}

    public ArrayList<Menu_Item> initializeTab(int t){
        table_tab = new ArrayList<Menu_Item>();
        table_status = "Occupied";
        table_ID = t;
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
