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
    private String url = "jdbc:mysql://localhost:3306/java2025";
    private String username = "root";
    private String password = "";
    private Connection conn = null;

    // It returns connection
    Connection connect() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(url, username, password);
            }
            return conn;
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
            return null;
        }
    }

    // display all employee details
    void display() {
        String sql = "SELECT * FROM employee";
        try (Connection c = connect()) {
            if (c == null) return;
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            System.out.println("\n--- ALL EMPLOYEES ---");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double salary = rs.getDouble("salary");
                String branch = rs.getString("branch");
                System.out.println("ID: " + id + ", Name: " + name + ", Salary: " + salary + ", Branch: " + branch);
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Insert into employee table
    void insert() {
        String sql = "INSERT INTO employee (id, name, salary, branch) VALUES (?, ?, ?, ?)";
        try (Connection c = connect()) {
            if (c == null) return;
            PreparedStatement ps = c.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter id: ");
            int id = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Enter name: ");
            String name = sc.nextLine().trim();
            System.out.print("Enter salary: ");
            double salary = Double.parseDouble(sc.nextLine().trim());
            System.out.print("Enter branch: ");
            String branch = sc.nextLine().trim();

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setDouble(3, salary);
            ps.setString(4, branch);
            int rows = ps.executeUpdate();
            System.out.println(rows + " row(s) inserted.");
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // delete employee
    void delete() {
        String sql = "DELETE FROM employee WHERE id = ?";
        try (Connection c = connect()) {
            if (c == null) return;
            PreparedStatement ps = c.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter id: ");
            int id = Integer.parseInt(sc.nextLine().trim());
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            System.out.println(rows + " row(s) deleted.");
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // update salary
    void updateSalary() {
        String sql = "UPDATE employee SET salary = ? WHERE id = ?";
        try (Connection c = connect()) {
            if (c == null) return;
            PreparedStatement ps = c.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter id: ");
            int id = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Enter updated salary: ");
            double salary = Double.parseDouble(sc.nextLine().trim());
            ps.setDouble(1, salary);
            ps.setInt(2, id);
            int rows = ps.executeUpdate();
            System.out.println(rows + " row(s) updated.");
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // update name
    void updateName() {
        String sql = "UPDATE employee SET name = ? WHERE id = ?";
        try (Connection c = connect()) {
            if (c == null) return;
            PreparedStatement ps = c.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter id: ");
            int id = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Enter new name: ");
            String name = sc.nextLine().trim();
            ps.setString(1, name);
            ps.setInt(2, id);
            int rows = ps.executeUpdate();
            System.out.println(rows + " row(s) updated.");
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // update branch
    void updateBranch() {
        String sql = "UPDATE employee SET branch = ? WHERE id = ?";
        try (Connection c = connect()) {
            if (c == null) return;
            PreparedStatement ps = c.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter id: ");
            int id = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Enter new branch: ");
            String branch = sc.nextLine().trim();
            ps.setString(1, branch);
            ps.setInt(2, id);
            int rows = ps.executeUpdate();
            System.out.println(rows + " row(s) updated.");
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Employees4 emp = new Employees4();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nEnter your choice...");
            System.out.println("1. Insert employee");
            System.out.println("2. Update employee");
            System.out.println("3. Delete employee");
            System.out.println("4. Display all employee");
            System.out.println("5. Exit");
            System.out.print("Choice: ");
            String input = sc.nextLine().trim();
            int choice;
            try { choice = Integer.parseInt(input); } catch (NumberFormatException e) { System.out.println("Invalid choice"); continue; }

            switch (choice) {
                case 1:
                    emp.insert();
                    break;
                case 2:
                    System.out.println("Update: 1) Salary 2) Name 3) Branch");
                    System.out.print("Select update field: ");
                    String u = sc.nextLine().trim();
                    if ("1".equals(u)) emp.updateSalary();
                    else if ("2".equals(u)) emp.updateName();
                    else if ("3".equals(u)) emp.updateBranch();
                    else System.out.println("Invalid update option");
                    break;
                case 3:
                    emp.delete();
                    break;
                case 4:
                    emp.display();
                    break;
                case 5:
                    System.out.println("Exiting. Goodbye.");
                    try { if (emp.conn != null && !emp.conn.isClosed()) emp.conn.close(); } catch (SQLException ignore) {}
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}