package main;
import javafx.application.Application;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class InventorySettings extends Application{
	static Stage classStage = new Stage();
	@Override
	public void start(Stage primaryStage){
		Button b1 = new Button();
		Button b2 = new Button();
		Button b3 = new Button();
		Button b4 = new Button();
		Button b5 = new Button();
		
		Text t = new Text("<!!Inventory Settings!!>");
		t.setFont(Font.font("Arial Black",36.00));
		
		b1.setText("Add Item to Inventory");
		b2.setText("Delete Item from Inventory");
		b3.setText("Update Item Stock");
		b4.setText("Back");
		b5.setText("Add New Catagory");
		
		b1.setFont(Font.font("Arial Narrow",20.00));
		b2.setFont(Font.font("Arial Narrow",20.00));
		b3.setFont(Font.font("Arial Narrow",20.00));
		b4.setFont(Font.font("Arial Narrow",20.00));
		b5.setFont(Font.font("Arial Narrow",20.00));
		
		b1.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent ae){
				AddInventory ap = new AddInventory();
				ap.start(AddInventory.classStage);
				primaryStage.hide();
			}
		});
		b2.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent ae){
				DeletePro ap = new DeletePro();
				ap.start(DeletePro.classStage);
				primaryStage.hide();
			}
		});
		
		b3.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent ae){
				updateStock ap = new updateStock();
				ap.start(updateStock.classStage);
				primaryStage.hide();
			}
		});
		
		b4.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent ae){
				Adminp adm = new Adminp();
				adm.start(Adminp.classStage);
				primaryStage.hide();
			}
		});
		b5.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent ae){
				AddCategory adm = new AddCategory();
				adm.start(AddCategory.classStage);
				primaryStage.hide();
			}
		});


		VBox v1 = new VBox();
		HBox r1 = new HBox();
		HBox r2 = new HBox();
		HBox r3 = new HBox();
		HBox r4 = new HBox();
		HBox r5 = new HBox();
		HBox r6 = new HBox();
		//r4.setSpacing(35.00);
		r1.setPadding(new Insets(100,10,10,10));
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
		
		r1.getChildren().addAll(t);
		r2.getChildren().addAll(b1);
		r3.getChildren().addAll(b2);
		r4.getChildren().addAll(b3);
		r5.getChildren().addAll(b4);
		r6.getChildren().addAll(b5);
		
		v1.getChildren().addAll(r1,r2,r6,r3,r4,r5);
		
		Scene scene = new Scene(v1,650,650);
		
		primaryStage.setTitle("Inventory Settings");
		primaryStage.setScene(scene);
		primaryStage.show();
		InventorySettings.classStage = primaryStage;
		}
}