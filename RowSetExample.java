public class RowSetExample {
    private String url = "jdbc:mysql://localhost:3306/java2025";
    private String username = "root";
    private String password = "";

    public RowSetExample() {
        try{
        JdbcRowSet row = RowSetProvider.newFactory().createJdbcRowSet();
        row.setUrl(url);
        row.setUsername(username);
        row.setPassword(password);
        } catch(SQLException ex){
            System.out.println(ex);
        }

    }
    
    public static void main(String[] args) {
        RowSetExample example = new RowSetExample();

    }
    
}
