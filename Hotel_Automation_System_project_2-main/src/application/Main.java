package application;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import login.Login;

public class Main extends Application {
	public void creatFile() {
		File room=new File("Room.txt"); 
		File file=new File("Customer.txt"); 
		File users=new File("users.txt"); 
		File Username=new File("username.txt"); 
		try {
			if(file.createNewFile()&users.createNewFile()&Username.createNewFile()&room.createNewFile()) {
				System.out.println("File Created now");
				// Default admin user
				BufferedWriter writer;
				writer=	new BufferedWriter(new FileWriter (users,true));
				if(users.length()!=0) 
				{writer.newLine();}
				writer.write("Admin");
				writer.newLine();
				writer.write("Admin");
				writer.newLine();
				writer.write("5");
				writer.newLine();
				writer.write("admin");
				writer.newLine();
				writer.write("admin");
				writer.newLine();
				writer.write("00/00/0000-00:00");
				writer.close();
				
				//Default room 1001
				writer=	new BufferedWriter(new FileWriter (room,true));
				if(room.length()!=0) 
				{writer.newLine();}
				writer.write("1001");
				writer.close();
				
			}else {
				System.out.println("File Already Has Created");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//MAÝN
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage stage) {
		stage.getIcons().add(new Image("file:image/Logo.png"));
		//CALLÝNG TO "FileCreat" 
		creatFile();
		//MAKÝNG STAGE UNDECORATED
		stage.initStyle(StageStyle.UNDECORATED); 
		stage.setTitle("MAIN");
		//LOGÝN BUTTON 
		Button btLogin=new Button(""); btLogin.setId("main-butons");
		Login addui=new Login();
		btLogin.setOnAction(e->{
			try {
				addui.start(stage);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
		});
		//EXÝT BUTTON
		Button btnExit=new Button(""); btnExit.setId("main-butons");
		btnExit.setOnAction(e->{ 	stage.close();	 });
		VBox root=new VBox(btLogin,btnExit);root.setId("main-style");
		Scene scene=new Scene(root,600,600);
		scene.getStylesheets().add(getClass().getResource("/application/style.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
}