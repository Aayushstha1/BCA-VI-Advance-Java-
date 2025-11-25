import java.sql.*;
import java.util.Scanner;

public class Employee5 {

    static final String URL = "jdbc:mysql://localhost:3306/java2025";
    static final String USER = "root";
    static final String PASS = "";
    // single shared Scanner for System.in; do NOT close it
    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Load MySQL Driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("Driver Load Error: " + e);
        }

        // use shared scanner `sc`

        while (true) {
            System.out.println("\n===== EMPLOYEE MANAGEMENT SYSTEM =====");
            System.out.println("1. Insert employee");
            System.out.println("2. Update employee");
            System.out.println("3. Delete employee");
            System.out.println("4. Display all employees");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            String choiceLine = sc.nextLine().trim();
            int choice;
            try {
                choice = Integer.parseInt(choiceLine);
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                continue;
            }

            switch (choice) {
                case 1:
                    insertEmployee();
                    break;

                case 2:
                    updateEmployee();
                    break;

                case 3:
                    deleteEmployee();
                    break;

                case 4:
                    displayEmployees();
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    // INSERT EMPLOYEE
    public static void insertEmployee() {
          try (Connection con = DriverManager.getConnection(URL, USER, PASS);
              PreparedStatement pst = con.prepareStatement("INSERT INTO employee VALUES (?, ?, ?, ?)") ) {

            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();

            System.out.print("Enter Branch: ");
            String branch = sc.nextLine();

            pst.setInt(1, id);
            pst.setString(2, name);
            pst.setDouble(3, salary);
            pst.setString(4, branch);

            pst.executeUpdate();
            System.out.println("Employee inserted successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            if (e instanceof java.sql.SQLException) {
                java.sql.SQLException se = (java.sql.SQLException) e;
                System.out.println("SQLState: " + se.getSQLState() + ", ErrorCode: " + se.getErrorCode());
            }
        }
        pause();
    }

    // UPDATE EMPLOYEE
    public static void updateEmployee() {
          try (Connection con = DriverManager.getConnection(URL, USER, PASS);
              PreparedStatement pst = con.prepareStatement("UPDATE employee SET name=?, salary=?, branch=? WHERE id=?") ) {

            System.out.print("Enter Employee ID to Update: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter New Name: ");
            String name = sc.nextLine();

            System.out.print("Enter New Salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();

            System.out.print("Enter New Branch: ");
            String branch = sc.nextLine();

            pst.setString(1, name);
            pst.setDouble(2, salary);
            pst.setString(3, branch);
            pst.setInt(4, id);

            int rows = pst.executeUpdate();

            if (rows > 0)
                System.out.println("Employee updated successfully!");
            else
                System.out.println("Employee ID not found!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            if (e instanceof java.sql.SQLException) {
                java.sql.SQLException se = (java.sql.SQLException) e;
                System.out.println("SQLState: " + se.getSQLState() + ", ErrorCode: " + se.getErrorCode());
            }
        }
        pause();
    }

    // DELETE EMPLOYEE
    public static void deleteEmployee() {
          try (Connection con = DriverManager.getConnection(URL, USER, PASS);
              PreparedStatement pst = con.prepareStatement("DELETE FROM employee WHERE id=?") ) {

            System.out.print("Enter Employee ID to Delete: ");
                        int id = Integer.parseInt(sc.nextLine().trim());

                        pst.setInt(1, id);

            int rows = pst.executeUpdate();

            if (rows > 0)
                System.out.println("Employee deleted successfully!");
            else
                System.out.println("Employee ID not found!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            if (e instanceof java.sql.SQLException) {
                java.sql.SQLException se = (java.sql.SQLException) e;
                System.out.println("SQLState: " + se.getSQLState() + ", ErrorCode: " + se.getErrorCode());
            }
        }
        pause();
    }

    // DISPLAY EMPLOYEES
    public static void displayEmployees() {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             Statement st = con.createStatement()) {

            ResultSet rs = st.executeQuery("SELECT * FROM employee");

            System.out.println("\nID\tName\t\tSalary\t\tBranch");
            System.out.println("-----------------------------------------------");

            while (rs.next()) {
                System.out.println(
                        rs.getInt(1) + "\t" +
                        rs.getString(2) + "\t\t" +
                        rs.getDouble(3) + "\t\t" +
                        rs.getString(4)
                );
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            if (e instanceof java.sql.SQLException) {
                java.sql.SQLException se = (java.sql.SQLException) e;
                System.out.println("SQLState: " + se.getSQLState() + ", ErrorCode: " + se.getErrorCode());
            }
        }
        pause();
    }

    // small helper to pause so user can see result before returning to menu
    private static void pause() {
        System.out.print("\nPress Enter to continue...");
        try {
            sc.nextLine();
        } catch (Exception ignored) {
        }
    }
}
