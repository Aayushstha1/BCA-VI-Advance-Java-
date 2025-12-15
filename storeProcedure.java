import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.SQLException;

public class storeProcedure {
    public static void main(String[] args) {

        String URL = "jdbc:mysql://localhost:3306/java2025";
        String USER = "root";
        String PASS = "";

        try {
            // 1️⃣ Create connection
            Connection conn = DriverManager.getConnection(URL, USER, PASS);

            // 2️⃣ Prepare stored procedure
            String sql = "{CALL insertEmployee(?, ?, ?)}";
            CallableStatement cs = conn.prepareCall(sql);

            // 3️⃣ Set parameters
            cs.setString(1, "Aayush stha5");
            cs.setDouble(2, 50000.00);
            cs.setString(3, "KTM");

            // 4️⃣ Execute
            cs.executeUpdate();

            System.out.println("Inserted successfully");

            // 5️⃣ Close connection
            cs.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
