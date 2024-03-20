
package leave;

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
import java.sql.SQLException;

public class ApproveHR extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data from request parameters
        String status = request.getParameter("Form");

        // Establish database connection
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/chindb", "root", "password");
            
            // Retrieve the ID and start date from the session
            HttpSession session = request.getSession();
            String id = (String) session.getAttribute("id");
            String startDate = (String) session.getAttribute("fromdate");
            // Query to update data in the LeaveRequest table
            String query = "UPDATE LeaveRequest SET Status=? WHERE empID=? AND Status='pending'";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, status);
            pstmt.setString(2, id);
            //pstmt.setString(3, startDate);
            
            // Execute the query
            int rowsAffected = pstmt.executeUpdate();

            // Check if the update was successful
            if (rowsAffected > 0) {          
                response.sendRedirect("Login.jsp");
                // You can redirect the user to a success page or display a message here
            } else {
                // Update failed
                System.out.println("Failed to update data.");
                // You can redirect the user to an error page or display a message here
            }

            // Close connections
            pstmt.close();
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            // Handle any exceptions
        }
    }
}



