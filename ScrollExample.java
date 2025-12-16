// WAP to demonstrate concept of scrollable and updatable esult sets. 

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ScrollExample {
    private
       String url = "jdbc:mysql://localhost:3306/java2025";
        String username = "root";
        String password = "";
        Connection conn = null;
        Statement st = null;
        Resulset rs = null;

        public
        ScrollExample(){
            
        try{
            conn = DriverManager.getConnection(url, username, password); 
          st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
           String query = "SELECT id, name , salary, branch FROM employee";
            rs = st.executeQuery(query);


        } catch(SQLException ex){
            System.out.println(ex);
        }
         void lastRow {
            try{
                rs.last();
                 System.out.println("Last Row: ID = " rs.getInt("id")+ 
            ", Name = " + rs.getString("name")+
            ", Salary = " + rs.getDouble("salary")+
            ", branch = " + rs.getString("branch"));

            }catch(SQLException ex){
                System.out.println(ex);
            }
        
        }

        public static void main(String[] args) {
            ScrollExample s = new ScrollExample();
            s.lastRow();
        }
        
        }

        
    }

    

