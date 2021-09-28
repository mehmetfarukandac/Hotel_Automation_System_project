package entity;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class JavafxEntity {
	//ALL TextFields & Labels For All Project
	//ComboBox genderfield
	private static ComboBox<String> genderfield=new ComboBox<String>();
	private static ComboBox<String> pricefieldAdd=new ComboBox<String>();
	
	private  ComboBox<String> pricefield=new ComboBox<String>();
	private  static ComboBox<String> permissionCombo=new ComboBox<String>();
	//CustomerOperations
	//START
	private static TextField tfRoom=new TextField();
	private static TextField tfName=new TextField();
	private static TextField tfSurname=new TextField();
	private static TextField tfId=new TextField();
	private static TextField tfPhone=new TextField();
	
	private static Label nameL= new Label("|NAME");
	private static Label surnameL= new Label("|SURNAME");
	private static Label idL= new Label("|ID");
	private static Label phoneL= new Label("|PHONE NUMBER");
	private static Label roomL= new Label("|ROOM NUMBER");
	//OVER
	
	//TextFields For "AddCustomer"  and "AddEmloyee" Classes
	private static TextField roominput=new TextField();
	private static TextField roomAddinput=new TextField();
	private static TextField nameinput=new TextField();
	private static TextField surnameinput=new TextField();
	private static TextField phoneinput=new TextField();
	private static TextField idinput=new TextField();
	private static TextField passwordinput=new TextField();
	private static TextField usernameinput=new TextField();

	//Labels For "AddCustomer"  and "AddEmloyee" Classes
	private static Label usernamelabel= new Label("|USERNAME");
	private static Label passwordlabel= new Label("|PASSWORD");
	private static Label namelabel= new Label("|NAME");
	private static Label surnamelabel= new Label("|SURNAME");
	private static Label idlabel= new Label("|ID");
	private static Label phonelabel= new Label("|Phone Number");
	private static Label roomlabel= new Label("|Room Number");
	private static Label roomAddlabel= new Label("|Room Number");
	private static Label warningMessage= new Label("|PLEASE FÝLL ÝN THE BLANKS.");
													//|please fill in the blanks according to the rules.
	//Getter & Setter	
	public  TextField getRoominput() {
		return roominput;
	}
	
	public static void setRoominput(TextField roominput) {
		JavafxEntity.roominput = roominput;
	}
	
	public TextField getNameinput() {
		return nameinput;
	}
	
	public static void setNameinput(TextField nameinput) {
		JavafxEntity.nameinput = nameinput;
	}
	
	public TextField getSurnameinput() {
		return surnameinput;
	}
	
	public static void setSurnameinput(TextField surnameinput) {
		JavafxEntity.surnameinput = surnameinput;
	}
	
	public TextField getPhoneinput() {
		return phoneinput;
	}
	
	public static void setPhoneinput(TextField phoneinput) {
		JavafxEntity.phoneinput = phoneinput;
	}
	
	public TextField getIdinput() {
		return idinput;
	}
	
	public static void setIdinput(TextField idinput) {
		JavafxEntity.idinput = idinput;
	}
	
	public TextField getPasswordinput() {
		return passwordinput;
	}
	
	public static void setPasswordinput(TextField passwordinput) {
		JavafxEntity.passwordinput = passwordinput;
	}
	
	public TextField getUsernameinput() {
		return usernameinput;
	}
	
	public static void setUsernameinput(TextField usernameinput) {
		JavafxEntity.usernameinput = usernameinput;
	}
	
	public Label getUsernamelabel() {
		return usernamelabel;
	}
	
	public static void setUsernamelabel(Label usernamelabel) {
		JavafxEntity.usernamelabel = usernamelabel;
	}
	public TextField getTfRoom() {
		return tfRoom;
	}

	public static void setTfRoom(TextField tfRoom) {
		JavafxEntity.tfRoom = tfRoom;
	}

	public TextField getTfName() {
		return tfName;
	}

	public static void setTfName(TextField tfName) {
		JavafxEntity.tfName = tfName;
	}

	public TextField getTfSurname() {
		return tfSurname;
	}

	public static void setTfSurname(TextField tfSurname) {
		JavafxEntity.tfSurname = tfSurname;
	}

	public TextField getTfId() {
		return tfId;
	}

	public static void setTfId(TextField tfId) {
		JavafxEntity.tfId = tfId;
	}

	public TextField getTfPhone() {
		return tfPhone;
	}

	public static void setTfPhone(TextField tfPhone) {
		JavafxEntity.tfPhone = tfPhone;
	}


	public Label getNameL() {
		return nameL;
	}

	public static void setNameL(Label nameL) {
		JavafxEntity.nameL = nameL;
	}

	public Label getSurnameL() {
		return surnameL;
	}

	public static void setSurnameL(Label surnameL) {
		JavafxEntity.surnameL = surnameL;
	}

	public Label getIdL() {
		return idL;
	}

	public static void setIdL(Label idL) {
		JavafxEntity.idL = idL;
	}

	public Label getPhoneL() {
		return phoneL;
	}

	public static void setPhoneL(Label phoneL) {
		JavafxEntity.phoneL = phoneL;
	}


	public Label getRoomL() {
		return roomL;
	}

	public static void setRoomL(Label roomL) {
		JavafxEntity.roomL = roomL;
	}
	
	public Label getPasswordlabel() {
		return passwordlabel;
	}
	
	public static void setPasswordlabel(Label passwordlabel) {
		JavafxEntity.passwordlabel = passwordlabel;
	}
	
	public Label getNamelabel() {
		return namelabel;
	}
	
	public static void setNamelabel(Label namelabel) {
		JavafxEntity.namelabel = namelabel;
	}
	
	public Label getSurnamelabel() {
		return surnamelabel;
	}
	
	public static void setSurnamelabel(Label surnamelabel) {
		JavafxEntity.surnamelabel = surnamelabel;
	}
	
	public Label getIdlabel() {
		return idlabel;
	}
	
	public static void setIdlabel(Label idlabel) {
		JavafxEntity.idlabel = idlabel;
	}

	public Label getPhonelabel() {
		return phonelabel;
	}
	
	public static void setPhonelabel(Label phonelabel) {
		JavafxEntity.phonelabel = phonelabel;
	}
	
	public  Label getRoomlabel() {
		return roomlabel;
	}
	
	public static void setRoomlabel(Label roomlabel) {
		JavafxEntity.roomlabel = roomlabel;
	}
	
	public ComboBox<String> getGenderfield() {
		return genderfield;
	}
	
	public static void setGenderfield(ComboBox<String> genderfield) {
		JavafxEntity.genderfield = genderfield;
	}

	
	public static Label getWarningMessage() {
		return warningMessage;
	}
	
	public static void setWarningMessage(Label warningMessage) {
		JavafxEntity.warningMessage = warningMessage;
	}
	public TextField getRoomAddinput() {
		return roomAddinput;
	}

	public static void setRoomAddinput(TextField roomAddinput) {
		JavafxEntity.roomAddinput = roomAddinput;
	}

	public static Label getRoomAddlabel() {
		return roomAddlabel;
	}

	public static void setRoomAddlabel(Label roomAddlabel) {
		JavafxEntity.roomAddlabel = roomAddlabel;
	}

	public ComboBox<String> getPricefieldAdd() {
		return pricefieldAdd;
	}

	public static void setPricefieldAdd(ComboBox<String> pricefieldAdd) {
		JavafxEntity.pricefieldAdd = pricefieldAdd;
	}

	public ComboBox<String> getPricefield() {
		return pricefield;
	}

	public void setPricefield(ComboBox<String> pricefield) {
		this.pricefield = pricefield;
	}

	public ComboBox<String> getPermissionCombo() {
		return permissionCombo;
	}

	public static void setPermissionCombo(ComboBox<String> permissionCombo) {
		JavafxEntity.permissionCombo = permissionCombo;
	}


}