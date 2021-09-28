package txtRepository;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;
import entity.IBaseDal;
import entity.JavafxEntity;

public class TxtEmployee extends JavafxEntity implements IBaseDal{	
	public void addEmployee(TxtEmployee employee) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss");
	    Date date1 = new Date(); 

	    if(getNameinput().getLength()==0) 	 			{ 	JOptionPane.showMessageDialog(null,"NAME field is empty","NAME",JOptionPane.ERROR_MESSAGE,null); 		}
	    else if(getNameinput().getLength()<2 ) 	     	 {	JOptionPane.showMessageDialog(null,"Your NAME can't be shorter than 2 letters","NAME",JOptionPane.ERROR_MESSAGE,null); 		}
	    else if(getNameinput().getLength()>15) 	 {    	JOptionPane.showMessageDialog(null,"Your NAME can not be longer than 15 letters","NAME",JOptionPane.ERROR_MESSAGE,null );	 }
	   
	    else if(getSurnameinput().getLength()==0)  {		JOptionPane.showMessageDialog(null,"SURNAME field is empty","SURNAME",JOptionPane.ERROR_MESSAGE,null);    }
	    else if(getSurnameinput().getLength()<2)   {    	JOptionPane.showMessageDialog(null,"Your SURNAME can not be shorter than 2 letters","SURNAME",JOptionPane.ERROR_MESSAGE,null); }
	    else if(getSurnameinput().getLength()>15)   {		JOptionPane.showMessageDialog(null,"Your SURNAME can not be longer than 15 letters","SURNAME",JOptionPane.ERROR_MESSAGE,null );			 }
	    
	    else if(getPermissionCombo().getSelectionModel().isEmpty()) {
	    	JOptionPane.showMessageDialog(null,"Please select permition","PERMÝTÝON",JOptionPane.ERROR_MESSAGE,null);
	    }

	    else if(getUsernameinput().getLength()==0)  {	JOptionPane.showMessageDialog(null,"Username field is empty","USERNAME",JOptionPane.ERROR_MESSAGE,null); 		}  
	    else if(getUsernameinput().getLength()<2)    {   	JOptionPane.showMessageDialog(null,"Your Usarname can't be shorter than 2 letters","USERNAME",JOptionPane.ERROR_MESSAGE,null);		}
	    else if(getUsernameinput().getLength()>15)   {	JOptionPane.showMessageDialog(null,"Your Username can not be longer than 15 letters","USERNAME",JOptionPane.ERROR_MESSAGE,null );		}
	    

	    else if(getPasswordinput().getLength()==0)   {	JOptionPane.showMessageDialog(null,"Password field is empty","PASSWORD",JOptionPane.ERROR_MESSAGE,null); 		}
	    else if(getPasswordinput().getLength()<4)	    {  	JOptionPane.showMessageDialog(null,"Your Password can't be shorter than 4 character","PASSWORD",JOptionPane.ERROR_MESSAGE,null);		    }
	    else if(getPasswordinput().getLength()>6) 	    {  	JOptionPane.showMessageDialog(null,"Your Password can not be longer than 9 character","PASSWORD",JOptionPane.ERROR_MESSAGE,null );		}
	   
	    else if(Query()){
	    	JOptionPane.showMessageDialog(null,"Your USERNAME has taken from someone!","USERNAME",JOptionPane.ERROR_MESSAGE,null);	
	    }
	    else{
		try {
			File file=new File("users.txt");
			BufferedWriter writer;
			writer=	new BufferedWriter(new FileWriter (file,true));
			
			if(file.length()!=0) 
			{writer.newLine();}
			
			writer.write(employee.getNameinput().getText());
			writer.newLine();
			writer.write(employee.getSurnameinput().getText());
			writer.newLine();
			writer.write(employee.getPermissionCombo().getValue());
			writer.newLine();
			writer.write(employee.getUsernameinput().getText());
			writer.newLine();
			writer.write(employee.getPasswordinput().getText());
			writer.newLine();
			writer.write(dateFormat.format(date1));
		//Pop-up
			JOptionPane.showMessageDialog(null, "Adding Successful");	
		writer.close();
	} catch (IOException e) {
		e.printStackTrace();
			}
	    }
}	
	//Ayný USERNAME bilgisinin birden fazla kiþiye verilmemesi için bir sorgulama methodu
	@Override
	public boolean Query()  {	
		boolean answer=false;
		File file = new File("users.txt");
		Scanner reader;
		try {
			reader = new Scanner(file);

		while (reader.hasNextLine()) {
			
			String name = reader.nextLine();
			String surname = reader.nextLine();
			String permition= reader.nextLine(); 
			String username= reader.nextLine();
			String password = reader.nextLine();
			String checkin= reader.nextLine();
			
			if (getUsernameinput().getText().equals(username)) {
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