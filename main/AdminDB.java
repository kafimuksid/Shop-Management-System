package main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminDB{
    Connection conn;
	Statement stmt;
	ResultSet rs = null;
    String JDBC_DRIVER;
    String DB_URL;
    String USER;
    String PASS;
	
    public AdminDB(){
        JDBC_DRIVER = "com.mysql.jdbc.Driver";
        DB_URL = "jdbc:mysql://localhost:3306/shoppingcart";
        USER = "root";
        PASS = "";

        try{
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database...");
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
    
	public ResultSet getData(String query) { 
        try{
            stmt = conn.createStatement();
            rs= stmt.executeQuery(query);
            //System.out.println("Logged in");
        }
        catch(Exception ex){
            System.out.println("DB Read Error !");
            //ex.printStackTrace();
        }
        return rs;
   }
   public void updateDB(String sql){
        //int numOfRowsUpdated=0;
        try{
            stmt = conn.createStatement(); 
            stmt.executeUpdate(sql);
            System.out.println("updated");
        }
        catch(Exception ex){
            System.out.println("read error");
        }
        //return numOfRowsUpdated;
    }
}