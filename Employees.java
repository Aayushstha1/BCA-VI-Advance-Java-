import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Employees {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/java2025";
        String username = "root";
        String password = "";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "INSERT INTO employee (id, name, salary, branch) VALUES (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, 1);                // id (int)
            ps.setString(2, "Samir");       // name
            ps.setDouble(3, 60000.0);       // salary
            ps.setString(4, "dharan");      // branch
            ps.executeUpdate();
            System.out.println("Insert complete.");
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}