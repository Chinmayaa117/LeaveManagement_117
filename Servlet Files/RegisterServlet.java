package leave;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/chindb", "root", "password");
	              //PreparedStatement statement = con.prepareStatement("INSERT INTO LeaveRequest (S_No,empID,Type,From_Date,To_Date,No_of_Days) values(?,?,?,?,?,?)");
	){          
			 String query1 = "select empID from employees";
				Statement statement1 = con.createStatement();
				ResultSet resultset1 = statement1.executeQuery(query1);
				//rs.next();
				
				
				HashSet<String>sett=new HashSet<>();
				while(resultset1.next()) {
					sett.add(resultset1.getString(1));
				}
				String query2 = "select Password from employees";
				Statement statement2 = con.createStatement();
				ResultSet resultset2 = statement2.executeQuery(query2);
				//rs.next();
				HashSet<String>pass=new HashSet<>();
				while(resultset2.next()) {
					pass.add(resultset2.getString(1));
				}
				String ID = request.getParameter("username");
			 	String password = request.getParameter("password");
		        //System.out.println(ID);
		        //System.out.println(password);
		        if(pass.contains(password)) {
		        	response.sendRedirect("Leaveapply.jsp");
		        }
		        else if(password.equals("1234")) {
		        	response.sendRedirect("LeaveApprove.jsp");
		        }
		        else {
		        	response.sendRedirect("Login.jsp");
		        }
	         }
		
		catch (SQLException e) {
	             e.printStackTrace();
	         }
		
		
        
       
	}

}
