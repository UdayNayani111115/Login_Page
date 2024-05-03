package login_page;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Login_Server extends HttpServlet{
	private static final long serialVersionUID = 1L;
   public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
	   String Uid=req.getParameter("username");
	   String Password=req.getParameter("password");
	   Login_Server ls=new Login_Server();
	   Boolean result=ls.jdbc(Uid,Password);
	   PrintWriter pw=res.getWriter();
	   pw.println("<!DOCTYPE html>");
       pw.println("<html>");
       pw.println("<head>");
       pw.println("<title>Output</title>");
       pw.println("<style>");
       pw.println("body { font-family: Arial, sans-serif; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; }");
       pw.println(".output { padding: 20px; background-color: rgba(255, 0, 0, 0.5); border-radius: 5px; }");
       pw.println("</style>");
       pw.println("</head>");
       pw.println("<body>");
       pw.println("<div class='output'>");
       pw.println("<h2>Output</h2>");
       if(result){
       pw.println("<p>" + "Welcome "+Uid + "</p>");}
       else {
    	   pw.println("<p>" + "Invalid User Id and Password" + "</p>");}
       pw.println("</div>");
       pw.println("</body>");
       pw.println("</html>");
   }
   public boolean jdbc(String Uid,String Password) {
	   String Userid="sql userId";
	   String Pass="sql password";
	   String url="sql and jdbc connection url";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}		
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		 try {
			Connection con=DriverManager.getConnection(url, Userid, Pass);
			String Query="Select * from user where username=? and Password=?";
		 PreparedStatement st=con.prepareStatement(Query);
		 st.setString(1, Uid);
		 st.setString(2, Password);
		 ResultSet rs=st.executeQuery();
          return rs.next();
		 }
		 catch (SQLException e) {
			e.printStackTrace();
		}

	return false;
   }
}
