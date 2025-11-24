

// import java.sql.*;
// import java.util.Scanner;

// public class Employees2  {

//     // Database credentials
//     static final String URL = "jdbc:mysql://localhost:3306/java2025";
//     static final String USER = "root";
//     static final String PASS = "";

//     public static void main(String[] args) {

//         Scanner sc = new Scanner(System.in);

//         while (true) {
//             System.out.println("\n==== EMPLOYEE MANAGEMENT SYSTEM ====");
//             System.out.println("1. Insert Employee");
//             System.out.println("2. Update Employee");
//             System.out.println("3. Delete Employee");
//             System.out.println("4. Display All Employees");
//             System.out.println("5. Exit");
//             System.out.print("Enter your choice: ");

//             int choice = sc.nextInt();

//             switch (choice) {
//                 case 1:
//                     insertEmployee(sc);
//                     break;
//                 case 2:
//                     updateEmployee(sc);
//                     break;
//                 case 3:
//                     deleteEmployee(sc);
//                     break;
//                 case 4:
//                     displayEmployees();
//                     break;
//                 case 5:
//                     System.out.println("Exiting program...");
//                     System.exit(0);
//                 default:
//                     System.out.println("Invalid Choice! Try again.");
//             }
//         }
//     }

//     // ---------------- INSERT ----------------
//     public static void insertEmployee(Scanner sc) {
//         try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {

//             System.out.print("Enter ID: ");
//             int id = sc.nextInt();
//             sc.nextLine(); // clear buffer

//             System.out.print("Enter Name: ");
//             String name = sc.nextLine();

//             System.out.print("Enter Salary: ");
//             double salary = sc.nextDouble();
//             sc.nextLine();

//             System.out.print("Enter Branch: ");
//             String branch = sc.nextLine();

//             String sql = "INSERT INTO employee VALUES (?, ?, ?, ?)";
//             PreparedStatement ps = con.prepareStatement(sql);

//             ps.setInt(1, id);
//             ps.setString(2, name);
//             ps.setDouble(3, salary);
//             ps.setString(4, branch);

//             ps.executeUpdate();
//             System.out.println("Employee Inserted Successfully!");

//         } catch (Exception e) {
//             System.out.println("Error: " + e);
//         }
//     }

//     // ---------------- UPDATE ----------------
//     public static void updateEmployee(Scanner sc) {
//         try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {

//             System.out.print("Enter ID to Update: ");
//             int id = sc.nextInt();
//             sc.nextLine();

//             System.out.print("Enter New Name: ");
//             String name = sc.nextLine();

//             System.out.print("Enter New Salary: ");
//             double salary = sc.nextDouble();
//             sc.nextLine();

//             System.out.print("Enter New Branch: ");
//             String branch = sc.nextLine();

//             String sql = "UPDATE employee SET name=?, salary=?, branch=? WHERE id=?";
//             PreparedStatement ps = con.prepareStatement(sql);

//             ps.setString(1, name);
//             ps.setDouble(2, salary);
//             ps.setString(3, branch);
//             ps.setInt(4, id);

//             int rows = ps.executeUpdate();

//             if (rows > 0)
//                 System.out.println("Employee Updated Successfully!");
//             else
//                 System.out.println("Employee Not Found!");

//         } catch (Exception e) {
//             System.out.println("Error: " + e);
//         }
//     }

//     // ---------------- DELETE ----------------
//     public static void deleteEmployee(Scanner sc) {
//         try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {

//             System.out.print("Enter ID to Delete: ");
//             int id = sc.nextInt();

//             String sql = "DELETE FROM employee WHERE id=?";
//             PreparedStatement ps = con.prepareStatement(sql);
//             ps.setInt(1, id);

//             int rows = ps.executeUpdate();

//             if (rows > 0)
//                 System.out.println("Employee Deleted Successfully!");
//             else
//                 System.out.println("Employee Not Found!");

//         } catch (Exception e) {
//             System.out.println("Error: " + e);
//         }
//     }

//     // ---------------- DISPLAY ----------------
//     public static void displayEmployees() {
//         try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {

//             String sql = "SELECT * FROM employee";
//             Statement st = con.createStatement();
//             ResultSet rs = st.executeQuery(sql);

//             System.out.println("\n--- ALL EMPLOYEES ---");

//             while (rs.next()) {
//                 System.out.println(
//                         "ID: " + rs.getInt("id") +
//                         ", Name: " + rs.getString("name") +
//                         ", Salary: " + rs.getDouble("salary") +
//                         ", Branch: " + rs.getString("branch"));
//             }

//         } catch (Exception e) {
//             System.out.println("Error: " + e);
//         }
//     }
// }

import java.util.Scanner;

public class Employees2 {
     private
     String url = "jdbc:mysql://localhost:3306/java2025";
     String username = "root";
     String password = "";
     public 
     Connection  connect (){
        try{
            conn = DriverManager.getConnection(url, username, password);
            return conn;

        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
         void display (){
            try{
                sql = "SELECT * FROM employee";
                ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next( )) {
                    
            }
            }
            catch (SQLException e) {
                e.printStackTrace();
         }

         void insert(){
            try{
                Scanner sc = new Scanner(System.in);
                sql = "INSERT INTO employee (id, name, salary, branch) VALUES (?,?,?,?)";
                ps = conn.prepareStatement(sql);
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter Name, salary, branch: ");
                String name = sc.nextLine();
                double salary = sc.nextDouble();
                String branch = sc.next();

                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, name);       // name
                ps.setDouble(2, salary);       // salary
                ps.setString(3, branch);      // branch
            }
         }
     }
}