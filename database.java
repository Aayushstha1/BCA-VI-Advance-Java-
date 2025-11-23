

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class database {
    public static void main(String[] args) {
      String url = "jdbc:mysql://localhost:3306/java2025";
      String username = "root";
        String password = "";
         try {

         // If you have the MySQL JDBC driver on the classpath this will attempt connection
         Connection conn = DriverManager.getConnection(url, username, password);
         java.sql.Statement stmt= conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM students");

         while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            String grade = rs.getString("grade");
            System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Grade: " + grade);
            
         }
          rs.close();
          stmt.close();
          conn.close();
        
         }
         catch (SQLException e ){
            e.printStackTrace();
         }
    }
}

