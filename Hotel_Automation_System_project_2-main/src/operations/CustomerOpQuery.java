package operations;

import javax.swing.JOptionPane;

import entity.JavafxEntity;

public class CustomerOpQuery extends JavafxEntity{
	//HATA AYIKLAMA ALANI
	public void query() {
		 if(getTfName().getLength()==0) 	 		{ 		JOptionPane.showMessageDialog(null,"NAME field is empty","NAME",JOptionPane.ERROR_MESSAGE,null); 		}
		    else if(getTfName().getLength()<2 ) 	     {		JOptionPane.showMessageDialog(null,"Your NAME can't be shorter than 2 letters","NAME",JOptionPane.ERROR_MESSAGE,null); 		}
		    else if(getTfName().getLength()>15) 	 {    	JOptionPane.showMessageDialog(null,"Your NAME can not be longer than 15 letters","NAME",JOptionPane.ERROR_MESSAGE,null );	 }
		   
		    else if(getTfSurname().getLength()==0)  {		JOptionPane.showMessageDialog(null,"SURNAME field is empty","SURNAME",JOptionPane.ERROR_MESSAGE,null);    }
		    else if(getTfSurname().getLength()<2)    {    	JOptionPane.showMessageDialog(null,"Your SURNAME can not be shorter than 2 letters","SURNAME",JOptionPane.ERROR_MESSAGE,null); }
		    else if(getTfSurname().getLength()>15)  {		JOptionPane.showMessageDialog(null,"Your SURNAME can not be longer than 15 letters","SURNAME",JOptionPane.ERROR_MESSAGE,null );			 }
		    
		    else if(getTfId().getLength()==0) 		   	  {	 	JOptionPane.showMessageDialog(null,"ID field is empty","ID",JOptionPane.ERROR_MESSAGE,null); 		}  
		    
		    else if(getTfPhone().getLength()==0)  	{		JOptionPane.showMessageDialog(null,"PHONE NUMBER field is empty","PHONE NUMBER",JOptionPane.ERROR_MESSAGE,null); 		}  
		    else if(getTfPhone().getLength()<11)    {   		JOptionPane.showMessageDialog(null,"Your PHONE NUMBER can't be shorter than 11 Number","PHONE NUMBER",JOptionPane.ERROR_MESSAGE,null);		}
		 
		    else if(getTfRoom().getLength()==0)   {			JOptionPane.showMessageDialog(null,"ROOM NUMBER field is empty","ROOM NUMBER",JOptionPane.ERROR_MESSAGE,null); 		}
		    else if(getTfRoom().getLength()<4)	   {  		JOptionPane.showMessageDialog(null,"Your ROOM NUMBER can't be shorter than 4 number","ROOM NUMBER",JOptionPane.ERROR_MESSAGE,null);		    }
	}
}
