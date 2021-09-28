package operations;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import addOperation.AddCustomer;
import employeeMenu.EmployeeInfo;
import entity.CustomerEntity;
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
import oUpdateDelete.DeleteCustomer;
import oUpdateDelete.UpdateCustomer;

public class CustomerOperations extends Application {
	 public ObservableList<CustomerEntity> getSearch(TextField search, TableView<CustomerEntity> table) throws IOException {
	        ObservableList<CustomerEntity> list = FXCollections.observableArrayList();
	    	if(search.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "SEARCH field is Empty","SEARCH",JOptionPane.ERROR_MESSAGE,null);
			}
	        File fileInfo = new File("Customer.txt");
	        Scanner reader = new Scanner(fileInfo);
	        while (reader.hasNextLine()) {
	        	String name=reader.nextLine();
	            String surname=reader.nextLine();
	            String id=reader.nextLine();
	            String phonenum=reader.nextLine();
	            String roomnum=reader.nextLine();	            
	            String gender=reader.nextLine();
	            String date=reader.nextLine();
	            String price=reader.nextLine();
	            if (name.toUpperCase().trim().contains(search.getText().trim().toUpperCase()) || surname.toUpperCase().trim().contains(search.getText().trim().toUpperCase()) || id.toUpperCase().trim().contains(search.getText().trim().toUpperCase())) {
	                list.add(new CustomerEntity(name, surname, id,phonenum,roomnum,gender,date,price));
	            }
	        }
	        if (search.getText().trim().length() == 0) {
	            table.setItems( getAll());
	        }
	        reader.close();
	        return list;
	    }
//tabloya verileri çekmek için getAll methodu
	 public ObservableList<CustomerEntity> getAll()  {
		 ObservableList<CustomerEntity> list=FXCollections.observableArrayList();
			File file=new File("Customer.txt");
	        try {
	            Scanner reader=new Scanner(file);
	            while(reader.hasNextLine()){
		            String name=reader.nextLine();
		            String surname=reader.nextLine();
		            String id=reader.nextLine();
		            String phonenum=reader.nextLine();
		            String roomnum=reader.nextLine();
		            String gender=reader.nextLine();
		            String date=reader.nextLine();
		            String price=reader.nextLine();
		            list.add(new CustomerEntity(name,surname,id,phonenum,roomnum,gender,date,price));      
	            }
	            reader.close();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace(); 
	        }
	        return list; 
	 }
	 
	 @Override // Override the start method in the Application class
	 public void start(Stage stage) throws IOException {
		 String username;
		 File Username =new File("username.txt");
			Scanner reader=new Scanner(Username);
			username=reader.nextLine();
			reader.close();
		TableView<CustomerEntity> table = new TableView<CustomerEntity>();
		 ComboBox<String> genderfield=new ComboBox<String>();
		 ComboBox<String> priceCombo=new ComboBox<String>();
		 
		 	StackPane root=new StackPane();
			BorderPane border=new BorderPane();
			VBox vmenu=new VBox();
			Button btnEadd=new Button(""); 		btnEadd.setId("menubutons");
			Button btnOperations=new Button(""); 	btnOperations.setId("menubutons");
			Button btnExit=new Button(""); 		btnExit.setId("menubutons");
			Button btninfoepmloyer=new Button(""); btninfoepmloyer.setId("info_btn");
			
			// Top menu info labels
			Label i2name=new Label(username);	i2name.setId("top_menu_label");
			Button btninfouser=new Button(); btninfouser.setId("top_user_icon");
			HBox hboxtop=new HBox(); hboxtop.setId("hboxtop-style");
			
			HBox topmenu=new HBox();				topmenu.setId("stat_top_menu");	
			topmenu.setAlignment(Pos.TOP_LEFT);
		 // LEFT MENU BUTONS----
			btnEadd.setOnAction(e->{
				AddCustomer add=new AddCustomer();
				try {
					add.start(stage);
		        } catch (Exception e1) {
		            e1.printStackTrace();
		        }
			});
			//operasyonlar ekraný için btnOperations butonu
			btnOperations.setOnAction(e->{
			CustomerOperations ced=new CustomerOperations();	
					try {
						ced.start(stage);
			        } catch (Exception e1) {
			            e1.printStackTrace();
			        }
				});
			btnExit.setOnAction(e->{
				 stage.close();	 
			});
			
			//INFO BUTTON
			btninfoepmloyer.setOnAction(e->{
				EmployeeInfo infoscreen=new EmployeeInfo();
				infoscreen.start();
			});
		 // LEFT MENU BUTONS____
		 stage.setTitle("LÝST SCREEN");
		
		 CustomerOpRestriction customerOpRestriction=new CustomerOpRestriction(); //OPERASYONLAR KISMINDAKÝ TEXTFÝELDLAR ÝÇÝN TANIMLANAN ÖZELLÝKLER Classý
		 customerOpRestriction.customerOp();
		 
		 JavafxEntity javafxEntity=new JavafxEntity();//JavafxEntity Çaðýrýldý ve comboboxlara özellikleri tanýmlandý 
		 priceCombo.getItems().addAll("200","350","500");//*
		 priceCombo.setPromptText("PRÝCE");//*
		 genderfield.getItems().addAll("FEMALE","MALE"); //*
		 genderfield.setPromptText("GENDER");//*
		 
			//TableColumn
			//START
		 table.setId("tablestyle");
			table.setEditable(true);
		 TableColumn<CustomerEntity,String> column1 = new TableColumn<>("First Name");
			column1.setCellValueFactory(new PropertyValueFactory<>("firstName"));
			column1.setMinWidth(80); 
			TableColumn<CustomerEntity,String> column2 = new TableColumn<>("Last Name");
			column2.setCellValueFactory(new PropertyValueFactory<>("lastName"));
			column2.setMinWidth(80); 
			TableColumn<CustomerEntity,String> column3 = new TableColumn<>("ID");
			column3.setCellValueFactory(new PropertyValueFactory<>("identity"));
			column3.setMinWidth(80); 
			TableColumn<CustomerEntity,String> column4 = new TableColumn<>("Phone Number");
			column4.setCellValueFactory(new PropertyValueFactory<>("phone"));
			column4.setMinWidth(80); 
			TableColumn<CustomerEntity,String> column5 = new TableColumn<>("Room");
			column5.setCellValueFactory(new PropertyValueFactory<>("room"));
			column5.setMinWidth(80); 
			TableColumn<CustomerEntity,String> column6 = new TableColumn<>("Gender");
			column6.setCellValueFactory(new PropertyValueFactory<>("gender"));
			column6.setMinWidth(80); 
			TableColumn<CustomerEntity,String> column7 = new TableColumn<>("Check-in");
			column7.setCellValueFactory(new PropertyValueFactory<>("checkin"));
			column7.setMinWidth(80); 
			TableColumn<CustomerEntity,String> column8 = new TableColumn<>("Price");
			column8.setCellValueFactory(new PropertyValueFactory<>("price"));
			column8.setMinWidth(80); 
			//OVER
			//TAKÝNG COLUMN TO TABLE
			table.getColumns().addAll(column1,column2,column3,column4,column5,column6,column7,column8);
			table.setItems(getAll());//VERÝLER TABLOYA ALINDI
			
			
			javafxEntity.getNameL().getStyleClass().add("welcome-text-alltext");
			javafxEntity.getSurnameL().getStyleClass().add("welcome-text-alltext");
			javafxEntity.getIdL().getStyleClass().add("welcome-text-alltext");
			javafxEntity.getPhoneL().getStyleClass().add("welcome-text-alltext");
			javafxEntity.getRoomL().getStyleClass().add("welcome-text-alltext");
			
			
	        
			//BUTTON ACTÝONS START HERE
	       		
	       		//tablodan seçilen deðerleri textfieldlara yerleþtiren btninfo butonu
	       		Button btninfo=new Button("GET INFO");
	       		btninfo.getStyleClass().add("button-allButtons");
	       		btninfo.getStyleClass().add("button:hover-allButtons");
				btninfo.setOnAction(e->{
					if(table.getSelectionModel().isEmpty()==false) {
					ObservableList<CustomerEntity> observableList;//Getting the selected value from the table 
					observableList=table.getSelectionModel().getSelectedItems();//created to get the selected value from the table
					CustomerEntity customer=observableList.get(0);//Created a Customer and this Customer took value that selected
					javafxEntity.getTfName().setText(customer.getFirstName());
					javafxEntity.getTfSurname().setText(customer.getLastName());
					javafxEntity.getTfId().setText(customer.getIdentity());
					javafxEntity.getTfPhone().setText(customer.getPhone());
					javafxEntity.getTfRoom().setText(customer.getRoom());
					}
					else {
						JOptionPane.showMessageDialog(null, "please select a Customer","GET INFO",JOptionPane.INFORMATION_MESSAGE,null);
					}
				});
	       		

	       	//UPDATE BUTTON	
	       	 Button btnUpdate=new Button("UPDATE");
	       	 	btnUpdate.getStyleClass().add("button-allButtons");
	       	 	btnUpdate.getStyleClass().add("button:hover-allButtons");
	       		btnUpdate.setOnAction(e->{
	       			CustomerOpQuery customerOpQuery=new CustomerOpQuery();
	       			customerOpQuery.query();
					UpdateCustomer update=new UpdateCustomer();
					try {
						update.updateCustomer(table,javafxEntity.getTfName(),javafxEntity.getTfSurname()
								,javafxEntity.getTfPhone(),javafxEntity.getTfRoom(),priceCombo,genderfield);
						 table.getItems().removeAll();
							table.setItems(getAll());
	       			} catch (IOException e1) {
						e1.printStackTrace(); 
					} 
				});
	       		
	       		//Customer arama ALANI
	       		TextField tfSeacrh=new TextField ();
	       		tfSeacrh.setPromptText("NAME | SURNAME | ID");
	       		//aranan Customerlar tabloya geldikten sonra tüm Customerlarý geri çaðýrma alaný
	       		Button btnBvalue=new Button("BACK VALUE");
	       		btnBvalue.getStyleClass().add("button-allButtons");
	       		btnBvalue.getStyleClass().add("button:hover-allButtons");
	       		btnBvalue.setOnAction(E->{
	       			table.setItems(getAll());	
	       		});
	       	//Customer arama BUTONU
	       		Button btnSearch=new Button("Search"); btnSearch.setId("Search");
	       		btnSearch.getStyleClass().add("button-allButtons");
	       		btnSearch.getStyleClass().add("button:hover-allButtons");
	       		btnSearch.setOnAction(e->{
	       		try {
					ObservableList<CustomerEntity> list=getSearch(tfSeacrh,table);
					table.setItems(list);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
	       		
	       		});
	       		
	       		
				//DELETE BUTONU
	       	 Button btnDelete=new Button("DELETE");
	       	btnDelete.getStyleClass().add("button-allButtons");
	       	btnDelete.getStyleClass().add("button:hover-allButtons");
				btnDelete.setOnAction(e->{
					if(table.getSelectionModel().isEmpty()==false) {
						ObservableList<CustomerEntity> observableList;//Getting the selected value from the table 
						observableList=table.getSelectionModel().getSelectedItems();//created to get the selected value from the table
						CustomerEntity customer=observableList.get(0);//Created a Customer and this Customer took value that selected
						javafxEntity.getTfName().setText(customer.getFirstName());
						javafxEntity.getTfSurname().setText(customer.getLastName());
						javafxEntity.getTfId().setText(customer.getIdentity());
						javafxEntity.getTfPhone().setText(customer.getPhone());
						javafxEntity.getTfRoom().setText(customer.getRoom());
					}
	       			DeleteCustomer delete=new DeleteCustomer();
	       			try {
						delete.deleteCustomer(table,javafxEntity.getTfId());
						 table.getItems().removeAll();
							table.setItems(getAll());
	       			} catch (IOException e1) {
						e1.printStackTrace();
					}
	       		});

	       		table.setEditable(false);
	       		//BUTTON OVER
			
			VBox vboxL=new VBox();
			vboxL.getStyleClass().add("root-scene-C-E");
			vboxL.getChildren().addAll( 
		 javafxEntity.getNameL(),
		 javafxEntity.getTfName(),
		 javafxEntity.getSurnameL(),
		 javafxEntity.getTfSurname(),
		 javafxEntity.getIdL(),
		 javafxEntity.getTfId(),
		 javafxEntity.getRoomL(),
		 javafxEntity.getTfRoom(),
		 javafxEntity.getPhoneL(),
		 javafxEntity.getTfPhone(),
		 priceCombo,
		 genderfield
		 );
			//Label Style
			javafxEntity.getNameL().setId("content_label");
			javafxEntity.getSurnameL().setId("content_label");
			javafxEntity.getSurnameL().setId("content_label");
			javafxEntity.getIdL().setId("content_label");
			javafxEntity.getRoomL().setId("content_label");
			javafxEntity.getPhoneL().setId("content_label");
			//Label Style end
			HBox hboxTop=new HBox();
			hboxTop.getChildren().addAll(tfSeacrh,btnSearch,btnBvalue);
			HBox hbox=new HBox();
			hbox.getChildren().addAll(btninfo,btnUpdate,btnDelete);
			StackPane root2=new StackPane(); root2.setId("center-root2-style");
			BorderPane border2=new BorderPane(); border2.setId("opr-border-style");
			
			root.getChildren().addAll(border);
			
			border2.setBottom(hbox);
			border2.setCenter(table);
			border2.setLeft(vboxL);
			border2.setTop(hboxTop);
			
			vmenu.getChildren().addAll(btnEadd,btnOperations,btnExit,btninfoepmloyer);
			border.setLeft(vmenu); //Left Menu
			border.setCenter(root2);//Center Content
			root2.getChildren().addAll(topmenu,border2);
			topmenu.getChildren().addAll(hboxtop);
			hboxtop.getChildren().addAll(btninfouser,i2name);
			
			
			 Scene scene = new Scene(root, 1200, 800);
			 root.setId("root_calisan_operations");
				vmenu.setId("vmenu");
				vmenu.setPrefSize(232, 800);
				scene.getStylesheets().add(getClass().getResource("/application/style.css").toExternalForm());
				scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			 stage.setScene(scene); // Place the scene in t he window
			 stage.show(); // Display the window
	 }
}