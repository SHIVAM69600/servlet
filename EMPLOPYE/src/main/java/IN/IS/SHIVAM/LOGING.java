 package IN.IS.SHIVAM;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/SHIVAM",name="LOGING")
public class LOGING extends HttpServlet
{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String myname=req.getParameter("name");
	String mypass=req.getParameter("pass");
	
	System.out.println("ok shivam done");
	PrintWriter out=resp.getWriter();
	out.println("name:"+myname);
	out.println("pass:"+mypass);
	resp.sendRedirect("ragistration.jsp");
	}

}
