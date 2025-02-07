package IN.IS.SHIVAM;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java .sql.Connection;
import java .sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/loging")
public class cheak extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		String name1=req.getParameter("name");
		String pass1=req.getParameter("pass");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/compani_db","root","Dolly@1234");
		PreparedStatement ps=con.prepareStatement("select * from EMP2 where  name=? and pass =?");      
		ps.setString(1,name1);  
    	ps.setString(2,pass1);
		ResultSet rs = ps.executeQuery();
   
        
        if (rs.next())
        	resp.sendRedirect("welcome.jsp");
        else 
        	resp.sendRedirect("ragistration.jsp");
		}
		
	
	catch(Exception e) {
		e.printStackTrace();
		out.print("error");
	}

	}
}
