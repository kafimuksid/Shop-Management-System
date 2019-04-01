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

public class BuySell extends Application{
	static Stage classStage = new Stage();
	Alert alert = new Alert(AlertType.WARNING);
	TableView<Product> table;
	TableView<GetBS> table1;
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
		
		TableColumn<GetBS, String> c11 = new TableColumn<>("Product Name");
        c11.setMinWidth(200);
        c11.setCellValueFactory(new PropertyValueFactory<>("Pname"));
		
		TableColumn<GetBS, String> c22 = new TableColumn<>("Quantity");
        c22.setMinWidth(50);
        c22.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
		
		TableColumn<GetBS, String> c33 = new TableColumn<>("Price");
        c33.setMinWidth(50);
        c33.setCellValueFactory(new PropertyValueFactory<>("Price"));
		
		table = new TableView<>();
		table1 = new TableView<>();
		
        table.getColumns().addAll(c1,c2,c3,c4,c5);
		table1.getColumns().addAll(c11,c22,c33);
		
		Button b1 = new Button();
		Button b2 = new Button();
		Button b3 = new Button();
		
		TextField t1 = new TextField();
		TextField t2 = new TextField();
		
		t1.setPadding(new Insets(2));
		t1.setPrefWidth(120);
		t1.setPromptText("Item ID");
		t2.setPadding(new Insets(2));
		t2.setPrefWidth(120);
		t2.setPromptText("Item Quantity");
		
		Text t = new Text("Buy From Shop");
		t.setFont(Font.font("Arial Black",18.00));
		Text txt1 = new Text("Product List");
		txt1.setFont(Font.font("Arial Black",12.00));
		Text txt2 = new Text("Purchace List");
		txt2.setFont(Font.font("Arial Black",12.00));
		
		b1.setText("Buy");
		b2.setText("Total");
		b3.setText("Exit");
		
		b1.setFont(Font.font("Arial Narrow",10.00));
		b2.setFont(Font.font("Arial Narrow",10.00));
		b3.setFont(Font.font("Arial Narrow",10.00));
		
		table.setItems(getProduct());
		table1.setItems(getProduct1());
		
		b1.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent ae){
				if(t1.getText().equals("") || t2.getText().equals("")){
					alert.setTitle("ERROR");
					alert.setHeaderText("ERROR");
					alert.setContentText("Please fillup everything properly.");
					alert.showAndWait();
				}
				else{
					ResultSet rs = null;
					AdminDB da = new AdminDB();
					String sql = "SELECT * FROM product WHERE productID='"+t1.getText()+"'";
					rs = da.getData(sql);
					
					try{
					if(rs.next()){
						//System.out.println("In side2.");
						int i = Integer.parseInt(t2.getText());
						int j = Integer.parseInt(rs.getString("stock"));
						int k = j - i ;
						if(i > j || j == i){
							alert.setTitle("ERROR");
							alert.setHeaderText("ERROR");
							alert.setContentText("There is Not Enough Stock For this Product. Please try again later");
							t1.setText("");
							t2.setText("");
							alert.showAndWait();
						}
						else{
							String sql2 = "UPDATE product SET stock=('"+k+"')WHERE productID ='"+t1.getText()+"'";
							da.updateDB(sql2);
							GetBS bs = new GetBS(rs.getString("productName"),t2.getText(),rs.getString("price"));
							float f = Float.parseFloat(bs.getQuantity()) * Float.parseFloat(bs.getPrice());
							TotalCal tc = new TotalCal(f);
							String query = "INSERT INTO buy (productName,Quantity,Price) VALUES ('"+bs.getPname()+"','"+bs.getQuantity()+"','"+f+"')";
							
							da.updateDB(query);
							
							t1.setText("");
							t2.setText("");
							table.setItems(getProduct());
							table1.setItems(getProduct1());
							System.out.println("Updated");
							
						}
					}
					else{
						alert.setTitle("ERROR");
						alert.setHeaderText("ERROR");
						alert.setContentText("Please Enter Properly");
						alert.showAndWait();
					}
					}catch(Exception ex){
						alert.setTitle("ERROR");
						alert.setHeaderText("ERROR");
						alert.setContentText("DATABASE ERROR");
						alert.showAndWait();
					}
					System.out.println("Updated");
				}
			}
		});
		
		b2.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent ae){
				AdminDB da = new AdminDB();
				ResultSet rs = null;
				//String tp = "TotalPrice";
				//String sql = "SELECT SUM(price) AS "+tp+" FROM buy";
				TotalCal tc = new TotalCal(); 
				//rs = da.getData(sql);
				//float p = Float.parseFloat(rs.);
				GetBS2 bs = new GetBS2("Total Price","0",tc.getTotal());
				String query = "INSERT INTO buy (productName,Quantity,Price) VALUES ('"+bs.getPname()+"','"+bs.getQuantity()+"','"+bs.getPrice()+"')";
				da.updateDB(query);
				GetBS2 bs2 = new GetBS2("Total Price + .5% vat","0",tc.getTotal());
				double z = (bs.getPrice()*.05)+bs.getPrice();
				String query1 = "INSERT INTO buy (productName,Quantity,Price) VALUES ('"+bs2.getPname()+"','"+bs2.getQuantity()+"','"+z+"')";
				da.updateDB(query1);
				t1.setText("");
				t2.setText("");
				table.setItems(getProduct());
				table1.setItems(getProduct1());
				String sql2 = "TRUNCATE TABLE buy";
				System.out.println("Ok");
				da.updateDB(sql2);
				System.out.println("Updated");
				b1.setDisable(true);
				b2.setDisable(true);
				
		}});
		b3.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent ae){
				primaryStage.hide();
			}
		});
		
		BorderPane root = new BorderPane();
		VBox v1 = new VBox();
		VBox vbox = new VBox();
		VBox vbox1 = new VBox();
		HBox r1 = new HBox();
		HBox r2 = new HBox();
		HBox r3 = new HBox();
		HBox r4 = new HBox();
		HBox r5 = new HBox();
		HBox r6 = new HBox();
		HBox r7 = new HBox();
		HBox r8 = new HBox();
		r7.setSpacing(35.00);
		
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
		r4.setSpacing(35.00);
		
		v1.getChildren().addAll(r1,r2,r3,r4,r5);
		vbox.getChildren().addAll(txt1,table);
		vbox1.getChildren().addAll(txt2,table1);
		root.setLeft(v1);
		root.setCenter(vbox);
		root.setRight(vbox1);
		
		Scene scene = new Scene(root,1250,500);
		
		primaryStage.setTitle("     ");
		primaryStage.setScene(scene);
		primaryStage.show();
		BuySell.classStage = primaryStage;
		}
		public ObservableList<Product> getProduct(){
		ProductDB pdb = new ProductDB();
		String sql = "select * from product";
		ResultSet rs = null;
        ObservableList<Product> products = FXCollections.observableArrayList();
		products = pdb.getData(sql);
        return products;
		}
		public ObservableList<GetBS> getProduct1(){
		purchaceDB pdb = new purchaceDB();
		String sql = "select * from buy";
		ResultSet rs = null;
        ObservableList<GetBS> getbs = FXCollections.observableArrayList();
		getbs = pdb.getData(sql);
        return getbs;
		}
}