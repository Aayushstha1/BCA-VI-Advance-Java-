

public class person {
     public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/person";
        String username = "root";
        String password = "";

         try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "INSERT INTO person (id, name, age, address) VALUES (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, 1);                
            ps.setString(2, "Samir");       
            ps.setDouble(3, 15);       
            ps.setString(4, "dharan");      
            ps.executeUpdate();
            System.out.println("Insert complete.");
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
}


}
