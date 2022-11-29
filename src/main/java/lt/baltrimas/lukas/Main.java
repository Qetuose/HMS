package lt.baltrimas.lukas;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Main extends HttpServlet
{
	private static final long serialVersionUID = -3357003738985828502L;

	public static void main( String[] args )
    {
		
    }
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		
		int k = j + i;
		k = k*k;
		
		req.setAttribute("k", k);
		
		RequestDispatcher rd = req.getRequestDispatcher("sq");
		rd.forward(req, res);
	}
}
