import java.sql.*;
import java.util.Scanner;

/*WAP to call the store procedure to store employee details in the employee table. Use the concept
of class and object. */

public class MyProcedure{
    private
      String url = "jdbc:mysql://localhost:3306/java2025";
      String username = "root";
      String password = "";
      Connection conn;
      CallableStatement cs;
      Scanner sc;
      String name;
      double salary;
      String branch;
    public  
    MyProcedure(){
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            System.out.println(ex);
        } 
    }
    void insert(){
        try{
            String sql = "{CALL insertEmployee(?, ?, ?)}";
            cs = conn.prepareCall(sql);
            
            sc = new Scanner(System.in);
            System.out.println("Enter Name: ");
            name = sc.nextLine();
            System.out.println("Enter Salary: ");
            salary = sc.nextDouble();
            System.out.println("Enter Branch: ");
            branch = sc.next();
            
            cs.setString(1, name);
            cs.setDouble(2, salary);
            cs.setString(3, branch);
            cs.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    public static void main(String[] args){
        MyProcedure m = new MyProcedure();
        m.insert();
    }
}