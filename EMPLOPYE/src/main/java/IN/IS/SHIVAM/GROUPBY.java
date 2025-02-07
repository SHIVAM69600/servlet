package IN.IS.SHIVAM;

import java.io.IOException;
import java.io.PrintWriter;
import java .sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/ooo")
public class GROUPBY  extends HttpServlet{



	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		Connection con=null;
		Statement ps=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/compani_db","root","Dolly@1234");
			        ps= con.createStatement();
			  rs=	 ps.executeQuery("select * from users ");
			
			
			 out.println("<html><body>");
			 out.println("<h2>order by</h2>");
			 out.println("<table border='1'>");
			 out.print("<tr><th>user_id</th><th>name</th><th>city</th><th>age</th></tr>");
			 while(rs.next()) {
				 int user_id1 =  rs.getInt("user_id");
				 String name1=rs.getString("name");
				    String city1= rs.getString("city");
				        int age1 =rs.getInt("age");
			 out.print("<tr><td>" +user_id1+"</td><td>" +name1+"</td><td>"+city1+"</td><td>"+age1+"</td></tr>");
			 
			 }
			 
			 out.println("<table>");
				out.println("</body></html>");
		}
		catch(Exception e) {
			e.printStackTrace();
			out.println("error");
		}finally {
			try { if (rs != null) rs.close(); } catch (Exception e) { e.printStackTrace(); }
            try { if (ps != null) ps.close(); } catch (Exception e) { e.printStackTrace(); }
            try { if (con != null) con.close(); } catch (Exception e) { e.printStackTrace(); }
	}
	}
}

	


