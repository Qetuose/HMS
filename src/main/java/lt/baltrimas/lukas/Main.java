package lt.baltrimas.lukas;


import lt.baltrimas.lukas.HMS.Hibernate.Hibernate_config;

public class Main
{
	public static void main( String[] args )
    {
		Hibernate_config hc = new Hibernate_config();
		
		hc.setCustomerToRoom(hc.fetchRoom(102), hc.fetchCustomer(3));
		
    }
}
