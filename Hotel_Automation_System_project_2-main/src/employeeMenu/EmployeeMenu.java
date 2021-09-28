package employeeMenu;

import java.io.File;
import java.util.Scanner;

import addOperation.AddCustomer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import operations.CustomerOperations;

public class EmployeeMenu extends Application{
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("EMPLOYEE SCREEN");
		String username;
		File Username =new File("username.txt"); 
		Scanner reader=new Scanner(Username);
		username=reader.nextLine();
		reader.close();
		StackPane root=new StackPane();
		StackPane root2=new StackPane(); root2.setId("root2");
		BorderPane border=new BorderPane();
		VBox vmenu=new VBox();
		HBox topmenu=new HBox();				topmenu.setId("stat_top_menu");	
		Button btnCadd=new Button(""); 		btnCadd.setId("menubutons");
		Button btnOperations=new Button(""); 	btnOperations.setId("menubutons");
		Button btnExit=new Button(""); 		btnExit.setId("menubutons");
		Button btninfoepmloyer=new Button(""); btninfoepmloyer.setId("info_btn");
		 
		Label i2name=new Label(username);	i2name.setId("top_menu_label");
		Button btninfouser=new Button(); btninfouser.setId("top_user_icon");
		HBox hboxtop=new HBox(); hboxtop.setId("hboxtop-style");
		//BUTTONS' ACTÝONS
		//START
		//CUSTOMER ADD bUTTON
	btnCadd.setOnAction(e->{
		AddCustomer add=new AddCustomer();
		try {
			add.start(stage);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
	});
	//OPERASYON CLASS'INA GÝTME BUTONU
	CustomerOperations ced=new 	CustomerOperations();
	btnOperations.setOnAction(e->{
			try {
				ced.start(stage);
	        } catch (Exception e1) {
	            e1.printStackTrace();
	        }
		});
	//EXIT bUTTON
	btnExit.setOnAction(e->{ 	stage.close();	 });
	
	
	//INFO BUTTON
	btninfoepmloyer.setOnAction(e->{
		EmployeeInfo infoscreen=new EmployeeInfo();
		infoscreen.start();
	});
	//START->OVER
	
	 vmenu.getChildren().addAll(btnCadd,btnOperations,btnExit,btninfoepmloyer);
		
		root.getChildren().addAll(border);
		border.setLeft(vmenu);
		border.setCenter(root2);
		root2.getChildren().addAll(topmenu);
		topmenu.getChildren().addAll(hboxtop);
		hboxtop.getChildren().addAll(btninfouser,i2name);
	
	Scene yenicalisanmenu=new Scene(root,1200,800);
	root.setId("root_calisan_style");
	vmenu.setId("vmenu");
	vmenu.setPrefSize(232, 800);

	yenicalisanmenu.getStylesheets().add(getClass().getResource("/application/style.css").toExternalForm());
	stage.setScene(yenicalisanmenu);
	stage.show();
	}
}