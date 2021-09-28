package entity;

import javafx.beans.property.SimpleStringProperty;

public class EmployeeEntity {
	  //Attribute | Field
    private final SimpleStringProperty firstName;
    private final SimpleStringProperty lastName;
    private final SimpleStringProperty username;
    private final SimpleStringProperty password;
    private final SimpleStringProperty permition;
    private final SimpleStringProperty checkin;

	//constructor without parameters
    public EmployeeEntity() {
		this.checkin = new SimpleStringProperty();
		this.username = new SimpleStringProperty();
		this.password = new SimpleStringProperty();
		this.lastName = new SimpleStringProperty();
		this.permition = new SimpleStringProperty();
		this.firstName = new SimpleStringProperty();
    }
  //constructor with parameters
    public EmployeeEntity(String FName, String lName, String permition,String username, String password,String checkin) {

		this.checkin = new SimpleStringProperty(checkin);
		this.firstName = new SimpleStringProperty(FName);
        this.lastName = new SimpleStringProperty(lName);
        this.permition = new SimpleStringProperty(permition);
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
    }
  //Getter & Setter
     //FirstName
    public String getFirstName() {
        return firstName.get();
    }
    public void setFirstName(String FName) {
        firstName.set(FName);
    }
    //LastName    
    public String getLastName() {
        return lastName.get();
    }
    
    public void setLastName(String FName) {
        lastName.set(FName);
    }

	public String getUsername() {
		return username.get();
	}
	
	public void setUsername(String FName) {
		username.set(FName);
    }
	
	public String getPassword() {
		return password.get();
	}
	
	public void setPassword(String FName) {
		password.set(FName);
    }
	
	public String getPermition() {
		return permition.get();
	}
	public void setPermition(String FName) {
		permition.set(FName);
    }

	public String getCheckin() {
		return checkin.get();
	}
	
	public void setCheckin(String FName) {
		checkin.set(FName);
    }
}