package main;
import javafx.application.Application;
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

public class StartPage extends Application{
	static Stage classStage = new Stage();
	Alert alert = new Alert(AlertType.WARNING);
	@Override
	public void start(Stage primaryStage){
		Label l1 = new Label("Login as Admin : ");
		l1.setFont(Font.font("Arial Black",10.00));
		TextField t1 = new TextField();
		PasswordField t2 = new PasswordField();
		t1.setPrefWidth(120);
		t1.setPadding(new Insets(2));
		t1.setPromptText("ID");
		t2.setPrefWidth(120);
		t2.setPadding(new Insets(2));
		t2.setPromptText("Password");
		Button b1 = new Button();
		Button b2 = new Button();
		Button b3 = new Button();
		Button b4 = new Button();
		Text t = new Text("    Shopping Cart \n Customer Options");
		t.setFont(Font.font("Arial Black",25));
		
		b1.setText(".. Buy From Inventory ..");
		//b2.setText("... Request Star ID ...");
		b3.setText("... Exit ...");
		b4.setText("Login");
		b1.setFont(Font.font("Arial",15.00));
		//b2.setFont(Font.font("Arial",15.00));
		b3.setFont(Font.font("Arial",15.00));
		b4.setFont(Font.font("Arial Narrow",10.00));
		
		b1.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent ae){
				BuySell r = new BuySell();
				r.start(BuySell.classStage);
				primaryStage.hide();
			}
		});
		b3.setOnAction(new EventHandler<ActionEvent>(){
		@Override
		public void handle(ActionEvent ae){
			//CustomerPage b = new CustomerPage();
			//b.start(CustomerPage.classStage);
			primaryStage.hide();
		}
		});
		b4.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent ae){
				if(t1.getText().equals("") || t2.getText().equals("")){
				alert.setTitle("Something Is Wrong");
				alert.setHeaderText("Not filled Properly");
				alert.setContentText("Please Everythings Properly");
				alert.showAndWait();
			}
			else{
				ResultSet rs = null;
				AdminDB da = new AdminDB();
				String sql = "SELECT * FROM admin WHERE userID='"+t1.getText()+"' AND password='"+t2.getText()+"'";
				rs = da.getData(sql);
				try{
					if(rs.next()){
					Adminp p= new Adminp();
					p.start(Adminp.classStage);
					primaryStage.hide();
					GetAdminInfo gai = new GetAdminInfo(rs.getString("userID"),rs.getString("password"),rs.getString("firstName"),rs.getString("lastName"),rs.getString("contInfo"),rs.getString("address"),rs.getString("mobileNo"));
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
			}
		});
		VBox v1 = new VBox();
		
		HBox root = new HBox();
		HBox root1 = new HBox();
		HBox root2 = new HBox();
		HBox root3 = new HBox();
		HBox root4 = new HBox();
		
		root.setSpacing(5);
		
		
		root1.setSpacing(35.00);
		root1.setPadding(new Insets(30,10,10,10));
		root1.setAlignment(Pos.CENTER);
		
		root2.setAlignment(Pos.CENTER);
		root2.setPadding(new Insets(20,100,10,100));
		root3.setAlignment(Pos.CENTER);
		root3.setPadding(new Insets(20,100,10,100));
		root4.setAlignment(Pos.CENTER);
		root4.setPadding(new Insets(20,100,10,100));
		
		root.getChildren().addAll(l1,t1,t2,b4);
		root1.getChildren().addAll(t);
		root2.getChildren().addAll(b1,b3);
		//root3.getChildren().addAll(b2);
		root4.getChildren().addAll(b3);
		
		v1.getChildren().addAll(root,root1,root2,root4);
		
		Scene scene = new Scene(v1,500,275);
		
		primaryStage.setTitle("Shopping Cart");
		primaryStage.setScene(scene);
		primaryStage.show();
		StartPage.classStage = primaryStage;
		}
}