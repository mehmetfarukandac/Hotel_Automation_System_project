package entity;

public class RoomEntity {
    //Attribute | Field
	 private String room;
		//constructor without parameters
	 public RoomEntity(){
		this.room = new String();
		 
	 }
	  //constructor with parameters
	public RoomEntity(String room){ 
		this.room = room;
		 
	 }
	//Getter & Setter
	public String getRoom() {
		return room;
	}
	 public void setRoom(String room) {
		this.room = room;
	}
}
