
package leave;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StatusServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data from request parameters
        String empid = request.getParameter("empID");
        String startDate = request.getParameter("startDate");
        // Establish database connection
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/chindb", "root", "password");
            
            // Retrieve the ID and start date from the session
           
            // Query to update data in the LeaveRequest table
            String query = "SELECT Status from LeaveRequest WHERE empID=? AND From_Date=?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, empid);
            pstmt.setString(2, startDate);
            //pstmt.setString(3, startDate);
            
            ResultSet rs = pstmt.executeQuery();

         // Check if there is a result
            if (rs.next()) {
                // Retrieve the status value
                String status = rs.getString("Status");

                // Generate JavaScript code to display an alert message with the status
                String script = "<script>alert('Your Leave has been " + status + "');</script>";

                // Write the JavaScript code to the response
                PrintWriter out = response.getWriter();
                out.println(script);
                //String textFieldValue = "Your value here";

                // Set the data as a session attribute
               
//                // Redirect to the desired JSP file
                //response.sendRedirect("checkStatus.jsp");
            } else {
                // No data found for the provided criteria
                response.getWriter().println("<script>alert('No data found for the provided criteria.');</script>");
                //response.sendRedirect("checkStatus.jsp");
            }



            
            // Execute the query
           

            // Close connections
            rs.close();
            pstmt.close();
            con.close();
            
            
            
            
            
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            // Handle any exceptions
        }
    }
}



