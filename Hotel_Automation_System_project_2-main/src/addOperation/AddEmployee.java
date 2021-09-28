package addOperation;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import employerMenu.EmployerInfo;
import employerMenu.statistics;
import entity.JavafxEntity;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import operations.EmployeeOperations;
import txtRepository.TxtEmployee;

public class AddEmployee extends JavafxEntity{
 
	
	public void start(Stage stage) throws IOException  {
		String username;
		File Username =new File("username.txt"); 
		Scanner reader=new Scanner(Username);
		username=reader.nextLine();
		reader.close();
		StackPane root=new StackPane();
		StackPane root2=new StackPane(); root2.setId("root2");
		// Top menu info labels
		Label i2name=new Label(username);	i2name.setId("top_menu_label");
		
		
		
		
		Button btninfouser=new Button(); btninfouser.setId("top_user_icon");
		HBox hboxtop=new HBox(); hboxtop.setId("hboxtop-style");
		BorderPane border=new BorderPane();
		VBox vmenu=new VBox();
		HBox topmenu=new HBox();				topmenu.setId("stat_top_menu");	
		topmenu.setAlignment(Pos.TOP_LEFT);
		
		Button btnEadd=new Button(""); 			btnEadd.setId("menubutons");
		Button btnOperations=new Button(""); 	btnOperations.setId("menubutons");
		Button btnStatistics=new Button(""); 	btnStatistics.setId("menubutons");
		Button btnExit=new Button(""); 			btnExit.setId("menubutons");
		Button btninfoepmloyee=new Button(""); btninfoepmloyee.setId("info_btn");
		 // LEFT MENU BUTONS----
		
		AddEmployee cList=new AddEmployee();
		btnEadd.setOnAction(e->{
			try {
				cList.start(stage);
	        } catch (Exception e1) {
	            e1.printStackTrace();
	        }
		});
		btnOperations.setOnAction(e->{
		EmployeeOperations ced=new EmployeeOperations();	
				try {
					ced.start(stage);
		        } catch (Exception e1) {
		            e1.printStackTrace();
		        }
			});
		btnStatistics.setOnAction(e->{
			statistics stats=new statistics();
			try {
				stats.start(stage);
	        } catch (Exception e1) {
	            e1.printStackTrace();
	        }
		});
		btnExit.setOnAction(e->{
			 stage.close();	 
		});
		btninfoepmloyee.setOnAction(e->{
			EmployerInfo infoscreen=new EmployerInfo();
			infoscreen.start();
		});
		// LEFT MENU BUTONS____
	 
		
		GridPane gridPane=new GridPane();
		
		
		//GridPane's Design
		GridPane.setConstraints(getUsernamelabel(),2,0);
		getUsernameinput().setPromptText("Username");
		GridPane.setConstraints(getUsernameinput(),3,0);
		
		getUsernamelabel().getStyleClass().add("welcome-text-Employee");
		getPasswordlabel().getStyleClass().add("welcome-text-Employee");
		getSurnamelabel().getStyleClass().add("welcome-text-Employee");
		getNamelabel().getStyleClass().add("welcome-text-Employee");
		getWarningMessage().getStyleClass().add("welcome-text-Employee");
		
		GridPane.setConstraints(getPasswordlabel(),2,1);
		getPasswordinput().setPromptText(" PASSWORD");
		GridPane.setConstraints(getPasswordinput(),3,1);
		
		GridPane.setConstraints(getSurnamelabel(),0,1);
		getSurnameinput().setPromptText("SURNAME");
		GridPane.setConstraints(getSurnameinput(),1,1);
 
		GridPane.setConstraints(getPermissionCombo(),1,2);
		getPermissionCombo().getItems().addAll("1","5");
		
		Label lEmployee=new Label();
		lEmployee.setText("1-Employee\n5-Employer");
		lEmployee.getStyleClass().add("label-lEmployee");
		GridPane.setConstraints(lEmployee,1,3);
		
		Tooltip tooltip1 = new Tooltip("EMPLOYE-1 || EMPLOYER-5");
		getPermissionCombo().setTooltip(tooltip1);

		getPermissionCombo().setPromptText("PERMÝSSÝON");
		
		GridPane.setConstraints(getNamelabel(),0,0);
		getNameinput().setPromptText(" NAME");
		GridPane.setConstraints(getNameinput(),1,0); 
		
		GridPane.setConstraints(getWarningMessage(),1,6);

		getUsernamelabel().setId("content_label");
		getPasswordlabel().setId("content_label");
		getSurnamelabel().setId("content_label");
		getNamelabel().setId("content_label");
		getWarningMessage().setId("content_label");
		//OVER
		
		
		//GridPane Operations
		gridPane.setPadding(new Insets(10,10,10,10));
		gridPane.setVgap(8);
		gridPane.setHgap(10);
		gridPane.setAlignment(Pos.CENTER);
		
		
		
		//ADD Button
		Button btnAEmployee=new Button("ADD EMPLOYEE");
		btnAEmployee.getStyleClass().add("button-allButtons");
		btnAEmployee.getStyleClass().add("button:hover-allButtons");
		GridPane.setConstraints(btnAEmployee,2,7);
		btnAEmployee.setOnAction(e->{
			TxtEmployee employee=new TxtEmployee();
			employee.getNameinput().getText();
			employee.getSurnameinput().getText();
			employee.getPermissionCombo();
			employee.getUsernameinput();
			employee.getPasswordinput();
			
			employee.addEmployee(employee);
		});
		
		//Adding Buttons,Labels and TextFields to GridPane
		gridPane.getChildren().addAll(getNamelabel(),getNameinput(),getSurnamelabel()
				,getSurnameinput(),getUsernamelabel(),getUsernameinput(),getPasswordlabel(),getPasswordinput(),
				getPermissionCombo(),lEmployee,getWarningMessage(),btnAEmployee);

		
		vmenu.getChildren().addAll(btnEadd,btnOperations,btnStatistics,btnExit,btninfoepmloyee);
		root.getChildren().addAll(border);
		border.setLeft(vmenu);
		border.setCenter(root2);
		root2.getChildren().addAll(topmenu,gridPane);
		topmenu.getChildren().addAll(hboxtop);
		hboxtop.getChildren().addAll(btninfouser,i2name);
		
		
		Scene addemp=new Scene(root,1200,800);
		root.setId("root_add_epmloyee");
		vmenu.setId("vmenu");
		vmenu.setPrefSize(232, 800);
		addemp.getStylesheets().add(getClass().getResource("/application/style.css").toExternalForm());
		addemp.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
		stage.setScene(addemp);	
		stage.show();
	}	
}
