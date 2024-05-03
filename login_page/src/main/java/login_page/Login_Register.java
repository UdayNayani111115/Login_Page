package login_page;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Login_Register extends HttpServlet{
	private static final long serialVersionUID = 1L;
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
    	String FullName=req.getParameter("fullname");
    	String DOB=req.getParameter("dob");
    	String EMail=req.getParameter("email");
    	String UserName=req.getParameter("username");
    	String Password=req.getParameter("password");
    	String Confirm_Password=req.getParameter("confirm_password");
       PrintWriter pw=res.getWriter();
	   jdbc(FullName,DOB,EMail,UserName,Password,Confirm_Password);
    }
    
    public String jdbc(String fname,String Dob,String Email,String UserName,String Password,String ConfirmPassword) {
    	String URL="sql and jdbc connection url";
    	String Uname="Sql UserId";
    	String Pass="Sql PassWord";
    	
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection(URL, Uname, Pass);
			    String Query="INSERT INTO user(fullname, dob, email, username, password, ConfirmPassword) VALUES (?, ?, ?, ?, ?, ?)";
			    PreparedStatement st=con.prepareStatement(Query);
			    st.setString(1,fname);
			    st.setString(2,Dob);
			    st.setString(3,Email);
			    st.setString(4,UserName);
			    st.setString(5,Password);
			    st.setString(6,ConfirmPassword);
		int RowsInserted=st.executeUpdate();
		if(RowsInserted>=1) {
		return "Account Created";
		}
			}catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Unable to create Account";
		}
    	return "no rows effected";
    }
}
