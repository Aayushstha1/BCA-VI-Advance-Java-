

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class database2 {
    public static void main(String[] args) {
      String url = "jdbc:mysql://localhost:3306/java2025";
      String username = "root";
        String password = "";
         try {


         Class.forName("com.mysql.cj.jdbc.Driver");

         Connection conn = DriverManager.getConnection(url, username, password);
         java.sql.Statement stmt= conn.createStatement();
        //  ResultSet rs = stmt.executeQuery("SELECT * FROM employee");
         String sql = "INSERT INTO employee (id, name, salary, branch) VALUES ('4', 'Aayush', 50000, 'IT')";
          stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery("SELECT * FROM employee");




         while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int salary = rs.getInt("salary");
            String branch = rs.getString("branch");
            System.out.println("ID: " + id + ", Name: " + name + ", salary: " + salary + ", branch: " + branch);
            
         }
          rs.close();
          stmt.close();
          conn.close();
        
         }
         catch (SQLException e ){
            e.printStackTrace();
         }
         catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found in classpath.");
            e.printStackTrace();
         }
    }
}

