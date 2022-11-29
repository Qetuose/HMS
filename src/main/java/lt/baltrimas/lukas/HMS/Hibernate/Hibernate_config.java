package lt.baltrimas.lukas.HMS.Hibernate;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import lt.baltrimas.lukas.HMS.Customer;
import lt.baltrimas.lukas.HMS.Room;


public class Hibernate_config 
{
	
	Customer customer = new Customer();
	Room room = new Room();
	      	

	Configuration conf = new Configuration().configure().addAnnotatedClass(Customer.class).addAnnotatedClass(Room.class);
	ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();


    SessionFactory sf = conf.buildSessionFactory(sr);

    Session session = sf.openSession();

	
	public void saveCustomer(	int id, String first_name, String last_name, String phone, String email, 
										String country, String city, String adress, Room room)
	{
		session.beginTransaction();				
		
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
	       

	    session.getTransaction().commit();	    
	}
	
	public Customer fetchCustomer (int id)
	{			
		customer = (Customer)session.get(Customer.class, id);
		
		return customer;
	}
	
	public void saveRoom (int roomNum, String type, boolean isAvaible, boolean isClean, Customer customer)
	{		
		session.beginTransaction();
		
		room.setRoomNumber(roomNum);
		room.setType(type);
		room.setIsAvaible(isAvaible);
		room.setIsClean(isClean);
		
		session.persist(room);
		
	    session.getTransaction().commit();	
	}
	
	
	public Room fetchRoom (int roomNum)
	{		
		
		room = (Room)session.get(Room.class, roomNum);
		
		return room;
	}
	
	public List<Customer> getCustomerList()
	{
		session.beginTransaction();
		
		String hql = "from Customer";
		Query<Customer> q = session.createQuery(hql, Customer.class);
		List<Customer> customer = q.list();
		   
		for(Customer c : customer)
		{
		  System.out.println(c);
		}

	    session.getTransaction().commit();

		return customer;
	}
	
	public List<Room> getRoomList()
	{
		session.beginTransaction();
		
		String hql = "from Room";
		Query<Room> q = session.createQuery(hql, Room.class);
		List<Room> room = q.list();
		   
		for(Room r : room)
		{
		  System.out.println(r);
		}

	    session.getTransaction().commit();

		return room;
	}
}
