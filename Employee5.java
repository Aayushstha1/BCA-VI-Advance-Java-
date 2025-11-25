import java.sql.*;
import java.util.Scanner;

public class Employee5 {

    static final String URL = "jdbc:mysql://localhost:3306/java2025";
    static final String USER = "root";
    static final String PASS = "";
    // single shared Scanner for System.in; do NOT close it
    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Startup driver check and helpful message if driver not available
        checkJdbcDriver();

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

    // Print a helpful warning if no MySQL JDBC driver is available on the runtime classpath
    private static void checkJdbcDriver() {
        boolean found = false;
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                found = true;
            } catch (ClassNotFoundException e) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    found = true;
                } catch (ClassNotFoundException ignored) {
                    // no driver class found via Class.forName
                }
            }

            if (!found) {
                // try to inspect registered drivers
                java.util.Enumeration<java.sql.Driver> en = java.sql.DriverManager.getDrivers();
                while (en.hasMoreElements()) {
                    java.sql.Driver d = en.nextElement();
                    String cn = d.getClass().getName().toLowerCase();
                    if (cn.contains("mysql")) { found = true; break; }
                }
            }
        } catch (Exception ignored) {
        }

        if (!found) {
            System.out.println("\nWARNING: MySQL JDBC driver not found on runtime classpath.");
            System.out.println("If you see 'No suitable driver found' when performing DB operations,\nput the Connector/J JAR in the project folder and run with it on the classpath.");
            System.out.println("Example (PowerShell):");
            System.out.println("  & 'C:\\Program Files\\Java\\jdk-24\\bin\\javac.exe' -cp \".;mysql-connector-java-8.1.0.jar\" Employee5.java");
            System.out.println("  & 'C:\\Program Files\\Java\\jdk-24\\bin\\java.exe' -cp \".;mysql-connector-java-8.1.0.jar\" Employee5\n");
        }
    }

    // INSERT EMPLOYEE
    public static void insertEmployee() {
          try (Connection con = DriverManager.getConnection(URL, USER, PASS);
              PreparedStatement pst = con.prepareStatement("INSERT INTO employee VALUES (?, ?, ?, ?)") ) {

            System.out.print("Enter ID: ");
            int id = Integer.parseInt(sc.nextLine().trim());

            if (existsId(id)) {
                System.out.println("Employee ID " + id + " already exists. Insert aborted.");
                return;
            }

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
          try (Connection con = getConnection();
              PreparedStatement pst = con.prepareStatement("UPDATE employee SET name=?, salary=?, branch=? WHERE id=?") ) {

            System.out.print("Enter Employee ID to Update: ");
            int id = Integer.parseInt(sc.nextLine().trim());

            if (!existsId(id)) {
                System.out.println("Employee ID " + id + " not found. Update aborted.");
                return;
            }

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

            System.out.print("Confirm update (y/n): ");
            String confirm = sc.nextLine().trim();
            if (!confirm.equalsIgnoreCase("y")) {
                System.out.println("Update cancelled.");
                return;
            }

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
          try (Connection con = getConnection();
              PreparedStatement pst = con.prepareStatement("DELETE FROM employee WHERE id=?") ) {

            System.out.print("Enter Employee ID to Delete: ");

            int id = Integer.parseInt(sc.nextLine().trim());

            if (!existsId(id)) {
                System.out.println("Employee ID " + id + " not found. Delete aborted.");
                return;
            }

            System.out.print("Are you sure you want to delete employee ID " + id + "? (y/n): ");
            String confirm = sc.nextLine().trim();
            if (!confirm.equalsIgnoreCase("y")) {
                System.out.println("Delete cancelled.");
                return;
            }

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
           try (Connection con = getConnection();
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

    // Returns true if a row with given id exists in the employee table
    private static boolean existsId(int id) {
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM employee WHERE id = ?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.out.println("Error checking id existence: " + e.getMessage());
        }
        return false;
    }

    // Helper to load driver (if available) and open a connection. Provides clearer messaging
    private static Connection getConnection() throws SQLException {
        try {
            // try current driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            try {
                // fallback to older driver class name
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                // driver class not found on classpath -- let DriverManager throw a clear exception
            }
        }
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
