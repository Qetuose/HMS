package lt.baltrimas.lukas.HMS.Hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import lt.baltrimas.lukas.HMS.Customer;
import lt.baltrimas.lukas.HMS.Room;


public class Hibernate_config 
{
	
	Customer customer = new Customer();
	Room room = new Room();
	      	
	Configuration config = new Configuration().configure().addAnnotatedClass(Customer.class).addAnnotatedClass(Room.class);
	
	SessionFactory sf = config.buildSessionFactory();
	       
	Session session = sf.openSession();
	
	public void saveCustomer(	int id, String first_name, String last_name, String phone, String email, 
										String country, String city, String adress, Room room)
	{
		
		Transaction tx = session.beginTransaction();				
		
		customer.setId(id);
	    customer.setFirst_name(first_name);
	    customer.setLast_name(last_name);
	    customer.setPhone(phone);
	    customer.setEmail(email);
	    customer.setCountry(country);
	    customer.setCity(city);
	    customer.setAdress(adress);
	    customer.getRoom().add(room);
	    
	    session.persist(customer);
	       
	    tx.commit();
	    
	}
	
	public Customer fetchCustomer (int id)
	{			
		customer = (Customer)session.get(Customer.class, id);
		
		return customer;
	}
	
	public void saveRoom (int roomNum, String type, boolean isAvaible, boolean isClean, Customer customer)
	{		
		Transaction tx = session.beginTransaction();
		
		room.setRoomNumber(roomNum);
		room.setType(type);
		room.setIsAvaible(isAvaible);
		room.setIsClean(isClean);
		room.setCustomer(customer);
		
		session.persist(room);
		
		tx.commit();
		
	}
	
	
	public Room fetchRoom (int roomNum)
	{		
		room = (Room)session.get(Room.class, roomNum);
		
		
		return room;
	}
	
	public List <Room> listOfRooms()
	{
		Query<Room> query = session.createQuery("FROM Room"); 
		
		List<Room> list = query.list();
		
		return list;
	}
}
