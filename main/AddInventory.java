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

public class AddInventory extends Application{
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
        //table.setItems(getProduct());
        table.getColumns().addAll(c1,c2,c3,c4,c5);
		
		
		
		Button b1 = new Button();
		Button b2 = new Button();
		///Button b3 = new Button();
		
		
		/*Label l1 = new Label("Product Name : ");
		Label l2 = new Label("Product ID : ");
		Label l3 = new Label("Catagory : ");
		Label l4 = new Label("Price : ");
		Label l5 = new Label("Quantity : ");*/
		
		TextField t1 = new TextField();
		TextField t2 = new TextField();
		TextField t3 = new TextField();
		TextField t4 = new TextField();
		TextField t5 = new TextField();
		
		t1.setPadding(new Insets(2));
		t1.setPrefWidth(120);
		t1.setPromptText("Item Name");
		t2.setPadding(new Insets(2));
		t2.setPrefWidth(120);
		t2.setPromptText("Item ID");
		t3.setPadding(new Insets(2));
		t3.setPrefWidth(120);
		t3.setPromptText("Catagory ID");
		t4.setPadding(new Insets(2));
		t4.setPrefWidth(120);
		t4.setPromptText("Price");
		t5.setPadding(new Insets(2));
		t5.setPrefWidth(120);
		t5.setPromptText("Quantity");
		
		Text t = new Text("Add Poduct");
		t.setFont(Font.font("Arial Black",12.00));
		
		b1.setText("Add");
		b2.setText("Cancel");
		//b3.setText("Refresh table");
		
		b1.setFont(Font.font("Arial Narrow",10.00));
		b2.setFont(Font.font("Arial Narrow",10.00));
		//b3.setFont(Font.font("Arial Narrow",10.00));
		
		table.setItems(getProduct());
		
		b1.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent ae){
				if(t1.getText().equals("") || t2.getText().equals("") || t3.getText().equals("") || t4.getText().equals("") || t5.getText().equals("")){
					alert.setTitle("ERROR");
					alert.setHeaderText("ERROR");
					alert.setContentText("Please fillup everything properly.");
					alert.showAndWait();
				}
				else{
					DBADDP da = new DBADDP();
					String sql = "INSERT INTO product(productName,productID,price,stock,categoryID) VALUES ('"+t1.getText()+"','"+t2.getText()+"','"+t4.getText()+"','"+t5.getText()+"','"+t3.getText()+"')";
					
					da.updateDB(sql);
					t1.setText("");
					t2.setText("");
					t3.setText("");
					t4.setText("");
					t5.setText("");
					System.out.println("Updated");
					table.setItems(getProduct());
				}
			}
		});
		
		b2.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent ae){
				InventorySettings adi = new InventorySettings();
				adi.start(InventorySettings.classStage);
				primaryStage.hide();
			}
		});
		/*b3.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent ae){
				
			}
		});*/
		
		BorderPane root = new BorderPane();
		VBox v1 = new VBox();
		VBox vbox = new VBox();
		HBox r1 = new HBox();
		HBox r2 = new HBox();
		HBox r3 = new HBox();
		HBox r4 = new HBox();
		HBox r5 = new HBox();
		HBox r6 = new HBox();
		HBox r7 = new HBox();
		//HBox r8 = new HBox();
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
		r6.setPadding(new Insets(30,10,10,10));
		r6.setAlignment(Pos.CENTER);
		r7.setPadding(new Insets(30,10,10,10));
		r7.setAlignment(Pos.CENTER);
		//r8.setPadding(new Insets(30,10,10,10));
		//r8.setAlignment(Pos.CENTER);
		
		r1.getChildren().addAll(t);
		r2.getChildren().addAll(t1);
		r3.getChildren().addAll(t2);
		r4.getChildren().addAll(t3);
		r5.getChildren().addAll(t4);
		r6.getChildren().addAll(t5);
		r7.getChildren().addAll(b1,b2);
		//r8.getChildren().addAll(b3);
		
		v1.getChildren().addAll(r1,r2,r3,r4,r5,r6,r7);
		vbox.getChildren().addAll(table);
		root.setLeft(v1);
		root.setRight(vbox);
		
		Scene scene = new Scene(root,740,550);
		
		primaryStage.setTitle("     ");
		primaryStage.setScene(scene);
		primaryStage.show();
		AddInventory.classStage = primaryStage;
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