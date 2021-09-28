package txtRepository;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import entity.IBaseDal;
import entity.JavafxEntity;

public class TxtRoom extends JavafxEntity implements IBaseDal{
	public void addRoom(TxtRoom room) {
		
		if(getRoomAddinput().getLength()==0) 		   	  {	 	JOptionPane.showMessageDialog(null,"ROOM field is empty","ROOM",JOptionPane.ERROR_MESSAGE,null); 		}  
		else if(Query()){	    	JOptionPane.showMessageDialog(null,"The ROOM is already empty","ROOM",JOptionPane.ERROR_MESSAGE,null);	  }
		
		else  { 	
		try {
			File file=new File("Room.txt");
			BufferedWriter writer;
			writer=	new BufferedWriter(new FileWriter (file,true));
			if(file.length()!=0)
				writer.newLine();
				
			writer.write(room.getRoomAddinput().getText());
			
			JOptionPane.showMessageDialog(null, "Adding Successful");	
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
					}
		    	}
	}
	//EKLENECEK ODANIN BOÞ OLUP OLMADIÐINI SORGULUYOR 
	@Override
	public boolean Query()  {	
		boolean answer=false;
		File file = new File("Room.txt");
		Scanner reader;
		try {
			reader = new Scanner(file);

		while (reader.hasNextLine()) {
			
			String room = reader.nextLine();
			
			if (getRoomAddinput().getText().equals(room)) {
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