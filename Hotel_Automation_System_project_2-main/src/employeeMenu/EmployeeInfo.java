package employeeMenu;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class EmployeeInfo {

	public void start() {
		Stage stage=new Stage();
		stage.getIcons().add(new Image("file:image/info_icon.png"));
		stage.setTitle("Employee Info");
		BorderPane rootborder=new BorderPane();
		BorderPane border2=new BorderPane();
		border2.setStyle("fx-padding:0px 0px 0px 0px");
		Button exit=new Button("EXIT"); exit.setId("info-exit");
		exit.setStyle("-fx-pref-height: 50px; -fx-pref-width:100px;");
		exit.setOnAction(e->stage.close());
		
		stage.initStyle(StageStyle.UNDECORATED); 
		stage.setX(1498);
		stage.setY(140);
		rootborder.setBottom(border2);
		border2.setCenter(exit);
		Scene scene = new Scene(rootborder, 400, 800);
		stage.setResizable(false);
		stage.setScene(scene);
		rootborder.setId("Employeeinfo-style");
		scene.getStylesheets().add(getClass().getResource("/application/style.css").toExternalForm());
		stage.show();
	}
}
