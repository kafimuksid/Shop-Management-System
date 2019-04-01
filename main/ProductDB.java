package main;
import javafx.application.Application;
import javafx.collections.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.sql.*;

public class ProductDB{
    Connection conn;
	Statement stmt;
	ResultSet rs;
    String JDBC_DRIVER;
    String DB_URL;
    String USER;
    String PASS;
	
    public ProductDB(){
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
	
    public int updateDB(String sql){
        int numOfRowsUpdated=0;
        try{
            stmt = conn.createStatement(); 
            numOfRowsUpdated=stmt.executeUpdate(sql);
            //System.out.println(numOfRowsUpdated+" row(s) updated");
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return numOfRowsUpdated;
    }
	ObservableList<Product> products = FXCollections.observableArrayList();
	public ObservableList<Product> getData(String query) { 
	
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            //System.out.println("Logged in");
			while(rs.next()){
				products.add(new Product(rs.getString("productName"),rs.getString("productID"),rs.getString("price"),rs.getString("stock"),rs.getString("categoryID")));
			}
        }
        catch(Exception ex){
            System.out.println("DB Read Error !");
            //ex.printStackTrace();
        }
        return products;
   }
}
