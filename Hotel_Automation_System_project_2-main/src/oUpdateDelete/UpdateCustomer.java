package oUpdateDelete;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

import entity.CustomerEntity;
import entity.JavafxEntity;
import entity.OperationsWrite;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class UpdateCustomer extends OperationsWrite{
    private static int counter;
	public void updateCustomer(TableView<CustomerEntity> table,TextField newName,TextField newSurname,
    										TextField newPhone,TextField newRoom, ComboBox<String> newPrice,ComboBox<String> newGender) throws IOException{    	

		ObservableList<CustomerEntity> observableList;//Getting the selected value from the table 
		observableList=table.getSelectionModel().getSelectedItems();//created to get the selected value from the table
		CustomerEntity customer=observableList.get(0);//Created a Customer and this Customer took value that selected
		JavafxEntity javafxEntity =new JavafxEntity();
		if(table.getSelectionModel().getSelectedItems().isEmpty()) {
			JOptionPane.showMessageDialog(null, "No CUSTOMER to UPDATE was selected","CUSTOMER",JOptionPane.ERROR_MESSAGE,null);
		}
		 else if(rDeleteCAdd(javafxEntity.getTfRoom().getText())) {
		    }
		else if(newName.getText().isEmpty()==true) {
			JOptionPane.showMessageDialog(null, "Please write to new NAME","NAME",JOptionPane.ERROR_MESSAGE,null);
		}
		else if(newRoom.getText().isEmpty()==true) {
			JOptionPane.showMessageDialog(null, "Please write to new ROOM","ROOM",JOptionPane.ERROR_MESSAGE,null);
		}
		else if(newSurname.getText().isEmpty()==true) {
			JOptionPane.showMessageDialog(null, "Please write to new SURNAME","SURNAME",JOptionPane.ERROR_MESSAGE,null);
		}
		else if(newPhone.getText().isEmpty()==true) {
			JOptionPane.showMessageDialog(null, "Please write to new PHONE NUMBER","PHONE NUMBER",JOptionPane.ERROR_MESSAGE,null);
		}
		else if(newGender.getSelectionModel().isEmpty()) {
	    	JOptionPane.showMessageDialog(null,"please check the Comboboxes first","GENDER",JOptionPane.ERROR_MESSAGE,null);
	    }
		else if(newPrice.getSelectionModel().isEmpty()) {
	    	JOptionPane.showMessageDialog(null,"please check the Comboboxes first","PRÝCE",JOptionPane.ERROR_MESSAGE,null);
	    }
		else {
			JOptionPane.showMessageDialog(null, "UPDATE sucessfull","UPDATE",JOptionPane.INFORMATION_MESSAGE,null);
        ArrayList<String> list=new ArrayList<>();
        File file=new File("Customer.txt");
        Scanner reader=new Scanner(file);
        while(reader.hasNextLine()){
            int flag =0;//kind of counter for missing equal values	
            String name = reader.nextLine(); 
			String surname = reader.nextLine();
			String id= reader.nextLine();
			String phone= reader.nextLine();
			String room = reader.nextLine();
			String gender= reader.nextLine();
			String date= reader.nextLine();
			String price= reader.nextLine();
			
            if(customer.getIdentity().equals(id)){
                list.add(newName.getText());
                list.add(newSurname.getText());
                list.add(id);
                list.add(newPhone.getText());
                list.add(newRoom.getText());
                list.add(newGender.getSelectionModel().getSelectedItem());
                list.add(date);
                list.add(newPrice.getSelectionModel().getSelectedItem());
                flag++;
            }     
            if(flag==0){
          	  list.add(name);
			  list.add(surname);
			  list.add(id); 
			  list.add(phone); 
			  list.add(room);
			  list.add(gender);
			  list.add(date);
			  list.add(price);
            }
        }
        reader.close();
        writetoFile(list);
    }
}
    public void writetoFile(ArrayList<String> list)throws IOException{
    
    	//Writing ArrayList to file
    	File file=new File("Customer.txt");
        BufferedWriter writer =new BufferedWriter(new FileWriter(file));
        for(int i=0;i<list.size();i++){
            writer.write(list.get(i));
            if((list.size()-1)!=i){
                writer.newLine();
            }
        }
        writer.close();
    }
  //CUSTOMER EKLENÝRKEN ODA SÝLÝNÝYOR
    public static boolean rDeleteCAdd(String room) {	
    	boolean answer=false;
    	ArrayList<String> list=new ArrayList<>();
    	File file = new File("Room.txt");
    	Scanner reader;
    	setCounter(0);
    	try {
    		reader = new Scanner(file);

    while (reader.hasNextLine()) {
    		String rooms = reader.nextLine();

    		 if(room.equals(rooms)){
    			 setCounter(getCounter() + 1);
    		}
    		 else {
    			 list.add(rooms);
    		 }
    		 try {
    			writetoFileRoom(list);
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    }
    reader.close();	
    } catch (FileNotFoundException e) {
    	e.printStackTrace();
    }

    return answer;

    }	
    public static void writetoFileRoom(ArrayList<String> list) throws IOException {
    	//Writing ArrayList to file
    	File file = new File("Room.txt");
    	BufferedWriter writer = new BufferedWriter(new FileWriter(file));
    	for (int i = 0; i < list.size(); i++) {
    		writer.write(list.get(i));
    		if ((list.size() - 1) != i) {
    			writer.newLine();
    		}
    	}
    	writer.close();

    	}
    //Getter & Setter For Counter
	public static int getCounter() {
		return counter;
	}
	public static void setCounter(int counter) {
		UpdateCustomer.counter = counter;
	}
}