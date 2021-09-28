package addOperation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import employeeMenu.EmployeeInfo;
import entity.JavafxEntity;
import entity.RoomEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import oUpdateDelete.DeleteRoom;
import oUpdateDelete.UpdateRoom;
import operations.CustomerOperations;
import txtRepository.TxtCustomer;
import txtRepository.TxtRoom;

public class AddCustomer extends JavafxEntity {	
	//Doluu ROOM'un Room listesine eklenmemesi için bir sorgulama methodu
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

			 if(getRoomAddinput().getText().equals(room)){
				answer=true;
			}
	}
	reader.close();	
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	return answer;
	}
	//
	//COLUMNLARA BILGI CEKMEK
	 public  ObservableList<RoomEntity> getAll()  {
		 ObservableList<RoomEntity> list=FXCollections.observableArrayList();
			File file=new File("Room.txt");
	        try {
	            Scanner reader=new Scanner(file);
	            while(reader.hasNextLine()){
	            String  room=reader.nextLine();
	            list.add(new RoomEntity(room));      
	            }
	            reader.close();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace(); 
	        }
	        return list; 
	 }
	public void start(Stage stage) throws IOException  {
		String username;
		File Username =new File("username.txt");
		Scanner reader=new Scanner(Username);
		username=reader.nextLine();
		reader.close();
		// Top menu info labels
		Label i2name=new Label(username);	i2name.setId("top_menu_label");
		Button btninfouser=new Button(); btninfouser.setId("top_user_icon");
		
		//STYLE MENULER
		HBox hboxtop=new HBox(); hboxtop.setId("hboxtop-style");
		StackPane root=new StackPane();
		StackPane root2=new StackPane(); root2.setId("root2");
		BorderPane border=new BorderPane();
		VBox vmenu=new VBox();
		HBox topmenu=new HBox();				topmenu.setId("stat_top_menu");	
		topmenu.setAlignment(Pos.TOP_LEFT);
		Button btnCadd=new Button(""); 			btnCadd.setId("menubutons");
		Button btnOperations=new Button(""); 	btnOperations.setId("menubutons");
		Button btnExit=new Button(""); 			btnExit.setId("menubutons");
		Button btninfoepmloyer=new Button(""); btninfoepmloyer.setId("info_btn");
		//OVER
		
		//START
				//ADD bUTTON
			btnCadd.setOnAction(e->{
				AddCustomer add=new AddCustomer();
				try {
					add.start(stage);
		        } catch (Exception e1) {
		            e1.printStackTrace();
		        }
			});
			//BUTTON GO TO OPERATÝONS CLASS
			CustomerOperations ced=new 	CustomerOperations();
			btnOperations.setOnAction(e->{
					try {
						ced.start(stage);
			        } catch (Exception e1) {
			            e1.printStackTrace();
			        }
				});
			//EXÝT bUTTON
			btnExit.setOnAction(e->{ 	stage.close();	 });
			//INFO BUTTON
			btninfoepmloyer.setOnAction(e->{
				EmployeeInfo infoscreen=new EmployeeInfo();
				infoscreen.start();
			});
			//OVER
		
			//ODALARIN LÝSTELENMESÝ ÝÇÝN COLUMN, TABLO, GRÝDPANE VE DÜZENLEMELERÝ
		TableColumn<RoomEntity,Integer> column1 = new TableColumn<>("Empty Rooms");
		TableView<RoomEntity> roomsTable = new TableView<RoomEntity>();
		GridPane gridpane=new GridPane();
		
		getPricefieldAdd().getItems().addAll("200","350","500");
		getPricefieldAdd().setPromptText("PRÝCE(TL)");
		//SON 
		
		
		//Customer GridPane's Design
			getGenderfield().getItems().addAll("Male","Female");
			getGenderfield().setPromptText("GENDER");
			GridPane.setConstraints(getGenderfield(),2,2);
			GridPane.setConstraints(getPricefieldAdd(),3,2);
			GridPane.setConstraints(getWarningMessage(),1,6);

			getNamelabel().getStyleClass().add("welcome-text-alltext");
			getSurnamelabel().getStyleClass().add("welcome-text-alltext");
			getIdlabel().getStyleClass().add("welcome-text-alltext");
			getPhonelabel().getStyleClass().add("welcome-text-alltext");
			getRoomlabel().getStyleClass().add("welcome-text-alltext");
			getRoomAddlabel().getStyleClass().add("welcome-text-alltext");
			
			GridPane.setConstraints(getNamelabel(),0,0);
			getNameinput().setPromptText("NAME");
			GridPane.setConstraints(getNameinput(),1,0);
			

			GridPane.setConstraints(getSurnamelabel(),0,1);
			getSurnameinput().setPromptText("SURNAME");
			GridPane.setConstraints(getSurnameinput(),1,1);
	 
			GridPane.setConstraints(getIdlabel(),0,2);
			getIdinput().setPromptText("ID");
			GridPane.setConstraints(getIdinput(),1,2);
			
			GridPane.setConstraints(getPhonelabel(),2,0);
			getPhoneinput().setPromptText("05*********");
			GridPane.setConstraints(getPhoneinput(),3,0);
			
			GridPane.setConstraints(getRoomlabel(),2,1);
			getRoominput().setPromptText("As 1001");
			GridPane.setConstraints(getRoominput(),3,1);
			//Customer GridPane's OVER
		
		//Column for RoomsTable
		column1.setCellValueFactory(new PropertyValueFactory<>("room"));
		column1.setMinWidth(330); 
		roomsTable.getColumns().add(column1);
		roomsTable.setItems(getAll());
		

		
		//Just To Get Integer Value From TextField
		//Start.
		Restriction restriction=new Restriction();
		restriction.customer();
		//Over
		
		//GridPane Operations
		gridpane.setPadding(new Insets(10,10,10,10));
		gridpane.setVgap(8);
		gridpane.setHgap(10);
		gridpane.setAlignment(Pos.CENTER);
		
		
		//ADD ROOM
		Button addRoom=new Button("Add Room");
		addRoom.getStyleClass().add("button-allButtons");
		addRoom.getStyleClass().add("button:hover-allButtons");
		addRoom.setOnAction(e->{
			if(roomQuery()==true) {
			JOptionPane.showMessageDialog(null, "This Room isn't empty yet");	
			}
			else {
			TxtRoom room=new TxtRoom();
			room.getRoomAddinput().getText();
			
			room.addRoom(room);
				
			roomsTable.getItems().removeAll();
			 roomsTable.setItems(getAll());
			}
		});
		//UPDATE ROOM
		Button updateRoom=new Button("Update Room");
		updateRoom.getStyleClass().add("button-allButtons");
		btnCadd.getStyleClass().add("button:hover-allButtons");
		updateRoom.setOnAction(e->{
			UpdateRoom updateRooms=new UpdateRoom();
			try {
				updateRooms.updateRoom(roomsTable, getRoomAddinput().getText());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			roomsTable.getItems().removeAll();
			 roomsTable.setItems(getAll());
		});
		
		//DELETE ROOM	
		Button deleteRoom=new Button("Delete Room");
		deleteRoom.getStyleClass().add("button-allButtons");
		deleteRoom.getStyleClass().add("button:hover-allButtons");
		deleteRoom.setOnAction(e->{
			DeleteRoom delete=new DeleteRoom();
   			try {
   				if(roomsTable.getSelectionModel().getSelectedItems().isEmpty()){
   					JOptionPane.showMessageDialog(null, "No ROOM to delete was selected","DELETE ROOM",JOptionPane.ERROR_MESSAGE,null);
   				}
   				if(roomsTable.getSelectionModel().isEmpty()==false) {
					ObservableList<RoomEntity> observableList;//Getting the selected value from the table 
					observableList=roomsTable.getSelectionModel().getSelectedItems();//created to get the selected value from the table
					RoomEntity rooms=observableList.get(0);//Created a Room and this Room tooks value that selected
					getRoomAddinput().setText(rooms.getRoom());
				}
				delete.deleteRoom(roomsTable,getRoomAddinput().getText());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
   			roomsTable.getItems().removeAll();
   		 roomsTable.setItems(getAll());
		});
		
		//Add Customer Button
		Button btnACustomer=new Button("ADD CUSTOMER");
		btnACustomer.getStyleClass().add("button-allButtons");
		btnACustomer.getStyleClass().add("button:hover-allButtons");
		GridPane.setConstraints(btnACustomer,1,7);
		btnACustomer.setOnAction(e->{
			TxtCustomer customer=new TxtCustomer();
			customer.getNameinput().getText();
			customer.getSurnameinput().getText();
			customer.getIdinput().getText();
			customer.getPhoneinput().getText();
			customer.getRoominput().getText();
			customer.getPricefield();
			customer.getGenderfield();
			
			customer.addCustomer(customer);
			
			roomsTable.getItems().removeAll();
			 roomsTable.setItems(getAll());
		});
		
		//Adding Buttons,Labels and TextFields to GridPane
		gridpane.getChildren().addAll(getNamelabel(),getNameinput(),getSurnamelabel()
				,getSurnameinput(),getIdlabel(),getIdinput(),getPhonelabel(),getPhoneinput(),
				getRoomlabel(),getRoominput(),getPricefieldAdd(),getGenderfield(),
				btnACustomer,getWarningMessage());
		
		getNamelabel().setId("content_label");
		getSurnamelabel().setId("content_label");
		getIdlabel().setId("content_label");
		getPhonelabel().setId("content_label");
		getRoomlabel().setId("content_label");
		getWarningMessage().setId("content_label");
		
		BorderPane border2=new BorderPane();		
		//Room Tableand Operations Screen
		BorderPane borderRoom=new BorderPane(); borderRoom.setId("cst-border-table-style");
		
		VBox vcenter=new VBox();
		HBox hBoxCenter=new HBox();
		HBox hBoxbottom=new HBox();
		vcenter.getChildren().addAll(roomsTable,hBoxCenter,hBoxbottom);
		hBoxCenter.getChildren().addAll(getRoomAddlabel(),getRoomAddinput());
		getRoomAddlabel().setId("content_label");
		hBoxbottom.getChildren().addAll(addRoom,updateRoom,deleteRoom); // Room Buttons
		borderRoom.setLeft(vcenter);
		//OVER
		
		vmenu.getChildren().addAll(btnCadd,btnOperations,btnExit,btninfoepmloyer);
		root.getChildren().addAll(border);
		border.setLeft(vmenu);
		border.setCenter(root2);
		root2.getChildren().addAll(topmenu,border2);
		topmenu.getChildren().addAll(hboxtop);
		hboxtop.getChildren().addAll(btninfouser,i2name);
		
		
		border2.setLeft(gridpane);
		border2.setCenter(borderRoom);
		
		Scene addcst=new Scene(root,1200,800);
		root.setId("root_add_epmloyer");
		vmenu.setId("vmenu");
		vmenu.setPrefSize(232, 800);
		addcst.getStylesheets().add(getClass().getResource("/application/style.css").toExternalForm());
		addcst.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
		
		stage.setScene(addcst);	
		stage.show();
	}
}
