package coursemanagement.main;
import java.sql.Connection;

import coursemanagement.commond.DbConnection;
import coursemanagement.menu.MainMenu;

public class Main {
    public static void main(String[] args) {
        MainMenu.mainMenu();
        Connection conn = DbConnection.connection();
        if(conn!=null){
            System.out.println("PostgreSQL-e ugurla qosuldun!");
        }
        else {
            System.out.println("Qosulma alinmadi");
        }

    }
}
