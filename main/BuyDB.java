package main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBADDP{
    Connection conn;
	Statement stmt;
	ResultSet rs;
    String JDBC_DRIVER;
    String DB_URL;
    String USER;
    String PASS;
	
    public DBADDP(){
        JDBC_DRIVER = "com.mysql.jdbc.Driver";
        DB_URL = "jdbc:mysql://localhost:3306/shoppingcart";
        USER = "root";
        PASS = "";

        try{
            Class.forName(JDBC_DRIVER);
            //System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void close()throws SQLException{
        if(rs!=null)rs.close();
        if(rs!=null)stmt.close();
    }
	
    public int updateDB(String sql){
        int numOfRowsUpdated=0;
        try{
            stmt = conn.createStatement(); 
            numOfRowsUpdated=stmt.executeUpdate(sql);
			
            //System.out.println(numOfRowsUpdated+" row(s) updated");
        }
        catch(Exception ex){
            System.out.println("Exception occured");
        }
        return numOfRowsUpdated;
    }
}