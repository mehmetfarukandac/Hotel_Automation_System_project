package login;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import employeeMenu.EmployeeMenu;
import employerMenu.EmployerMenu;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Login extends Application{
	
	public static String username;
	
	public void start(Stage stage) {
		
		stage.setTitle("LOGÝN SCREEN");
		
		//taking username from user
		Label luser=new Label("Username:");	luser.setId("luser");
		TextField tfuser=new TextField();	tfuser.setId("tfuser");
		//taking password from user
		Label lpass=new Label("Password:"); lpass.setId("lpass");
		PasswordField tfpass=new PasswordField(); tfpass.setId("tfpass");
		Label ltitle=new Label(""); ltitle.setId("ltitle");
		//Giving warning massage (in else if)
		Label status=new Label("");
		
		stage.setX(300);
		stage.setY(140);
		//ButtonActions start here
		//For login Button
		Button btnlogin=new Button("Login");	btnlogin.setId("btnlogin");

		btnlogin.getStyleClass().add("button-allButtons");
		btnlogin.getStyleClass().add("button:hover-allButtons");
		btnlogin.setOnAction(e->{	
			if(tfuser.getText().isEmpty() ) {
				status.setText("USERNAME field is Empty");
			}
			else if(tfuser.getText().isEmpty() & tfpass.getText().isEmpty()) {
				status.setText("USERNAME and PASSWORD field is Empty");
			}
			else if(tfpass.getText().isEmpty()) {
				status.setText("PASSWORD field is Empty");
			}
			else {
		//Read File
		File file = new File("users.txt");
		File Username = new File("username.txt");
		Scanner reader;
		
		try {
			reader = new Scanner(file);
		while (reader.hasNextLine()) {
			String name = reader.nextLine();
			String surname = reader.nextLine();
			String perm = reader.nextLine();
			String username= reader.nextLine();
			String password = reader.nextLine();
			String date = reader.nextLine();
			
			// if Conditions
			//START
			  if (tfuser.getText().equals(username) & tfpass.getText().equals(password)&perm.equals("5")) {
				  try {
						BufferedWriter writer=new BufferedWriter(new FileWriter(Username));
						writer.write(username);
						writer.close();
					} catch (IOException e2) {
						e2.printStackTrace();
					}
				EmployerMenu employee=new EmployerMenu();
				try {
					employee.start(stage);
		        } catch (Exception e11) {
		            e11.printStackTrace();
		        }
			}
			else if (tfuser.getText().equals(username) & tfpass.getText().equals(password)&perm.equals("1")) {
				try {
					BufferedWriter writer=new BufferedWriter(new FileWriter(Username));
					writer.write(username);
					writer.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				EmployeeMenu employee=new EmployeeMenu();
				try {
					employee.start(stage);
		        } catch (Exception e11) {
		            e11.printStackTrace();
		        } 
			}
			else if(tfuser.getText()!=(username.toUpperCase())) {
				status.setText("Wrong Username or Password");
				status.getStyleClass().add("label-lEmployee");
				}
			  //OVER
		}reader.close();
		} catch (FileNotFoundException e2) {
					e2.printStackTrace();
		}
	}
});
		
		//For Exit Button
		Button btnExit=new Button("EXÝT");	btnExit.setId("btnexit");
		btnExit.getStyleClass().add("button-allButtons");
		btnExit.getStyleClass().add("button:hover-allButtons");
		btnExit.setOnAction(e4->	stage.close());
		//ButtonActions over here
		
		//Screen Operations
		StackPane root=new StackPane();
		BorderPane loginborder=new BorderPane();
		VBox loginvbox=new VBox();  
		VBox VBbutons=new VBox();
		VBbutons.getStyleClass().add("root-scene");
		root.getChildren().add(loginborder);
		loginborder.setRight(loginvbox);
		loginborder.setLeft(ltitle);
		VBbutons.getChildren().addAll(btnlogin,btnExit);
		loginvbox.getChildren().addAll(luser,tfuser,lpass,tfpass,VBbutons,status);
		loginvbox.setId("loginvbox");
		
		Scene scene=new Scene(root,1200,800);
		stage.setScene(scene);
		stage.show();
		root.setId("loginroot");
		scene.getStylesheets().add(getClass().getResource("/application/style.css").toExternalForm());
		scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
	}
}