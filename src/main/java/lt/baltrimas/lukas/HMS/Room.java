package lt.baltrimas.lukas.HMS;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Room {
	
	@Id
	private int roomNumber;
	private String type;
	private boolean isAvaible;
	private boolean isClean;
	@ManyToOne
	private Customer customer;
	
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean getIsAvaible() {
		return isAvaible;
	}
	public void setIsAvaible(boolean isAvaible) {
		this.isAvaible = isAvaible;
	}
	public boolean getIsClean() {
		return isClean;
	}
	public void setIsClean(boolean isClean) {
		this.isClean = isClean;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Room [roomNumber=" + roomNumber + ", type=" + type + ", isAvaible=" + isAvaible + ", isClean=" + isClean
				+ "]";
	}
	
	
}
