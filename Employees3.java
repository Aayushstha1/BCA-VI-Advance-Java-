import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Employees3 {

    // Database credentials (kept for DB mode)
    static final String URL = "jdbc:mysql://localhost:3306/your_database_name";
    static final String USER = "root";
    static final String PASS = "your_password";

    // In-memory store used when JDBC driver is not available
    static class Employee {
        int id;
        String name;
        double salary;
        String branch;

        Employee(int id, String name, double salary, String branch) {
            this.id = id;
            this.name = name;
            this.salary = salary;
            this.branch = branch;
        }

        @Override
        public String toString() {
            return "ID: " + id + ", Name: " + name + ", Salary: " + salary + ", Branch: " + branch;
        }
    }

    static final List<Employee> inMemory = new ArrayList<>();
    static boolean hasJdbc = true;

    public static void main(String[] args) {
        // Check for JDBC driver availability
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Throwable t) {
            hasJdbc = false;
            System.out.println("MySQL JDBC driver not found on classpath — falling back to in-memory mode.");
        }

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== EMPLOYEE MANAGEMENT SYSTEM ====");
            System.out.println("1. Insert Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Display All Employees");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            String input = sc.nextLine().trim();
            int choice;
            try { choice = Integer.parseInt(input); } catch (NumberFormatException e) { System.out.println("Invalid choice"); continue; }

            switch (choice) {
                case 1:
                    if (hasJdbc) insertEmployeeDB(sc); else insertEmployeeMemory(sc);
                    break;
                case 2:
                    if (hasJdbc) updateEmployeeDB(sc); else updateEmployeeMemory(sc);
                    break;
                case 3:
                    if (hasJdbc) deleteEmployeeDB(sc); else deleteEmployeeMemory(sc);
                    break;
                case 4:
                    if (hasJdbc) displayEmployeesDB(); else displayEmployeesMemory();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid Choice! Try again.");
            }
        }
    }

    // ---------- In-memory implementations ----------
    public static void insertEmployeeMemory(Scanner sc) {
        try {
            System.out.print("Enter ID: ");
            int id = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Enter Name: ");
            String name = sc.nextLine().trim();
            System.out.print("Enter Salary: ");
            double salary = Double.parseDouble(sc.nextLine().trim());
            System.out.print("Enter Branch: ");
            String branch = sc.nextLine().trim();
            inMemory.add(new Employee(id, name, salary, branch));
            System.out.println("Employee Inserted Successfully (in-memory)!");
        } catch (Exception e) {
            System.out.println("Error inserting employee: " + e.getMessage());
        }
    }

    public static void updateEmployeeMemory(Scanner sc) {
        try {
            System.out.print("Enter ID to Update: ");
            int id = Integer.parseInt(sc.nextLine().trim());
            Employee found = null;
            for (Employee emp : inMemory) if (emp.id == id) { found = emp; break; }
            if (found == null) { System.out.println("Employee Not Found!"); return; }
            System.out.print("Enter New Name: "); found.name = sc.nextLine().trim();
            System.out.print("Enter New Salary: "); found.salary = Double.parseDouble(sc.nextLine().trim());
            System.out.print("Enter New Branch: "); found.branch = sc.nextLine().trim();
            System.out.println("Employee Updated Successfully (in-memory)!");
        } catch (Exception e) {
            System.out.println("Error updating employee: " + e.getMessage());
        }
    }

    public static void deleteEmployeeMemory(Scanner sc) {
        try {
            System.out.print("Enter ID to Delete: ");
            int id = Integer.parseInt(sc.nextLine().trim());
            boolean removed = inMemory.removeIf(emp -> emp.id == id);
            if (removed) System.out.println("Employee Deleted Successfully (in-memory)!"); else System.out.println("Employee Not Found!");
        } catch (Exception e) {
            System.out.println("Error deleting employee: " + e.getMessage());
        }
    }

    public static void displayEmployeesMemory() {
        System.out.println("\n--- ALL EMPLOYEES (in-memory) ---");
        if (inMemory.isEmpty()) System.out.println("No employees found.");
        else inMemory.forEach(emp -> System.out.println(emp));
    }

    // ---------- Database-backed implementations (unchanged logic but guarded) ----------
    public static void insertEmployeeDB(Scanner sc) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            System.out.print("Enter ID: ");
            int id = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Enter Name: ");
            String name = sc.nextLine().trim();
            System.out.print("Enter Salary: ");
            double salary = Double.parseDouble(sc.nextLine().trim());
            System.out.print("Enter Branch: ");
            String branch = sc.nextLine().trim();
            String sql = "INSERT INTO employee VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id); ps.setString(2, name); ps.setDouble(3, salary); ps.setString(4, branch);
            ps.executeUpdate();
            System.out.println("Employee Inserted Successfully (DB)!");
        } catch (Exception e) { System.out.println("Error: " + e); }
    }

    public static void updateEmployeeDB(Scanner sc) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            System.out.print("Enter ID to Update: ");
            int id = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Enter New Name: ");
            String name = sc.nextLine().trim();
            System.out.print("Enter New Salary: ");
            double salary = Double.parseDouble(sc.nextLine().trim());
            System.out.print("Enter New Branch: ");
            String branch = sc.nextLine().trim();
            String sql = "UPDATE employee SET name=?, salary=?, branch=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name); ps.setDouble(2, salary); ps.setString(3, branch); ps.setInt(4, id);
            int rows = ps.executeUpdate();
            if (rows > 0) System.out.println("Employee Updated Successfully (DB)!"); else System.out.println("Employee Not Found!");
        } catch (Exception e) { System.out.println("Error: " + e); }
    }

    public static void deleteEmployeeDB(Scanner sc) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            System.out.print("Enter ID to Delete: ");
            int id = Integer.parseInt(sc.nextLine().trim());
            String sql = "DELETE FROM employee WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) System.out.println("Employee Deleted Successfully (DB)!"); else System.out.println("Employee Not Found!");
        } catch (Exception e) { System.out.println("Error: " + e); }
    }

    public static void displayEmployeesDB() {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            String sql = "SELECT * FROM employee";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            System.out.println("\n--- ALL EMPLOYEES (DB) ---");
            while (rs.next()) {
                System.out.println(
                        "ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Salary: " + rs.getDouble("salary") +
                        ", Branch: " + rs.getString("branch"));
            }
        } catch (Exception e) { System.out.println("Error: " + e); }
    }

}
