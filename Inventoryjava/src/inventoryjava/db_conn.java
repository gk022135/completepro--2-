import java.sql.*;


public class db_conn {
    public static void main(String[] args) {
        try{
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/khata","root","admin");
            System.out.print(con);
        }
        catch (SQLException e)
        {
            System.out.print("ERROR");
        }    
    }
    
}
