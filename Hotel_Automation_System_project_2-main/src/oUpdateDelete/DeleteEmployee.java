package oUpdateDelete;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import entity.EmployeeEntity;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class DeleteEmployee {
	public void deleteUser(TableView<EmployeeEntity> table,TextField user) throws IOException {
		if(table.getSelectionModel().getSelectedItems().isEmpty()) {
			JOptionPane.showMessageDialog(null, "No Employee to DELETE was selected","Employee",JOptionPane.ERROR_MESSAGE,null);
		}
		else {
			JOptionPane.showMessageDialog(null, "DELETE sucessfull","DELETE",JOptionPane.INFORMATION_MESSAGE,null);
		ArrayList<String> list = new ArrayList<>();
		File file = new File("users.txt");
		Scanner reader = new Scanner(file);
		while (reader.hasNextLine()) {
			//int flagS = 0; //kind of counter for missing equal values
			int flag = 0;
			String name = reader.nextLine();
			String surname = reader.nextLine();
			String permisson= reader.nextLine();
			String username= reader.nextLine();
			String password = reader.nextLine();
			String date= reader.nextLine();
			if(user.getText().toUpperCase().equals(username.toUpperCase())) {
				flag++;
			}
			else if (flag == 0) {
				  list.add(name);
				  list.add(surname);
				  list.add(permisson); 
				  list.add(username); 
				  list.add(password);
				  list.add(date);				 
			}
		}
		reader.close();
		writetoFile(list);
	}
}
	public void writetoFile(ArrayList<String> list) throws IOException {
		//Writing ArrayList to file
		File file = new File("users.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		for (int i = 0; i < list.size(); i++) {
			writer.write(list.get(i));
			if ((list.size() - 1) != i) {
				writer.newLine();
			}
		}
		writer.close();
	}
}