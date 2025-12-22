// WAP to demonstrate concept of scrollable and updatable result sets. 

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ScrollExample {
    private String url = "jdbc:mysql://localhost:3306/java2025";
    private String username = "root";
    private String password = "";
    private Connection conn = null;
    private Statement st = null;
    private ResultSet rs = null;

    public ScrollExample(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password); 
            st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "SELECT id, name , salary, branch FROM employee";
            rs = st.executeQuery(query);
        } catch(SQLException ex){
            System.out.println(ex);
        } catch(ClassNotFoundException ex){
            System.out.println("MySQL JDBC driver not found: " + ex);
        }
    }

    public void lastRow() {
        if (rs == null) {
            System.out.println("Cannot retrieve last row: ResultSet is null (check database connection and JDBC driver)." );
            return;
        }
        try{
            rs.last();
            System.out.println("Last Row: ID = " + rs.getInt("id") + 
                ", Name = " + rs.getString("name") +
                ", Salary = " + rs.getDouble("salary") +
                ", branch = " + rs.getString("branch"));
        } catch(SQLException ex){
            System.out.println(ex);
        }
    }

    public void updateAbsoluteRow(int i) {
        if (rs == null) {
            System.out.println("Cannot update row: ResultSet is null (check database connection and JDBC driver)." );
            return;
        }
        try {
            if (rs.absolute(i)) {
                rs.updateString("name", "HRI lal");
                rs.updateDouble("salary", 50000.0);
                rs.updateString("branch", "BDM");
                rs.updateRow();
                System.out.println("Updated Row: ID = " + rs.getInt("id") + 
                    ", Name = " + rs.getString("name") +
                    ", Salary = " + rs.getDouble("salary") +
                    ", branch = " + rs.getString("branch"));
            } else {
                System.out.println("Row " + i + " does not exist.");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        ScrollExample s = new ScrollExample();
        s.updateAbsoluteRow(3);
    }
}

    

