import java.sql.*;
import java.util.*;

public class EmployeeApp {
    // EDIT THESE to match your DB credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/java2025?useSSL=false&serverTimezone=UTC";
    private static final String DB_USER = "root"; // change if needed
    private static final String DB_PASS = "password"; // change if needed

    private static final String TABLE = "employee";

    private final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new EmployeeApp().run();
    }

    private void run() {
        System.out.println("Employee CRUD Console (table: " + TABLE + ")");

        while (true) {
            printMenu();
            System.out.print("Enter your choice: ");
            String line = sc.nextLine().trim();
            int choice;
            try {
                choice = Integer.parseInt(line);
            } catch (Exception e) {
                System.out.println("Invalid choice, try again.");
                continue;
            }

            switch (choice) {
                case 1 -> insertEmployee();
                case 2 -> updateEmployee();
                case 3 -> deleteEmployee();
                case 4 -> displayAllEmployees();
                case 5 -> { System.out.println("Exiting."); return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\nEnter your choice...");
        System.out.println("1. Insert employee");
        System.out.println("2. Update employee");
        System.out.println("3. Delete employee");
        System.out.println("4. Display all employee");
        System.out.println("5. Exit");
    }

    private Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // Driver not found in classpath; user must add connector jar.
        }
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }

    private List<ColumnInfo> getColumns(Connection conn) throws SQLException {
        String q = "SELECT * FROM " + TABLE + " WHERE 1=0";
        try (PreparedStatement ps = conn.prepareStatement(q);
             ResultSet rs = ps.executeQuery()) {
            ResultSetMetaData md = rs.getMetaData();
            List<ColumnInfo> cols = new ArrayList<>();
            for (int i = 1; i <= md.getColumnCount(); i++) {
                cols.add(new ColumnInfo(md.getColumnLabel(i), md.getColumnType(i)));
            }
            return cols;
        }
    }

    private String getPrimaryKey(Connection conn) throws SQLException {
        DatabaseMetaData meta = conn.getMetaData();
        try (ResultSet pk = meta.getPrimaryKeys(null, null, TABLE)) {
            if (pk.next()) return pk.getString("COLUMN_NAME");
        }
        return null;
    }

    private void insertEmployee() {
        try (Connection conn = getConnection()) {
            List<ColumnInfo> cols = getColumns(conn);
            Map<String, String> values = new LinkedHashMap<>();
            System.out.println("Enter values for new row (leave blank for NULL):");
            for (ColumnInfo c : cols) {
                System.out.print(c.name + ": ");
                String v = sc.nextLine();
                if (v != null && v.isBlank()) v = null;
                values.put(c.name, v);
            }

            StringJoiner colNames = new StringJoiner(", ");
            StringJoiner params = new StringJoiner(", ");
            List<String> toSet = new ArrayList<>();
            for (var e : values.entrySet()) {
                if (e.getValue() != null) {
                    colNames.add(e.getKey());
                    params.add("?");
                    toSet.add(e.getValue());
                }
            }

            if (toSet.isEmpty()) {
                System.out.println("No values provided. Aborting insert.");
                return;
            }

            String sql = "INSERT INTO " + TABLE + " (" + colNames + ") VALUES (" + params + ")";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                for (int i = 0; i < toSet.size(); i++) ps.setString(i + 1, toSet.get(i));
                int count = ps.executeUpdate();
                System.out.println("Inserted " + count + " row(s).");
            }
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
    }

    private void updateEmployee() {
        try (Connection conn = getConnection()) {
            String pk = getPrimaryKey(conn);
            if (pk == null) {
                System.out.print("Primary key not detected. Enter column to identify row (e.g. id): ");
                pk = sc.nextLine().trim();
            } else System.out.println("Primary key detected: " + pk);

            System.out.print("Enter value of " + pk + " for the row to update: ");
            String pkValue = sc.nextLine();

            List<ColumnInfo> cols = getColumns(conn);
            Map<String, String> newValues = new LinkedHashMap<>();
            System.out.println("Enter new values (leave blank to keep existing):");
            for (ColumnInfo c : cols) {
                if (c.name.equalsIgnoreCase(pk)) continue;
                System.out.print(c.name + ": ");
                String v = sc.nextLine();
                if (v != null && !v.isBlank()) newValues.put(c.name, v);
            }

            if (newValues.isEmpty()) {
                System.out.println("No columns to update.");
                return;
            }

            StringJoiner sets = new StringJoiner(", ");
            for (String col : newValues.keySet()) sets.add(col + " = ?");
            String sql = "UPDATE " + TABLE + " SET " + sets + " WHERE " + pk + " = ?";

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                int idx = 1;
                for (String val : newValues.values()) ps.setString(idx++, val);
                ps.setString(idx, pkValue);
                int count = ps.executeUpdate();
                System.out.println("Updated " + count + " row(s).");
            }
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
    }

    private void deleteEmployee() {
        try (Connection conn = getConnection()) {
            String pk = getPrimaryKey(conn);
            if (pk == null) {
                System.out.print("Primary key not detected. Enter column to identify row (e.g. id): ");
                pk = sc.nextLine().trim();
            } else System.out.println("Primary key detected: " + pk);

            System.out.print("Enter value of " + pk + " to delete: ");
            String pkValue = sc.nextLine();

            String sql = "DELETE FROM " + TABLE + " WHERE " + pk + " = ?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, pkValue);
                int count = ps.executeUpdate();
                System.out.println("Deleted " + count + " row(s).");
            }
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
    }

    private void displayAllEmployees() {
        try (Connection conn = getConnection()) {
            String sql = "SELECT * FROM " + TABLE;
            try (PreparedStatement ps = conn.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {
                ResultSetMetaData md = rs.getMetaData();
                int cols = md.getColumnCount();
                // print header
                for (int i = 1; i <= cols; i++) {
                    System.out.print(md.getColumnLabel(i) + "\t");
                }
                System.out.println();
                // print rows
                while (rs.next()) {
                    for (int i = 1; i <= cols; i++) {
                        String v = rs.getString(i);
                        System.out.print((v == null ? "NULL" : v) + "\t");
                    }
                    System.out.println();
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
    }

    private static class ColumnInfo {
        final String name;
        final int type;

        ColumnInfo(String name, int type) {
            this.name = name;
            this.type = type;
        }
    }
}
