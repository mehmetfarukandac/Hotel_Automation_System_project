package operations;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import addOperation.AddEmployee;
import employerMenu.EmployerInfo;
import employerMenu.statistics;
import entity.EmployeeEntity;
import entity.JavafxEntity;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import oUpdateDelete.DeleteEmployee;
import oUpdateDelete.UpdateEmployee;

 public class 	EmployeeOperations extends Application {
	//EMPLOYEE arama Search için getSearch methodu
	 public ObservableList<EmployeeEntity> getSearch(TextField search, TableView<EmployeeEntity> table) throws IOException {
	        ObservableList<EmployeeEntity> list = FXCollections.observableArrayList();
	    	if(search.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "SEARCH field is Empty","SEARCH",JOptionPane.ERROR_MESSAGE,null);
			}
	        File fileInfo = new File("users.txt");
	        Scanner reader = new Scanner(fileInfo);
	        while (reader.hasNextLine()) {
	        	String name=reader.nextLine();
	            String surname=reader.nextLine();
	            String perm=reader.nextLine();
	            String username=reader.nextLine();
	            String password=reader.nextLine();
	            String date=reader.nextLine();
	            if (name.toUpperCase().trim().contains(search.getText().trim().toUpperCase()) || surname.toUpperCase().trim().contains(search.getText().trim().toUpperCase()) || username.toUpperCase().trim().contains(search.getText().trim().toUpperCase())) {
	                list.add(new EmployeeEntity(name, surname, perm,username,password,date));
	            }
	        }
	        if (search.getText().trim().length() == 0) {
	            table.setItems( getAll());
	        }
	        reader.close();
	        return list;
	    }
	 //TABLOYA VERÝLERÝ GETÝRMEK ÝÇÝN getAll METHODU
	 public ObservableList<EmployeeEntity> getAll() {
		 ObservableList<EmployeeEntity> list=FXCollections.observableArrayList();
		 File file=new File("users.txt");
	        try {
	            Scanner reader=new Scanner(file);
	            while(reader.hasNextLine()){
	            String name=reader.nextLine();
	            String surname=reader.nextLine();
	            String perm=reader.nextLine();
	            String username=reader.nextLine();
	            String password=reader.nextLine();
	            String date=reader.nextLine();
	           list.add(new EmployeeEntity(name,surname,perm,username,password,date));
	            }
	            reader.close();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
			return list;
	 }
	  
	 @Override 
	 public void start(Stage stage) throws IOException {
		 //Ekranýn sað üst köþesine bir Label koyup,giriþ yapan kiþinin username bilgisini çekme
		 String username;
		 //Employee/Employer'a hazýrlanan Combobox için bilgilendirme Label'ý
		 Label lEmployee=new Label();
			lEmployee.setText("1-Employee\n5-Employer");
			lEmployee.getStyleClass().add("label-lEmployee");
		 
		 
		 File Username =new File("username.txt");
			Scanner reader=new Scanner(Username);
			username=reader.nextLine();
			reader.close();
			
			 StackPane root=new StackPane();
			 BorderPane border=new BorderPane();
			 VBox vmenu=new VBox();
			 Button btnEadd=new Button(""); 		btnEadd.setId("menubutons");
			 Button btnOperations=new Button(""); 	btnOperations.setId("menubutons");
			 Button btnStatistics=new Button(""); 	btnStatistics.setId("menubutons");
			 Button btnExit=new Button(""); 		btnExit.setId("menubutons");
		 
			// Top menu info labels
			Label i2name=new Label(username);	i2name.setId("top_menu_label");
			Button btninfouser=new Button(); btninfouser.setId("top_user_icon");
			HBox hboxtop=new HBox(); hboxtop.setId("hboxtop-style");
			HBox topmenu=new HBox();				topmenu.setId("stat_top_menu");	
			Button btninfoepmloyee=new Button(""); btninfoepmloyee.setId("info_btn");
			topmenu.setAlignment(Pos.TOP_LEFT);
		 // LEFT MENU BUTONS----
			AddEmployee cList=new AddEmployee();
			btnEadd.setOnAction(e->{
				try {
					cList.start(stage);
		        } catch (Exception e1) {
		            e1.printStackTrace();
		        }
			});
			//OPERASYONLAR ALANINI AKTÝF ETME BUTONU
			btnOperations.setOnAction(e->{
			EmployeeOperations ced=new EmployeeOperations();	
					try {
						ced.start(stage);
			        } catch (Exception e1) {
			            e1.printStackTrace();
			        }
				});
			//ÝSTATÝSTÝKLER ALANINI AKTÝF ETME BUTONU
			btnStatistics.setOnAction(e->{
				statistics stats=new statistics();
				try {
					stats.start(stage);
		        } catch (Exception e1) {
		            e1.printStackTrace();
		        }
			});
			btnExit.setOnAction(e->{
				 stage.close();	 
			});
			btninfoepmloyee.setOnAction(e->{
				EmployerInfo infoscreen=new EmployerInfo();
				infoscreen.start();
			});
		 // LEFT MENU BUTONS____

		 TableView<EmployeeEntity> table = new TableView<EmployeeEntity>(); //TABLO OLUÞTURULDU
		 JavafxEntity javafxEntity=new JavafxEntity();
		 ComboBox<String> permissionCombo=new ComboBox<String>();
		 permissionCombo.getItems().addAll("1","5");
		 permissionCombo.setPromptText("PERMÝSSÝON");
		 javafxEntity.getGenderfield().getItems().addAll("FEMALE","MALE");
		 javafxEntity.getGenderfield().setPromptText("GENDER");
		 
		//TableColumn
			//START
		 	table.setId("tablestyle");
		 	table.setEditable(false);
		 	//table.maxWidth(460);
			TableColumn<EmployeeEntity,String> column1 = new TableColumn<>("First Name");
			column1.setCellValueFactory(new PropertyValueFactory<>("firstName"));
			column1.setMinWidth(100); 
			TableColumn<EmployeeEntity,String> column2 = new TableColumn<>("Last Name");
			column2.setCellValueFactory(new PropertyValueFactory<>("lastName"));
			column2.setMinWidth(100);
			TableColumn<EmployeeEntity,String> column3 = new TableColumn<>("Permission");
			column3.setCellValueFactory(new PropertyValueFactory<>("permition"));
			column3.setMinWidth(110);
			TableColumn<EmployeeEntity,String> column4 = new TableColumn<>("Username");
			column4.setCellValueFactory(new PropertyValueFactory<>("username"));
			column4.setMinWidth(110);
			TableColumn<EmployeeEntity,String> column5 = new TableColumn<>("Password");
			column5.setCellValueFactory(new PropertyValueFactory<>("password"));
			column5.setMinWidth(100);
			TableColumn<EmployeeEntity,String> column6 = new TableColumn<>("Checkin");
			column6.setCellValueFactory(new PropertyValueFactory<>("checkin"));
			column6.setMinWidth(150); 
			//OVER
			//TAKÝNG COLUMN TO TABLE
			table.getColumns().addAll(column1,column2,column3,column4,column5,column6);
			table.setItems(getAll());//VERÝLER TABLOYA ALINDI
			
			javafxEntity.getNamelabel().getStyleClass().add("welcome-text-alltext");
			javafxEntity.getSurnamelabel().getStyleClass().add("welcome-text-alltext");
			javafxEntity.getUsernamelabel().getStyleClass().add("welcome-text-alltext");
			javafxEntity.getPasswordlabel().getStyleClass().add("welcome-text-alltext");
			
			
			
			
			//tablodan seçilen deðerleri textfieldlara yerleþtiren btninfo butonu
			Button btninfo=new Button("GET INFO");
			btninfo.getStyleClass().add("button-allButtons");
			btninfo.getStyleClass().add("button:hover-allButtons");
			btninfo.setOnAction(e->{
				if(table.getSelectionModel().isEmpty()==false) {
				ObservableList<EmployeeEntity> observableList;//Getting the selected value from the table 
				observableList=table.getSelectionModel().getSelectedItems();//created to get the selected value from the table
				EmployeeEntity employee=observableList.get(0);//Created a Employee and this Employee took value that selected
				javafxEntity.getNameinput().setText(employee.getFirstName());
				javafxEntity.getSurnameinput().setText(employee.getLastName());
				javafxEntity.getUsernameinput().setText(employee.getUsername());
				javafxEntity.getPasswordinput().setText(employee.getPassword());
				}
				else {
					JOptionPane.showMessageDialog(null, "please select an Employee","GET INFO",JOptionPane.INFORMATION_MESSAGE,null);
				}
			});

			//SEARCH ALANI
			TextField tfSeacrh=new TextField ();
       		tfSeacrh.setPromptText("search");
       		Button btnBvalue=new Button("BACK VALUE");
       		btnBvalue.getStyleClass().add("button-allButtons");
       		btnBvalue.getStyleClass().add("button:hover-allButtons");
       		btnBvalue.setOnAction(E->{
       			table.setItems( getAll());	
       		});
       		//SEARCH BUTONU
       		Button btnSearch=new Button(""); btnSearch.setId("Search");
       		btnSearch.getStyleClass().add("button-allButtons");
       		btnSearch.getStyleClass().add("button:hover-allButtons");
       		btnSearch.setOnAction(e->{
       		try {
				ObservableList<EmployeeEntity> list=getSearch(tfSeacrh,table);
				table.setItems(list);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
       		
       		});
			
			//Button Actions
			//STARTss
			//UPDATE  BUTTON
			Button btnUpdate=new Button("UPDATE");
			btnUpdate.getStyleClass().add("button-allButtons");
			btnUpdate.getStyleClass().add("button:hover-allButtons");
			btnUpdate.setOnAction(e->{
				UpdateEmployee update=new UpdateEmployee();
				try {
					update.updateUser(table,javafxEntity.getNameinput(),javafxEntity.getSurnameinput(),permissionCombo
							,javafxEntity.getUsernameinput(),javafxEntity.getPasswordinput());
					 table.getItems().removeAll();
						table.setItems(getAll());
       			} catch (IOException e1) {
					e1.printStackTrace();
				}
			});
			//DELETE BUTTON
			Button btnDelete=new Button("DELETE");
			btnDelete.getStyleClass().add("button-allButtons");
			btnDelete.getStyleClass().add("button:hover-allButtons");
			btnDelete.setOnAction(e->{
				if(table.getSelectionModel().isEmpty()==false) {
					ObservableList<EmployeeEntity> observableList;//Getting the selected value from the table 
					observableList=table.getSelectionModel().getSelectedItems();//created to get the selected value from the table
					EmployeeEntity employee=observableList.get(0);//Created a Employee and this Employee took value that selected
				javafxEntity.getNameinput().setText(employee.getFirstName());
				javafxEntity.getSurnameinput().setText(employee.getLastName());
				javafxEntity.getUsernameinput().setText(employee.getUsername());
				javafxEntity.getPasswordinput().setText(employee.getPassword());
				}
       			DeleteEmployee delete=new DeleteEmployee();
       			try {
					delete.deleteUser(table,javafxEntity.getUsernameinput());
					 table.getItems().removeAll();
						table.setItems(getAll());
       			} catch (IOException e1) {
					e1.printStackTrace();
				}
       		});
				//BUTTON ACTÝONS OVER
			 
				VBox vboxL=new VBox();
				vboxL.getStyleClass().add("root-scene-C-E");
				vboxL.getChildren().addAll( 
						javafxEntity.getNamelabel(),
						 javafxEntity.getNameinput(),
						 javafxEntity.getSurnamelabel(),
						 javafxEntity.getSurnameinput(),
						 javafxEntity.getUsernamelabel(),
						 javafxEntity.getUsernameinput(),
						 javafxEntity.getPasswordlabel(),
						 javafxEntity.getPasswordinput(),
						 permissionCombo,lEmployee
			 );
				//Label Style
				javafxEntity.getNamelabel().setId("content_label");
				javafxEntity.getSurnamelabel().setId("content_label");
				javafxEntity.getUsernamelabel().setId("content_label");
				javafxEntity.getPasswordlabel().setId("content_label");
				//Label Style End
			 HBox hbox=new HBox();
			hbox.getChildren().addAll(btninfo,btnUpdate,btnDelete);
			StackPane root2=new StackPane(); root2.setId("center-root2-style");
			BorderPane border2=new BorderPane(); border2.setId("opr-border-style");
			HBox hboxTop=new HBox();
			hboxTop.getChildren().addAll(tfSeacrh,btnSearch,btnBvalue);
			
			root.getChildren().addAll(border);
			
			border2.setBottom(hbox);
			border2.setCenter(table);
			border2.setLeft(vboxL);
			border2.setTop(hboxTop);
			
			vmenu.getChildren().addAll(btnEadd,btnOperations,btnStatistics,btnExit,btninfoepmloyee);
			border.setLeft(vmenu); //Left Menu
			border.setCenter(root2);//Center Content
			topmenu.getChildren().addAll(hboxtop);//Center Content Top info
			hboxtop.getChildren().addAll(btninfouser,i2name);
			
			root2.getChildren().addAll(topmenu,border2);
			
	 Scene scene = new Scene(root, 1200, 800);
	 root.setId("root_yonetici_operations");
		vmenu.setId("vmenu");
		vmenu.setPrefSize(232, 800);
		scene.getStylesheets().add(getClass().getResource("/application/style.css").toExternalForm());
scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
	 stage.setScene(scene); // Place the scene in t he window
	 stage.show(); // Display the window
	 }
}