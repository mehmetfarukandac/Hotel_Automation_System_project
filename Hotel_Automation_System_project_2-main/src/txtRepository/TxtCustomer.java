package txtRepository;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;
import entity.IBaseDal;
import entity.JavafxEntity;

public class TxtCustomer extends JavafxEntity implements IBaseDal{
	public void addCustomer(TxtCustomer customer) {
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss");
    Date date1 = new Date();
    
    if(getNameinput().getLength()==0) 	 		{ 		JOptionPane.showMessageDialog(null,"NAME field is empty","NAME",JOptionPane.ERROR_MESSAGE,null); 		}
    else if(getNameinput().getLength()<2 ) 	     {		JOptionPane.showMessageDialog(null,"Your NAME can't be shorter than 2 letters","NAME",JOptionPane.ERROR_MESSAGE,null); 		}
    else if(getNameinput().getLength()>15) 	 {    	JOptionPane.showMessageDialog(null,"Your NAME can not be longer than 15 letters","NAME",JOptionPane.ERROR_MESSAGE,null );	 }
   
    else if(getSurnameinput().getLength()==0)  {		JOptionPane.showMessageDialog(null,"SURNAME field is empty","SURNAME",JOptionPane.ERROR_MESSAGE,null);    }
    else if(getSurnameinput().getLength()<2)    {    	JOptionPane.showMessageDialog(null,"Your SURNAME can not be shorter than 2 letters","SURNAME",JOptionPane.ERROR_MESSAGE,null); }
    else if(getSurnameinput().getLength()>15)  {		JOptionPane.showMessageDialog(null,"Your SURNAME can not be longer than 15 letters","SURNAME",JOptionPane.ERROR_MESSAGE,null );			 }
    
    else if(getIdinput().getLength()==0) 		   	  {	 	JOptionPane.showMessageDialog(null,"ID field is empty","ID",JOptionPane.ERROR_MESSAGE,null); 		}  
    
    else if(getPhoneinput().getLength()==0)  	{		JOptionPane.showMessageDialog(null,"PHONE NUMBER field is empty","PHONE NUMBER",JOptionPane.ERROR_MESSAGE,null); 		}  
    else if(getPhoneinput().getLength()<11)    {   		JOptionPane.showMessageDialog(null,"Your PHONE NUMBER can't be shorter than 11 Number","PHONE NUMBER",JOptionPane.ERROR_MESSAGE,null);		}
    
    else if(getRoominput().getLength()==0)   {			JOptionPane.showMessageDialog(null,"ROOM NUMBER field is empty","ROOM NUMBER",JOptionPane.ERROR_MESSAGE,null); 		}
    else if(getRoominput().getLength()<4)	   {  		JOptionPane.showMessageDialog(null,"Your ROOM NUMBER can't be shorter than 4 number","ROOM NUMBER",JOptionPane.ERROR_MESSAGE,null);		    }
    
    else if(roomQuery()){
    	JOptionPane.showMessageDialog(null,"Your ROOM has taken from someone!","ROOM",JOptionPane.ERROR_MESSAGE,null);	
    }
    else if(idQuery()){
    	JOptionPane.showMessageDialog(null,"Your ID has taken from someone!","ID",JOptionPane.ERROR_MESSAGE,null);	
    }
    else if(Query()==true) {
    	JOptionPane.showMessageDialog(null,"Please write an empty room","ROOM",JOptionPane.ERROR_MESSAGE,null);
    }
    else if(getGenderfield().getSelectionModel().isEmpty()) {
    	JOptionPane.showMessageDialog(null,"Please select Gender","GENDER",JOptionPane.ERROR_MESSAGE,null);
    }
    else if(getPricefieldAdd().getSelectionModel().isEmpty()) {
    	JOptionPane.showMessageDialog(null,"Please select PRÝCE","PRÝCE",JOptionPane.ERROR_MESSAGE,null);
    }
    else if(rDeleteCAdd(getRoominput().getText())) {
    }
    else {
	try {
	File file=new File("Customer.txt");
	BufferedWriter writer;
	writer=	new BufferedWriter(new FileWriter (file,true));
	 
	if(file.length()!=0) 
	writer.newLine();
	
	writer.write(customer.getNameinput().getText());
	writer.newLine();
	writer.write(customer.getSurnameinput().getText());
	writer.newLine();
	writer.write(customer.getIdinput().getText());
	writer.newLine();
	writer.write(customer.getPhoneinput().getText());
	writer.newLine();
	writer.write(customer.getRoominput().getText());
	writer.newLine();
	writer.write(getGenderfield().getValue());
	writer.newLine();
	writer.write(dateFormat.format(date1));
	writer.newLine();
	writer.write(getPricefieldAdd().getValue());
	
	//Pop-up
	JOptionPane.showMessageDialog(null, "Adding Successful");	
	writer.close();
} catch (IOException e) {
	e.printStackTrace();
			}
    	}
	}
//Ayný ID bilgisinin birden fazla kiþiye verilmemesi için bir sorgulama methodu
public boolean idQuery()  {	
	boolean answer=false;
	File file = new File("Customer.txt");
	Scanner reader;
	try {
		reader = new Scanner(file);

	while (reader.hasNextLine()) {
		
		String name = reader.nextLine();
		String surname = reader.nextLine();
		String id= reader.nextLine(); 
		String phone= reader.nextLine();
		String room = reader.nextLine();
		String gender= reader.nextLine();
		String checkin= reader.nextLine();
		String price= reader.nextLine();
		
		if (getIdinput().getText().equals(id)) {
			answer=true;
		} 
	}
	reader.close();	
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	return answer;
}
//Ayný ROOM bilgisinin birden fazla kiþiye verilmemesi için bir sorgulama methodu
public boolean roomQuery()  {	
	boolean answer=false;
	File file = new File("Customer.txt");
	Scanner reader;
	try {
		reader = new Scanner(file);

while (reader.hasNextLine()) {
		String name = reader.nextLine();
		String surname = reader.nextLine();
		String id= reader.nextLine(); 
		String phone= reader.nextLine();
		String room = reader.nextLine();
		String gender= reader.nextLine();
		String checkin= reader.nextLine();
		String price= reader.nextLine();

		 if(getRoominput().getText().equals(room)){
			answer=true;
		}
}
reader.close();	
} catch (FileNotFoundException e) {
	e.printStackTrace();
}
return answer;
}
//CUSTOMER EKLENÝRKEN ODA SÝLÝNÝYOR
public static boolean rDeleteCAdd(String room) {	
	boolean answer=false;
	ArrayList<String> list=new ArrayList<>();
	File file = new File("Room.txt");
	Scanner reader;
	int sayac=0;
	try {
		reader = new Scanner(file);

while (reader.hasNextLine()) {
		String rooms = reader.nextLine();

		 if(room.equals(rooms)){
			 sayac++;
		}
		 else {
			 list.add(rooms);
		 }
		 try {
			writetoFile(list);
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
public static void writetoFile(ArrayList<String> list) throws IOException {
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

//Sadece boþ odalardan seçim yapýlabilir
public boolean Query()  {	
	boolean answer=false;
	File file = new File("Room.txt");
	Scanner reader;
	try {
		reader = new Scanner(file);

while (reader.hasNextLine()) {
		String room = reader.nextLine();

		 if(getRoominput().getText().equals(room)==true){
			answer=false;
		}
		 else {
			 answer=true;
		 }
}
reader.close();	
} catch (FileNotFoundException e) {
	e.printStackTrace();
}
	return answer;
	}
}
