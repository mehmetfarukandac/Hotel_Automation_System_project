package oUpdateDelete;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import entity.EmployeeEntity;
import entity.OperationsWrite;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class UpdateEmployee extends OperationsWrite{
    public void updateUser(TableView<EmployeeEntity> table,TextField newName,TextField newSurname,ComboBox<String> newPerm,
    										TextField newUsername,TextField newPassword) throws IOException{    	
		ObservableList<EmployeeEntity> observableList;//Getting the selected value from the table 
		observableList=table.getSelectionModel().getSelectedItems();//created to get the selected value from the table
		EmployeeEntity employee=observableList.get(0);//Created a Employee and this Employee took value that selected
		
		if(table.getSelectionModel().getSelectedItems().isEmpty()) {
			JOptionPane.showMessageDialog(null, "No Employee to UPDATE was selected","Employee",JOptionPane.ERROR_MESSAGE,null);
		}
		else if(newName.getText().isEmpty()==true) {
			JOptionPane.showMessageDialog(null, "Please write to new NAME","NAME",JOptionPane.ERROR_MESSAGE,null);
		}
		else if(newSurname.getText().isEmpty()==true) {
			JOptionPane.showMessageDialog(null, "Please write to new SURNAME","SURNAME",JOptionPane.ERROR_MESSAGE,null);
		}
		else if(newPerm.getSelectionModel().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please write to new PERMÝSSÝON","PERMÝSSÝON",JOptionPane.ERROR_MESSAGE,null);
		}
		else if(newUsername.getText().isEmpty()==true) {
			JOptionPane.showMessageDialog(null, "Please write to new USERNAME","USERNAME",JOptionPane.ERROR_MESSAGE,null);
		}
		else if(newPassword.getText().isEmpty()==true) {
			JOptionPane.showMessageDialog(null, "Please write to new PASSWORD","PASWORD",JOptionPane.ERROR_MESSAGE,null);
		}
		
		else {
			JOptionPane.showMessageDialog(null, "UPDATE sucessfull","UPDATE",JOptionPane.INFORMATION_MESSAGE,null);
        ArrayList<String> list=new ArrayList<>();
        File file=new File("users.txt");
        Scanner reader=new Scanner(file);
        while(reader.hasNextLine()){
            int flag =0;//kind of counter for missing equal values	
            String name = reader.nextLine(); 
			String surname = reader.nextLine();
			String permisson= reader.nextLine();
			String username= reader.nextLine();
			String password = reader.nextLine();
			String date= reader.nextLine();
            if(employee.getUsername().toUpperCase().equals(username.toUpperCase())){
                list.add(newName.getText());
                list.add(newSurname.getText());
                list.add(newPerm.getSelectionModel().getSelectedItem());
                list.add(newUsername.getText());
                list.add(newPassword.getText());
                list.add(date);
                flag++;
            }     
            if(flag==0){
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
    public void writetoFile(ArrayList<String> list)throws IOException{
    	//Writing ArrayList to file
    	File file=new File("users.txt");
        BufferedWriter writer =new BufferedWriter(new FileWriter(file));
        for(int i=0;i<list.size();i++){
            writer.write(list.get(i));
            if((list.size()-1)!=i){
                writer.newLine();
            }
        }
        writer.close(); 
    }
}