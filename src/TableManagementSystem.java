import java.util.ArrayList;
 
public class TableManagementSystem {
    ArrayList<TableRecord> tables;

    public TableManagementSystem(){
        tables = new ArrayList<>();
    }

    public ArrayList<TableRecord> getTables(){ return tables;}
    
    public ArrayList<Menu_Item> SelectTable(String t){
        TableRecord table = new TableRecord(t);
        tables.add(table);
        return table.initializeTab(table.table_ID);
    }
    public ArrayList<Menu_Item> UpdateTable(Menu_Item i, int table_ID){
        for(TableRecord t : tables){
            if(t.table_ID == table_ID){
                t.updateTableTab(i);
                return t.table_tab;
            }
        }
        return null;
    }
}

/*
 * Changes
 * 1. Added attribute
 * 2. added paramter to update Table
 * 3. changed return type of selectTable
 * 4. changed select table parameter to int
 */