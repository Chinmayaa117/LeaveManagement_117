package leave;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;




public class ApprovalServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve employee ID from request parameter
        String employeeId = request.getParameter("employeeid");
        
        //String id = "yourId"; // Replace "yourId" with the actual ID retrieved

     // Store the ID in the session
     HttpSession session = request.getSession();
     session.setAttribute("id", employeeId);
        System.out.println(employeeId);
        // Establish database connection
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/chindb", "root", "password");

            // Query to retrieve data from LeaveRequest table based on employee ID
            String query = "SELECT Type, From_Date, To_Date, No_of_Days FROM LeaveRequest where empID=? and Status='pending'";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, employeeId);

            
//            INSERT INTO leave_requests (employee_id, leave_type, start_date, end_date, status)
//            SELECT employee_id_value, 'Sick Leave', '2024-03-28', '2024-03-30', 'Pending'
//            FROM (
//                SELECT * 
//                FROM leave_requests 
//                WHERE employee_id = employee_id_value
//                ORDER BY start_date DESC
//                LIMIT 1
//            ) AS latest_leave
            // Execute the query
            ResultSet rs = pstmt.executeQuery();

            // Check if result set has data
            if (rs.next()) {
                // Retrieve data from result set
                String type = rs.getString("Type");
                String fromDate = rs.getString("From_Date");
                String toDate = rs.getString("To_Date");
                int noOfDays = rs.getInt("No_of_Days");

                // Start HTML document
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Leave Request Form</title>");
                out.println("<style>");
                out.println("body {");
                out.println("    font-family: Arial, sans-serif;");
                out.println("    background-color: #f4f4f4;");
                out.println("    margin: 0;");
                out.println("     background-image: url('https://th.bing.com/th/id/OIP.jI3FwdZg_OzrXLhus5rt1QAAAA?w=290&h=197&c=7&r=0&o=5&cb=10&dpr=1.3&pid=1.7.jpg');");
                out.println("    background-size: cover;");
                out.println("    padding: 0;");
                out.println("}");
                out.println("h2 {");
                out.println("    text-align: center;");
                out.println("    color: #333;");
                out.println("}");
                out.println("form {");
                out.println("    max-width: 400px;");
                out.println("    margin: 0 auto;");
                out.println("    padding: 20px;");
                out.println("    background-color: #fff;");
                out.println("    border-radius: 5px;");
                out.println("    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);");
                out.println("}");
                out.println("input[type='text'], select {");
                out.println("    width: 100%;");
                out.println("    padding: 12px;");
                out.println("    margin: 8px 0;");
                out.println("    display: inline-block;");
                out.println("    border: 1px solid #ccc;");
                out.println("    border-radius: 4px;");
                out.println("    box-sizing: border-box;");
                out.println("}");
                out.println("input[type='submit'] {");
                out.println("    width: 100%;");
                out.println("    background-color: #4CAF50;");
                out.println("    color: white;");
                out.println("    padding: 14px 20px;");
                out.println("    margin: 8px 0;");
                out.println("    border: none;");
                out.println("    border-radius: 4px;");
                out.println("    cursor: pointer;");
                out.println("}");
                out.println("input[type='submit']:hover {");
                out.println("    background-color: #45a049;");
                out.println("}");
                out.println("</style>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h2>Leave Request Form</h2>");

                // Create form with text fields and pre-filled values
                out.println("<form action='Approv' method='post'>");
                out.println("Type: <input type='text' id='type' name='type' value='" + type + "'><br>");
                out.println("From Date: <input type='text' id='fromDate' name='fromDate' value='" + fromDate + "'><br>");
                out.println("To Date: <input type='text' id='toDate' name='toDate' value='" + toDate + "'><br>");
                out.println("No of Days: <input type='text' id='noOfDays' name='noOfDays' value='" + noOfDays + "'><br>");
                out.println("</form>");
                out.println("<form action='ApproveHR' method='post'>");
                out.println("Status: ");
                out.println("<select id='Form' name='Form'>");
                out.println("<option value='Approved'>Approved</option>");
                out.println("<option value='Rejected'>Rejected</option>");
                out.println("</select><br>");
                out.println("<input type='submit' value='Submit' onclick='displayMessage()'>");
                out.println("<script>");
                out.println("function displayMessage() {");
                out.println("  alert('Leave Status Updated');");
                out.println("}");
                out.println("</script>");
                out.println("</form>");
         //if(noOfDays<=7)
                // End HTML document
                out.println("</body>");
                out.println("</html>");
            } else {
            	out.println("<h2>No Leave Requests from employee with employee ID: " + employeeId + "</h2>");
                // No data found for the provided employee ID
            	  out.println("<form action='LeaveApprove.jsp'>");
            	    out.println("<input type='submit' value='Back to the Page' style='background-color: #4CAF50; color: white; padding: 14px 20px; margin: 8px 0; border: none; border-radius: 4px; cursor: pointer;'>");
            	    
            	    out.println("</form>");
            }

            // Close connections
            rs.close();
            pstmt.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
