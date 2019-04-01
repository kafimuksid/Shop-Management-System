package main;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.scene.control.Alert.AlertType;
import javafx.geometry.*;
import javafx.event.*;

public class AdminInfo extends Application{
	static Stage classStage = new Stage();
	@Override
	public void start(Stage primaryStage){
		
		GetAdminInfo gaif = new GetAdminInfo();
		
		Button b = new Button();
		b.setText("Back");
		b.setFont(Font.font("Arial",15.00));
		
		b.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent ae){
				Adminp ap = new Adminp();
				ap.start(Adminp.classStage);
				primaryStage.hide();
			}
		});
		
		Text t = new Text();
		t.setText("Admin INFORMATIONS");
		t.setFont(Font.font("Arial Black",25.00));
		
		Text t1 = new Text();
		t1.setText(gaif.getID());
		t1.setFont(Font.font("Arial Narrow",15.00));
		Text t2 = new Text();
		t2.setText(gaif.getPass());
		t2.setFont(Font.font("Arial Narrow",15.00));
		Text t3 = new Text();
		t3.setText(gaif.getFname());
		t3.setFont(Font.font("Arial Narrow",15.00));
		Text t4 = new Text();
		t4.setText(gaif.getLname());
		t4.setFont(Font.font("Arial Narrow",15.00));
		Text t5 = new Text();
		t5.setText(gaif.getCont());
		t5.setFont(Font.font("Arial Narrow",15.00));
		Text t6 = new Text();
		t6.setText(gaif.getAdd());
		t6.setFont(Font.font("Arial Narrow",15.00));
		Text t7 = new Text();
		t7.setText(gaif.getMobNo());
		t7.setFont(Font.font("Arial Narrow",15.00));
		
		Label l1 = new Label();
		Label l2 = new Label();
		Label l3 = new Label();
		Label l4 = new Label();
		Label l5 = new Label();
		Label l6 = new Label();
		Label l7 = new Label();
		
		l1.setText("Admin ID             :");
		l2.setText("Admin Password       :");
		l3.setText("Admin First Name     :");
		l4.setText("Admin Last Name      :");
		l5.setText("Admin Contact        :");
		l6.setText("Admin Address        :");
		l7.setText("Admin Mobile Number  :");
		
		l1.setFont(Font.font("Arial",15.00));
		l2.setFont(Font.font("Arial",15.00));
		l3.setFont(Font.font("Arial",15.00));
		l4.setFont(Font.font("Arial",15.00));
		l5.setFont(Font.font("Arial",15.00));
		l6.setFont(Font.font("Arial",15.00));
		l7.setFont(Font.font("Arial",15.00));
		
		VBox v = new VBox();
		HBox h1 = new HBox();
		HBox h2 = new HBox();
		HBox h3 = new HBox();
		HBox h4 = new HBox();
		HBox h5 = new HBox();
		HBox h6 = new HBox();
		HBox h7 = new HBox();
		HBox h8 = new HBox();
		HBox h9 = new HBox();
		
		h1.setPadding(new Insets(50,10,10,10));
		h1.setAlignment(Pos.CENTER);
		h2.setPadding(new Insets(20,10,10,10));
		//h2.setAlignment(Pos.CENTER);
		h2.setSpacing(10.00);
		h3.setPadding(new Insets(20,10,10,10));
		//h3.setAlignment(Pos.CENTER);
		h3.setSpacing(10.00);
		h4.setPadding(new Insets(20,10,10,10));
		//h4.setAlignment(Pos.CENTER);
		h5.setPadding(new Insets(20,10,10,10));
		//h5.setAlignment(Pos.CENTER);
		h6.setPadding(new Insets(20,10,10,10));
		//h6.setAlignment(Pos.CENTER);
		h7.setPadding(new Insets(20,10,10,10));
		//h7.setAlignment(Pos.CENTER);
		h8.setPadding(new Insets(20,10,10,10));
		//h8.setAlignment(Pos.CENTER);
		h9.setPadding(new Insets(15,10,10,10));
		h9.setAlignment(Pos.CENTER);
		
		h1.getChildren().addAll(t);
		h2.getChildren().addAll(l1,t1);
		h3.getChildren().addAll(l2,t2);
		h4.getChildren().addAll(l3,t3);
		h5.getChildren().addAll(l4,t4);
		h6.getChildren().addAll(l5,t5);
		h7.getChildren().addAll(l6,t6);
		h8.getChildren().addAll(l7,t7);
		h9.getChildren().addAll(b);
		
		v.getChildren().addAll(h1,h2,h3,h4,h5,h6,h7,h8,h9);
		
		Scene scene = new Scene(v,500,550);
		primaryStage.setTitle("Admin Informations");
		primaryStage.setScene(scene);
		primaryStage.show();
		AdminInfo.classStage = primaryStage;
		
	}
}
