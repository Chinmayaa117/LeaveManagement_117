package project;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
 import java.util.*;
 import java.time.DayOfWeek;
 import java.time.LocalDate;
 import java.time.format.DateTimeFormatter;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet  {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 //String name = request.getParameter("leave_type");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/chindb", "root", "password");
	              PreparedStatement statement = con.prepareStatement("INSERT INTO LeaveRequest (empID,Type,From_Date,To_Date,No_of_Days) values(?,?,?,?,?)");
				
	){          
		
			String checkboxValue = request.getParameter("wfh_checkbox");
			 

	        // Check if the checkbox value is "on" (indicating it's checked)
	        if (!"on".equals(checkboxValue)) {
	            System.out.println("Please Accept WFH to apply for the Leave");
	        } 
			
			
			String employeeid=request.getParameter("employID");
			
			String date1 = request.getParameter("start_date");
			String date2 = request.getParameter("end_date");
			String no_of_Holidays = request.getParameter("no_of_leaves");
			String typeOfLeave=request.getParameter("leave_type_selected");
			
			//statement.setInt(1, Integer.parseInt("i"));
            statement.setString(1, employeeid);
            statement.setString(2, typeOfLeave);
	          statement.setString(3,date1 );
	          statement.setString(4,date2 );
	          statement.setString(5, no_of_Holidays);
	              statement.executeUpdate();  
	              HttpSession session = request.getSession();
	 		     session.setAttribute("fromdate", date1);
	              
	         } catch (SQLException e) {
	             e.printStackTrace();
	         }
		
		String checkboxValue = request.getParameter("Email_checkbox");

        // Check if the checkbox is checked
        if ("on".equals(checkboxValue)) {
            // Redirect to emailAlert.jsp if the checkbox is checked
            response.sendRedirect("emailAlert.jsp");
        }
        else {
        	response.sendRedirect("Login.jsp");
        }
		
		 
	}

}
