package lt.baltrimas.lukas.HMS;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lt.baltrimas.lukas.HMS.Hibernate.Hibernate_config;


public class App extends HttpServlet
{
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public static void main( String[] args )
    {
		
   
    }
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		Hibernate_config hc = new Hibernate_config();
		
		Customer cus = hc.fetchCustomer(1);
		
		PrintWriter print = res.getWriter();
		
		print.println(cus);
		
		
	}
	
}
