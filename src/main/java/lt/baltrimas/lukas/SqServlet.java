package lt.baltrimas.lukas;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SqServlet extends HttpServlet {

	private static final long serialVersionUID = -9098400339728751303L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		
		int k = (int)req.getAttribute("k");
		
		k = k*k;
		
		PrintWriter out = res.getWriter();
		out.println("asd"+k);
	}
}
