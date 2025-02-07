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
	@WebServlet("/raj")
	public class group  extends HttpServlet{



		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			resp.setContentType("text/html");
			PrintWriter out=resp.getWriter();
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/compani_db","root","Dolly@1234");
				       Statement ps= con.createStatement();
				 ResultSet rs=	 ps.executeQuery("select dname , count(emp3_id) As emp3_id"
				 		+ "from emp3 group by dname");
				 out.println("<html><body>");
				 out.println("<h2>grup by</h2>");
				 out.println("<table border='1'>");
				 out.println("<tr><th>dname</th><th>emp3_id</th></tr>");
				 
				  
				 while(rs.next()) {
				 String dname1 =  rs.getString("dname");
				     int emp3_id1 =rs.getInt("emp3_id");
				 out.println("<tr><td>" +dname1+"</td><td>"+emp3_id1+ "</td></tr>");
				 
				 }
				 
			}
			catch(Exception e) {
				e.printStackTrace();
				out.println("error");
			}
		}
		}

