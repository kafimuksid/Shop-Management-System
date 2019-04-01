package main;
import javafx.application.Application;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.geometry.*;

public class Adminp extends Application{
	static Stage classStage = new Stage();
	@Override
	public void start(Stage primaryStage){
		Button btn1 = new Button();
		Button btn2 = new Button();
		Button btn3 = new Button();
		Button btn4 = new Button();
		Button btn5 = new Button();
		
		Text Txt = new Text("<!!Admin Panel!!>");
		Txt.setFont(Font.font("Arial Black",36.00));
		
		btn1.setText("Admin Information");
		btn2.setText("Regester New Admin");
		btn4.setText("Inventory Settings");
		btn5.setText("Sign Out");
		btn1.setFont(Font.font("Arial Narrow",20.00));
		btn2.setFont(Font.font("Arial Narrow",20.00));
		btn4.setFont(Font.font("Arial Narrow",20.00));
		btn5.setFont(Font.font("Arial Narrow",20.00));
		
		
		btn1.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent ae){
				AdminInfo aif = new AdminInfo();
				aif.start(AdminInfo.classStage);
				primaryStage.hide();
			}
		});
		btn2.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent ae){
				AddAdmin aif = new AddAdmin();
				aif.start(AddAdmin.classStage);
				primaryStage.hide();
			}
		});
		btn4.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent ae){
				InventorySettings ai = new InventorySettings();
				ai.start(InventorySettings.classStage);
				primaryStage.hide();
			}
		});
		
		btn5.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent ae){
				StartPage we = new StartPage();
				we.start(StartPage.classStage);
				primaryStage.hide();
			}
		});
		
		HBox hb1 = new HBox();
		HBox hb2 = new HBox();
		HBox hb3 = new HBox();
		HBox hb4 = new HBox();
		HBox hb5 = new HBox();
		HBox hb6 = new HBox();
		VBox vb1 = new VBox();
		
		hb1.setPadding(new Insets(60,60,60,60));
		hb2.setPadding(new Insets(25,10,10,10));
		hb3.setPadding(new Insets(25,10,10,10));
		hb4.setPadding(new Insets(25,10,10,10));
		hb5.setPadding(new Insets(25,10,10,10));
		hb6.setPadding(new Insets(25,10,10,10));
		
		hb1.setAlignment(Pos.CENTER);
		hb2.setAlignment(Pos.CENTER);
		hb3.setAlignment(Pos.CENTER);
		//hb4.setAlignment(Pos.CENTER);
		hb5.setAlignment(Pos.CENTER);
		hb6.setAlignment(Pos.CENTER);
		
		hb1.getChildren().addAll(Txt);
		hb2.getChildren().addAll(btn1);
		hb3.getChildren().addAll(btn2);
		//hb4.getChildren().addAll(btn3);
		hb5.getChildren().addAll(btn4);
		hb6.getChildren().addAll(btn5);
		
		vb1.getChildren().addAll(hb1,hb2,hb3,hb5,hb6);
		
		Scene scene = new Scene(vb1,550,570);
		primaryStage.setTitle("ADMIN");
		primaryStage.setScene(scene);
		primaryStage.show();
		Adminp.classStage = primaryStage;
		
	}
}