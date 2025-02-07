package IN.IS.SHIVAM;

import java.io.IOException;

import java .io.PrintWriter;
import java.sql.DriverManager;
import java .sql.Connection ;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/qqq")
public class ragistration  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		String name1=req.getParameter("name");
		String position1=req.getParameter("position");
	String department1=	req.getParameter("department");
	String pass1=req.getParameter("pass");
	String id1=req.getParameter("id");
	String salary1=req.getParameter("salary");
	String dob1=req.getParameter("dob");
	  int id2= Integer.parseInt(id1);
	    double salary2=Double.parseDouble(salary1);
	 
	
	try {
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/compani_db","root","Dolly@1234");
	  PreparedStatement ps=con.prepareStatement("insert into EMP2 values (?,?,?,?,?,?,?)");
	  ps.setString(1,name1);
	  ps.setString(2,position1);
	  ps.setString(3,department1);
	  ps.setString(4, pass1);
	  ps.setInt(5, id2);
	  ps.setDouble(6, salary2);
	  ps.setString(7, dob1);
	  
	 int i=ps.executeUpdate();
	 if(i>0) {
		 out.println("yes");
	 }else {
		 out.println("no");
	 }
	  }catch(Exception e)
	  {
		  e.printStackTrace();
		  out.print("error");
	  }
	}

}
