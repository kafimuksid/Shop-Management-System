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

public class AddAdmin extends Application{
	static Stage classStage = new Stage();
	Alert alert = new Alert(AlertType.WARNING);
	///TableView<GetAdmin> table;
	@Override
	public void start(Stage primaryStage){
		
		Button b1 = new Button();
		Button b2 = new Button();
		
		TextField t1 = new TextField();
		TextField t2 = new TextField();
		TextField t3 = new TextField();
		TextField t4 = new TextField();
		TextField t5 = new TextField();
		TextField t6 = new TextField();
		TextField t7 = new TextField();
		
		t1.setPadding(new Insets(2));
		t1.setPrefWidth(120);
		t1.setPromptText("Admin ID");
		t2.setPadding(new Insets(2));
		t2.setPrefWidth(120);
		t2.setPromptText("Password");
		t3.setPadding(new Insets(2));
		t3.setPrefWidth(120);
		t3.setPromptText("First Name");
		t4.setPadding(new Insets(2));
		t4.setPrefWidth(120);
		t4.setPromptText("Last Name");
		t5.setPadding(new Insets(2));
		t5.setPrefWidth(120);
		t5.setPromptText("Email");
		t6.setPadding(new Insets(2));
		t6.setPrefWidth(120);
		t6.setPromptText("Adress");
		t7.setPadding(new Insets(2));
		t7.setPrefWidth(120);
		t7.setPromptText("Mobile Number");
		
		Text t = new Text("Add New Admin");
		t.setFont(Font.font("Arial Black",20.00));
		
		b1.setText("Add");
		b2.setText("Cancel");
		
		b1.setFont(Font.font("Arial Narrow",10.00));
		b2.setFont(Font.font("Arial Narrow",10.00));
		
		b1.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent ae){
				if(t1.getText().equals("")||t2.getText().equals("") || t3.getText().equals("") || t4.getText().equals("") || t5.getText().equals("")|| t6.getText().equals("")|| t7.getText().equals("")){
					alert.setTitle("ERROR");
					alert.setHeaderText("ERROR");
					alert.setContentText("Please fillup everything properly.");
					alert.showAndWait();
				}
				else{
					DBADDP da = new DBADDP();
					String sql = "INSERT INTO admin(userID,password,firstName,lastName,contInfo,address,mobileNo) VALUES ('"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"','"+t4.getText()+"','"+t5.getText()+"','"+t6.getText()+"','"+t7.getText()+"')";
					da.updateDB(sql);
					t1.setText("Regestered");
					t2.setText("Regestered");
					t3.setText("Regestered");
					t4.setText("Regestered");
					t5.setText("Regestered");
					t6.setText("Regestered");
					t7.setText("Regestered");
					System.out.println("Updated");
				}
			}
		});
		
		b2.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent ae){
				Adminp adi = new Adminp();
				adi.start(Adminp.classStage);
				primaryStage.hide();
			}
		});
		
		BorderPane root = new BorderPane();
		VBox v1 = new VBox();
		HBox r1 = new HBox();
		HBox r2 = new HBox();
		HBox r3 = new HBox();
		HBox r4 = new HBox();
		HBox r5 = new HBox();
		HBox r6 = new HBox();
		HBox r7 = new HBox();
		HBox r8 = new HBox();
		HBox r9 = new HBox();
		r9.setSpacing(35.00);
		
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
		r8.setPadding(new Insets(30,10,10,10));
		r8.setAlignment(Pos.CENTER);
		r9.setPadding(new Insets(30,10,10,10));
		r9.setAlignment(Pos.CENTER);
		
		r1.getChildren().addAll(t);
        r2.getChildren().addAll(t1);
		r3.getChildren().addAll(t2);
		r4.getChildren().addAll(t3);
		r5.getChildren().addAll(t4);
		r6.getChildren().addAll(t5);
		r7.getChildren().addAll(t6);
		r8.getChildren().addAll(t7);
		r9.getChildren().addAll(b1,b2);
		
		v1.getChildren().addAll(r1,r2,r3,r4,r5,r6,r7,r8,r9);
		
		Scene scene = new Scene(v1,400,630);
		
		primaryStage.setTitle("  ");
		primaryStage.setScene(scene);
		primaryStage.show();
		AddAdmin.classStage = primaryStage;
		}
}