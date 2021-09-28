package entity;

import javafx.beans.property.SimpleStringProperty;

public class CustomerEntity {
	//Attribute | Field
	    private final SimpleStringProperty firstName;
	    private final SimpleStringProperty lastName;
	    private final SimpleStringProperty identity;
	    private final SimpleStringProperty phone; 
	    private final SimpleStringProperty room;
	    private final SimpleStringProperty price;
	    private final SimpleStringProperty checkin;
	    private final SimpleStringProperty gender;
	   

		//constructor without parameters
	    public CustomerEntity(){
	    	this.price = new SimpleStringProperty();
	    	this.firstName = new SimpleStringProperty();
			this.lastName = new SimpleStringProperty();
			this.identity = new SimpleStringProperty();
			this.phone = new SimpleStringProperty();
			this.room = new SimpleStringProperty();
			this.checkin = new SimpleStringProperty();
			this.gender = new SimpleStringProperty();
	    }
	  //constructor with parameters
	    public CustomerEntity(String fName, String lName, String id,String phone,String room,String gender,String checkin,String price) {
			this.firstName = new SimpleStringProperty(fName);
	        this.lastName = new SimpleStringProperty(lName);
	        this.identity = new SimpleStringProperty(id);
	        this.phone = new SimpleStringProperty(phone);
	        this.room = new SimpleStringProperty(room);
	        this.price = new SimpleStringProperty(price);
	        this.gender = new SimpleStringProperty(gender);
	        this.checkin=new SimpleStringProperty(checkin);
	    }
		//Getter & Setter
	    //FirstName
	    public String getFirstName() {
	        return firstName.get();
	    }
	    public void setFirstName(String fName) {
	        firstName.set(fName);
	    }
	    //LastName    
	    public String getLastName() {
	        return lastName.get();
	    }
	    public void setLastName(String fName) {
	        lastName.set(fName);
	    }
	    //ID
	    public String getIdentity() {
	    	return identity.get();
	    }
	    public void setIdentity(String fName) {
	    	identity.set(fName);
	    }
	    //PHONE
	    public String getPhone() {
	    	return phone.get();
	    }
		public void setCount(String fName) {
			phone.set(fName);
	    }
	    //ROOM
	    public String getRoom() {
	    	return room.get();
	    }
	    public void setRoom(String fName) {
	    	room.set(fName);
	    }
	    //Gender 
	    public String getGender() {
	    	return gender.get();
	    }
	    public void setGender(String fName) {
	    	gender.set(fName);
	    }
	    //Check-in
	    public String getCheckin() {
	    	return checkin.get();
	    }
	    public void setCheckin(String fName) {
	    	checkin.set(fName);
	    }
	    public String getPrice() {
			return price.get();
		}
		  public void setPrice(String fName) {
		    	price.set(fName);
		    }
}
