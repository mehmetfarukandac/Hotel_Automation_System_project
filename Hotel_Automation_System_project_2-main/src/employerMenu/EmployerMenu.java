package employerMenu;

import java.io.File;
import java.util.Scanner;

import addOperation.AddEmployee;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import operations.EmployeeOperations;

public class EmployerMenu extends Application{
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("EMPLOYER SCREEN");
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
		Button btnEadd=new Button(""); 		btnEadd.setId("menubutons");
		Button btnOperations=new Button(""); 	btnOperations.setId("menubutons");
		Button btnStatistics=new Button(""); 	btnStatistics.setId("menubutons");
		Button btnExit=new Button(""); 		btnExit.setId("menubutons");
		Button btninfoepmloyee=new Button(""); btninfoepmloyee.setId("info_btn");
		 
		Label i2name=new Label(username);	i2name.setId("top_menu_label");
		Button btninfouser=new Button(); btninfouser.setId("top_user_icon");
		HBox hboxtop=new HBox(); hboxtop.setId("hboxtop-style");
		
		//BUTTONS' ACTÝONS
		//START
		 //STATÝSTÝC'S BUTTON
		 btnStatistics.setOnAction(e->{
				statistics stats=new statistics();
				try {
					stats.start(stage);
		        } catch (Exception e1) {
		            e1.printStackTrace();
		        }
			});

		//ADD BUTTON
	btnEadd.setOnAction(e->{
		AddEmployee cList=new AddEmployee();
		try {
			cList.start(stage);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
	});
	//BUTTON GO TO OPERATÝONS CLASS
	btnOperations.setOnAction(e->{
		EmployeeOperations ced=new EmployeeOperations();
			try {
				ced.start(stage);
	        } catch (Exception e1) {
	            e1.printStackTrace();
	        }
		});
	 //EXÝT BUTTON
	 btnExit.setOnAction(e->{ stage.close(); });
	 //INFO BUTTON
	 btninfoepmloyee.setOnAction(e->{
			EmployerInfo infoscreen=new EmployerInfo();
			infoscreen.start();
		});
	 //OVER
	 
	 vmenu.getChildren().addAll(btnEadd,btnOperations,btnStatistics,btnExit,btninfoepmloyee);
		
		root.getChildren().addAll(border);
		border.setLeft(vmenu);
		border.setCenter(root2);
		root2.getChildren().addAll(topmenu);
		topmenu.getChildren().addAll(hboxtop);
		hboxtop.getChildren().addAll(btninfouser,i2name);
		Scene yeniyoneticimenu=new Scene(root,1200,800);
		root.setId("root_yonetici_style");
		vmenu.setId("vmenu");
		vmenu.setPrefSize(232, 800);

		yeniyoneticimenu.getStylesheets().add(getClass().getResource("/application/style.css").toExternalForm());
		stage.setScene(yeniyoneticimenu);
		stage.show();
	}
}