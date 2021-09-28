package oUpdateDelete;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import entity.RoomEntity;
import javafx.scene.control.TableView;

public class DeleteRoom {
	public void deleteRoom(TableView<RoomEntity> roomsTable,String deleteRoom) throws IOException {		
		JOptionPane.showMessageDialog(null, "DELETE sucessfull","DELETE",JOptionPane.INFORMATION_MESSAGE,null);
		ArrayList<String> list = new ArrayList<>();
		File file = new File("Room.txt");
		Scanner reader = new Scanner(file);
		while (reader.hasNextLine()) {
			int flag = 0; //kind of counter for missing equal values
			String rooms = reader.nextLine();
			if (deleteRoom.equals(rooms)) {
				flag++;
			}
			if (flag == 0) { 
			  list.add(rooms);		 
			}
		}
		reader.close();
		writetoFile(list);
	}
	public void writetoFile(ArrayList<String> list) throws IOException {
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
}