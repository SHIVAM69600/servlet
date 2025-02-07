package IN.IS.SHIVAM;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/abc")
public class Having extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		 PrintWriter out=resp.getWriter();
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/compani_db","root","Dolly@1234");
		        Statement  ps= con.createStatement();
		       ResultSet rs= ps.executeQuery("select salary from emp3"
		       		+ "order by salary desc ");
		        out.println("<html><body>");
		        out.println("<h2>order by<h2>");
		        out.println("<table border ='1'>");
		        out.println("<tr><th>salary</th></tr>");
		        
		     while(rs.next()) {
		    	double salary1=   rs.getDouble("salary");
		    	
		    	out.println("<tr><td>"+salary1+"</td></tr>");
		}
		 }
		 
		 catch(Exception e) {
			e.printStackTrace();
			out.println("eror");
	}
	  }
	   }
    
	

