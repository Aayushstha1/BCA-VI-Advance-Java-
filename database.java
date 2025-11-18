

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database {
    public static void main(String[] args) {
      String url = "jdbc:mysql://localhost:3306/java2025";
      String username = "root";
        String password = "";
         try {

         // If you have the MySQL JDBC driver on the classpath this will attempt connection
         Connection conn = DriverManager.getConnection(url, username, password);
         System.out.println("connecting....");
         if (conn != null) {
            System.out.println("Connected to database");
            conn.close();
         }

         }
         catch (SQLException e ){
            e.printStackTrace();
         }

    }
}
