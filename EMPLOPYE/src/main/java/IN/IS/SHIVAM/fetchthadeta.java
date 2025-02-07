package IN.IS.SHIVAM;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java .sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/ccc")
public class fetchthadeta extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/compani_db","root","Dolly@1234");
		                     Statement st=con.createStatement();
		                     ResultSet rs=st.executeQuery("SELECT p.ProjectName, e.FirstName, e.LastName"
		                    	
		                    		 +" FROM Projects p JOIN EmployeeProjects ep ON p.ProjectID = ep.ProjectID"
		                    		 +" JOIN Employees e ON ep.EmployeeID = e.EmployeeID");

		                    	

		                     out.println("<html><body>");
		                     out.println("<h2>use join</h2>");
		                     out.println("<table border='1'>");
		                     out.println("<tr><th>ProjectName</th><th>FirstName</th><th>LastName</th></tr>");
		                     
		           
		                    
		while(rs.next()) {
			String Projectname1= rs.getString("Projectname");
			String FirstName1=rs.getString("FirstName");
			String LastName1= rs.getString("LastName");
		out.println("<tr><td>"+Projectname1+ "</td><td>"+ FirstName1 +" </td><td>"+ LastName1+"</td></tr>");
		
		}
		out.println("<table>");
		out.println("</body></html>");
		
		}
		catch(Exception e) {
			e.printStackTrace();
			out.print("error");
		}
	}
	

}
