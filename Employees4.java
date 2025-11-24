/* Create a java program using employee table, your program's output should display choices, For example:
        Enter your choice...
        1. Insert employee
        2. update employee
        3. delete employee
        4. display all employee
        5. exit
   Based on user choice your program should able to perform choosen opreation on employee table.    
*/  

import java.sql.*;
import java.util.Scanner;

public class Employees4 {
    private
        String url = "jdbc:mysql://localhost:3306/java2025";
        String username = "root";
        String password = "";
        Connection conn;
        PreparedStatement ps;
        String sql;
    public
        //It returns connection
        Connection connect(){
            try{
                 conn = DriverManager.getConnection(url, username, password);
                 return conn;
            }
            catch(SQLException e){
                e.printStackTrace();
            }
            return null;
        }
       
       //display all employee details
       void display(){
           try{
           sql = "SELECT * FROM employee";
           ps= connect().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }
           }
           catch(SQLException e){
               e.printStackTrace();
           }
       }
       
       //Insert into employee table
       void insert(){
           try{
            sql = "INSERT INTO employee (name, salary, branch) VALUES (?, ?, ?)";
            ps= connect().prepareStatement(sql);
           
            Scanner sc = new Scanner(System.in);  
            System.out.println("Enter name, salary and branch :");
            String name = sc.next();
            double salary = sc.nextDouble();
            String branch = sc.next();
           
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setDouble(2, salary);
            ps.setString(3, branch);
            ps.executeUpdate();
           }
           catch(SQLException e){
               e.printStackTrace();
           }
        }    
       
      //delete employee  
      void delete(){
           try{
            sql = "DELETE FROM employee WHERE id = ?";
            ps= connect().prepareStatement(sql);
           
            Scanner sc = new Scanner(System.in);  
            System.out.println("Enter id:");
            int id = sc.nextInt();
           
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
           }
           catch(SQLException e){
               e.printStackTrace();
           }
      }
     
      //update salary
      void updateSalary(){
          try{
            sql = "UPDATE employee SET salary = ? WHERE id = ?";
            ps= connect().prepareStatement(sql);
           
            Scanner sc = new Scanner(System.in);  
            System.out.println("Enter id:");
            int id = sc.nextInt();
            System.out.println("Enter updated salary:");
            double salary = sc.nextDouble();
           
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, salary);
            ps.setInt(2, id);
            ps.executeUpdate();
           }
           catch(SQLException e){
               e.printStackTrace();
           }
      }
     
      //update name
      void updateName(){
          try{
            sql = "UPDATE employee SET name = ? WHERE id = ?";
            ps= connect().prepareStatement(sql);
           
            Scanner sc = new Scanner(System.in);  
            System.out.println("Enter id: ");
            int id = sc.nextInt();
            System.out.println("Enter new name: ");
            String name = sc.next();
           
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, id);
            ps.executeUpdate();
           }
           catch(SQLException e){
               e.printStackTrace();
           }
      }
     
      //update name
      void updateBranch(){
          try{
            sql = "UPDATE employee SET branch = ? WHERE id = ?";
            ps= connect().prepareStatement(sql);
           
            Scanner sc = new Scanner(System.in);  
            System.out.println("Enter id: ");
            int id = sc.nextInt();
            System.out.println("Enter new branch: ");
            String branch = sc.next();
           
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, branch);
            ps.setInt(2, id);
            ps.executeUpdate();
           }
           catch(SQLException e){
               e.printStackTrace();
           }
      }
       public static void main(String[] args){
           EmployeeOperations emp = new EmployeeOperations();
           /*emp.display();
           emp.insert();
           emp.delete();
           emp.updateSalary();
           emp.updateName();
           emp.updateBranch();*/
       }
}