package oUpdateDelete;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import entity.JavafxEntity;
import javafx.scene.control.TextField;

public class QueryEmployee extends JavafxEntity{
	private static int sayac=0;
	public void query(TextField textField)  {
	File file = new File("users.txt");
	Scanner reader;
	try {
		reader = new Scanner(file);
	while (reader.hasNextLine()) {
		
		String name = reader.nextLine();
		String surname = reader.nextLine();
		String id= reader.nextLine(); 
		String phone= reader.nextLine();
		String room = reader.nextLine();
		String checkin= reader.nextLine();
		String gender= reader.nextLine();
		
		if (textField.getText().equals(id)) {
			JOptionPane.showMessageDialog(null, "Username has taken from someone");
			setSayac(getSayac() + 1);
		}

	}
	reader.close();
	
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
}
	public static int getSayac() {
		return sayac;
	}
	public static void setSayac(int sayac) {
		QueryEmployee.sayac = sayac;
	}
}