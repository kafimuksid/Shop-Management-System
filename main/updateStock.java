package main;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import java.sql.*;

public class updateStock extends Application{
	static Stage classStage = new Stage();
	Alert alert = new Alert(AlertType.WARNING);
	TableView<Product> table;
	@Override
	public void start(Stage primaryStage){
		
		TableColumn<Product, String> c1 = new TableColumn<>("Product Name");
        c1.setMinWidth(200);
        c1.setCellValueFactory(new PropertyValueFactory<>("ProductName"));
		
		TableColumn<Product, String> c2 = new TableColumn<>("Product ID");
        c2.setMinWidth(50);
        c2.setCellValueFactory(new PropertyValueFactory<>("ProductID"));
		
		TableColumn<Product, String> c3 = new TableColumn<>("Price");
        c3.setMinWidth(50);
        c3.setCellValueFactory(new PropertyValueFactory<>("Price"));
		
		TableColumn<Product, String> c4 = new TableColumn<>("Stock");
        c4.setMinWidth(50);
        c4.setCellValueFactory(new PropertyValueFactory<>("Stock"));
		
		TableColumn<Product, String> c5 = new TableColumn<>("Catagory ID");
        c5.setMinWidth(50);
        c5.setCellValueFactory(new PropertyValueFactory<>("CatagoryID"));
		
		table = new TableView<>();
        
        table.getColumns().addAll(c1,c2,c3,c4,c5);
		
		Button b1 = new Button();
		Button b2 = new Button();
		Button b3 = new Button();
		//Button b4 = new Button();
		
		TextField t1 = new TextField();
		TextField t2 = new TextField();
		
		t1.setPadding(new Insets(2));
		t1.setPrefWidth(120);
		t1.setPromptText("Item ID");
		t2.setPadding(new Insets(2));
		t2.setPrefWidth(120);
		t2.setPromptText("Quantity to add or substract");
		
		
		Text t = new Text("Update");
		t.setFont(Font.font("Arial Black",12.00));
		
		b1.setText("Add");
		b2.setText("Delete");
		b3.setText("Cancel");
		//b4.setText("Refresh table");
		
		b1.setFont(Font.font("Arial Narrow",10.00));
		b2.setFont(Font.font("Arial Narrow",10.00));
		b3.setFont(Font.font("Arial Narrow",10.00));
		//b4.setFont(Font.font("Arial Narrow",10.00));
		
		table.setItems(getProduct());
		
		b1.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent ae){
					AdminDB da = new AdminDB();
					ResultSet rs = null;
					String sql1 ="SELECT * FROM product WHERE productID ='"+t1.getText()+"'";//"SELECT * FROM admin WHERE userID='"+t1.getText()+"'
					
					rs = da.getData(sql1);
					System.out.println("In side1.");
					try{
					if(rs.next()){
						System.out.println("In side2.");
					int i = Integer.parseInt(t2.getText());
					int j = Integer.parseInt(rs.getString("stock"));
					int k = i + j;
					
					String sql2 = "UPDATE product SET stock=('"+k+"')WHERE productID ='"+t1.getText()+"'";
					
					da.updateDB(sql2);
					t1.setText("");
					t2.setText("");
					table.setItems(getProduct());
					System.out.println("Updated");
				}
				else{
					alert.setTitle("ERROR");
					alert.setHeaderText("ERROR");
					alert.setContentText("Please Enter ID & Password Properly");
					alert.showAndWait();
				}
				}catch(Exception ex){
					alert.setTitle("ERROR");
					alert.setHeaderText("ERROR");
					alert.setContentText("DATABASE ERROR");
					alert.showAndWait();
				}
					
					
				}
		});
		
		b2.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent ae){
					AdminDB da = new AdminDB();
					ResultSet rs = null;
					String sql1 ="SELECT * FROM product WHERE productID ='"+t1.getText()+"'";
					
					rs = da.getData(sql1);
					System.out.println("In side1.");
					try{
					if(rs.next()){
						System.out.println("In side2.");
						int i = Integer.parseInt(t2.getText());
						int j = Integer.parseInt(rs.getString("stock"));
						int k = j - i ;
						if(i > j || j == i){
							alert.setTitle("ERROR");
							alert.setHeaderText("ERROR");
							alert.setContentText("You do not have enough Stock");
							alert.showAndWait();
						}
						else{
							String sql2 = "UPDATE product SET stock=('"+k+"')WHERE productID ='"+t1.getText()+"'";
							da.updateDB(sql2);
							t1.setText("");
							t2.setText("");
							table.setItems(getProduct());
						}
					
					
					System.out.println("Updated");
				}
				else{
					alert.setTitle("ERROR");
					alert.setHeaderText("ERROR");
					alert.setContentText("Please Enter ID & Password Properly");
					alert.showAndWait();
				}
				}catch(Exception ex){
					alert.setTitle("ERROR");
					alert.setHeaderText("ERROR");
					alert.setContentText("DATABASE ERROR");
					alert.showAndWait();
				}
					
					
				}
		});
		b3.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent ae){
				InventorySettings adi = new InventorySettings();
				adi.start(InventorySettings.classStage);
				primaryStage.hide();
			}
		});
		
		
		BorderPane root = new BorderPane();
		VBox v1 = new VBox();
		VBox vbox = new VBox();
		HBox r1 = new HBox();
		HBox r2 = new HBox();
		HBox r3 = new HBox();
		HBox r4 = new HBox();
		HBox r5 = new HBox();
		r5.setSpacing(35.00);
		r4.setSpacing(35.00);
		
		r1.setPadding(new Insets(50,100,50,100));
		r1.setAlignment(Pos.CENTER);
		r2.setPadding(new Insets(30,10,10,10));
		r2.setAlignment(Pos.CENTER);
		r3.setPadding(new Insets(30,10,10,10));
		r3.setAlignment(Pos.CENTER);
		r4.setPadding(new Insets(30,10,10,10));
		r4.setAlignment(Pos.CENTER);
		r5.setPadding(new Insets(30,10,10,10));
		r5.setAlignment(Pos.CENTER);
		
		r1.getChildren().addAll(t);
		r2.getChildren().addAll(t1);
		r3.getChildren().addAll(t2);
		r4.getChildren().addAll(b1,b2);
		r5.getChildren().addAll(b3);
		
		v1.getChildren().addAll(r1,r2,r3,r4,r5);
		vbox.getChildren().addAll(table);
		root.setLeft(v1);
		root.setRight(vbox);
		
		Scene scene = new Scene(root,740,550);
		
		primaryStage.setTitle("     ");
		primaryStage.setScene(scene);
		primaryStage.show();
		updateStock.classStage = primaryStage;
		}
		public ObservableList<Product> getProduct(){
		ProductDB pdb = new ProductDB();
		String sql = "select * from product";
		ResultSet rs = null;
        ObservableList<Product> products = FXCollections.observableArrayList();
		products = pdb.getData(sql);
        return products;
		}
}