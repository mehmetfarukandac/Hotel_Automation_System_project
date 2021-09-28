package employerMenu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import addOperation.AddEmployee;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import operations.EmployeeOperations;

public class statistics extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		 String username;
		 File Username =new File("username.txt");
			Scanner readr=new Scanner(Username);
			username=readr.nextLine();
			readr.close();
			
			
		StackPane root=new StackPane();
		StackPane root2=new StackPane(); root2.setId("root2");
		// Top menu info labels
		Label i2name=new Label(username);	i2name.setId("top_menu_label");
		Button btninfouser=new Button(); btninfouser.setId("top_user_icon");
		HBox hboxtop=new HBox(); hboxtop.setId("hboxtop-style");
		
		
		BorderPane border=new BorderPane();
		VBox vmenu=new VBox();
		HBox topmenu=new HBox();				topmenu.setId("stat_top_menu");	
		topmenu.setAlignment(Pos.TOP_LEFT);
		Button btnEadd=new Button(""); 			btnEadd.setId("menubutons");
		Button btnOperations=new Button(""); 	btnOperations.setId("menubutons");
		Button btnStatistics=new Button(""); 	btnStatistics.setId("menubutons");
		Button btnExit=new Button(""); 			btnExit.setId("menubutons");
		Button btninfoepmloyee=new Button(""); btninfoepmloyee.setId("info_btn");
		
		 AddEmployee cList=new AddEmployee();
			btnEadd.setOnAction(e->{
				try {
					cList.start(stage);
		        } catch (Exception e1) {
		            e1.printStackTrace();
		        }
			});
			
			
			btnOperations.setOnAction(e->{
			EmployeeOperations ced=new EmployeeOperations();	
					try {
						ced.start(stage);
			        } catch (Exception e1) {
			            e1.printStackTrace();
			        }
				});
			 
			btnStatistics.setOnAction(e->{
				statistics stats=new statistics();
				try {
					stats.start(stage);
		        } catch (Exception e1) {
		            e1.printStackTrace();
		        }
			});
			btninfoepmloyee.setOnAction(e->{
				EmployerInfo infoscreen=new EmployerInfo();
				infoscreen.start();
			});
			GridPane grid=new GridPane(); grid.setId("stat-grid-style");
			
			//----------------------- Customer Query
			int cst_num=0;
			File p=new File("Customer.txt");
			try {
				BufferedReader reader = new BufferedReader(new FileReader(p));
	        	String line;
				while ((line = reader.readLine()) != null) {
	                cst_num++;  
				}
	            reader.close();
	            cst_num=cst_num/8;
	            }catch (FileNotFoundException e) {
		            e.printStackTrace();
		        }

			String cst_number=String.valueOf(cst_num);
			HBox totalcst=new HBox();
			Label cstlabel=new Label("Current Customer: ");cstlabel.setId("stat-label-style");
			Label cstinfo=new Label(cst_number); cstinfo.setId("stat-label-style");
			totalcst.getChildren().addAll(cstlabel,cstinfo);
			//-------------------------- Employee Query
			int usr_num=0;
			File p2=new File("users.txt");
			try {
				BufferedReader reader = new BufferedReader(new FileReader(p2));
	        	String line2;
				while ((line2 = reader.readLine()) != null) {
					usr_num++;  
				}
	            reader.close();
	            usr_num=usr_num/6;
	            }catch (FileNotFoundException e) {
		            e.printStackTrace();
		        }

			String usr_number=String.valueOf(usr_num);
			HBox totalusr=new HBox();
			Label usrlabel=new Label("Current Employee: ");usrlabel.setId("stat-label-style");
			Label usrinfo=new Label(usr_number); usrinfo.setId("stat-label-style");
			totalusr.getChildren().addAll(usrlabel,usrinfo);
			//-------------------------- Room Query
			int room_num=0;
			File p3=new File("Room.txt");
			try {
				BufferedReader reader = new BufferedReader(new FileReader(p3));
	        	String line3;
				while ((line3 = reader.readLine()) != null) {
					room_num++;  
				}
	            reader.close();
	            
	            }catch (FileNotFoundException e) {
		            e.printStackTrace();
		        }
			//###################################################################################
			
			
			//*************
			ObservableList<PieChart.Data> pieChartData =
	                FXCollections.observableArrayList(
	                new PieChart.Data("Empty Room", room_num),
	                new PieChart.Data("Full Room", usr_num)); // müþteri sayýsýna eþit.
	        final PieChart roomchart = new PieChart(pieChartData);
	        roomchart.setTitle("Room Status"); //roomchart.setId("pie_title");
	        
	        File file=new File("Customer.txt");
	        
			Double toplam,bos,oran,ters=1.0;
	        toplam=(double) file.getTotalSpace()/1024/1024/1024;
	        bos=(double) (file.getFreeSpace()/1024/1024/1024);
			oran=((bos*100)/toplam)/100;
			oran=ters-oran;
			
			Label diskspacelabel=new Label("Disk Usage Space:"); diskspacelabel.setId("stat-label-style");
			diskspacelabel.setAlignment(Pos.TOP_CENTER);
			ProgressIndicator pi=new ProgressIndicator();
	        pi.setProgress(oran);
	        pi.setMinWidth(220);
	        pi.setMinHeight(220);
	        VBox diskspacevbox=new VBox();
	        diskspacevbox.getChildren().addAll(diskspacelabel,pi);
	        
			grid.add(totalusr,0,0);
			grid.add(totalcst,1,0);
			grid.add(roomchart,0,1);
			grid.add(diskspacevbox,0,3);
			btnExit.setOnAction(e->{ 	stage.close();	 });
		
		vmenu.getChildren().addAll(btnEadd,btnOperations,btnStatistics,btnExit,btninfoepmloyee);
		root.getChildren().addAll(border);
		border.setLeft(vmenu);
		border.setCenter(root2);
		root2.getChildren().addAll(topmenu,grid);
		topmenu.getChildren().addAll(hboxtop);
		hboxtop.getChildren().addAll(btninfouser,i2name);
		Scene statistics=new Scene(root,1200,800);
		root.setId("root_statistic");
		vmenu.setId("vmenu");
		vmenu.setPrefSize(232, 800);
		statistics.getStylesheets().add(getClass().getResource("/application/style.css").toExternalForm());
		stage.setScene(statistics);	
		stage.show();
		
	}

}
