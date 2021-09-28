package oUpdateDelete;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

import entity.OperationsWrite;
import entity.RoomEntity;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class UpdateRoom extends OperationsWrite{
	public void updateRoom(TableView<RoomEntity> roomsTable,String newRoom) throws IOException  {
		ObservableList<RoomEntity> observableList;//Getting the selected value from the table 
		observableList=roomsTable.getSelectionModel().getSelectedItems();//created to get the selected value from the table
		RoomEntity room=observableList.get(0);//Created a Room and this Room took value that selected

		if(roomsTable.getSelectionModel().getSelectedItems().isEmpty()) {
			JOptionPane.showMessageDialog(null, "No ROOM to UPDATE was selected","UPDATE ROOM",JOptionPane.ERROR_MESSAGE,null);
		}
		
		if(newRoom.isEmpty()==true) {
			JOptionPane.showMessageDialog(null, "Please write to new room","UPDATE ROOM",JOptionPane.ERROR_MESSAGE,null);
		}
		else {
			JOptionPane.showMessageDialog(null, "UPDATE sucessfull","UPDATE",JOptionPane.INFORMATION_MESSAGE,null);
		ArrayList<String> list=new ArrayList<>();
        File file=new File("Room.txt");
        Scanner reader=new Scanner(file);
        while(reader.hasNextLine()){
            int flag =0;//kind of counter for missing equal values	
			String rooms = reader.nextLine();
			
            if(room.getRoom().equals(rooms)){
                list.add(newRoom); 
                flag++;
            }     
            if(flag==0){
			  list.add(rooms);
			  }
        }
        reader.close();
        writetoFile(list);
    }
}
    public void writetoFile(ArrayList<String> list)throws IOException{
    	//Writing ArrayList to file
    	File file=new File("Room.txt");
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