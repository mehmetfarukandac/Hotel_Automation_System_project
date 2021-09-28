package oUpdateDelete;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import entity.CustomerEntity;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class DeleteCustomer { 
	//Delete Customer Class
	public void deleteCustomer(TableView<CustomerEntity> table,TextField ID) throws IOException {
		if(table.getSelectionModel().getSelectedItems().isEmpty()) {
			JOptionPane.showMessageDialog(null, "No CUSTOMER to DELETE was selected","CUSTOMER",JOptionPane.ERROR_MESSAGE,null);
		}
		else {
			JOptionPane.showMessageDialog(null, "DELETE sucessfull","DELETE",JOptionPane.INFORMATION_MESSAGE,null);
		ArrayList<String> list = new ArrayList<>();
		File file = new File("Customer.txt");
		Scanner reader = new Scanner(file);
		while (reader.hasNextLine()) {
			int flag = 0; //kind of counter for missing equal values
			String name = reader.nextLine();
			String surname = reader.nextLine();
			String id= reader.nextLine(); 
			String phone= reader.nextLine();
			String room = reader.nextLine();
			String gender= reader.nextLine();
			String checkin= reader.nextLine();
			String price= reader.nextLine();
			
			if(ID.getText().toUpperCase().equals(id)) {
				flag++;
			}
			if (flag == 0) {
				  list.add(name);
				  list.add(surname);
				  list.add(id); 
				  list.add(phone); 
				  list.add(room);
				  list.add(gender);
				  list.add(checkin);				 
				  list.add(price);
			}
		}
		reader.close();
		writetoFile(list);
	}
}
	public void writetoFile(ArrayList<String> list) throws IOException {
		//Writing ArrayList to file
		File file = new File("Customer.txt");
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