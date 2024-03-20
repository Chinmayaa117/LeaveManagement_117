<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Leave Application</title>
    
     <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
            
            background-image: url('https://th.bing.com/th/id/OIP.tr69iCiebMY97qusR7MpCQHaD5?rs=1&pid=ImgDetMain.jpg');
            background-size:cover;
        }

        h2 {
            color: #33;
            text-align:center;
        }

        form {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-bottom: 5px;
            color: #333;
        }

        input[type="text"],
        input[type="date"],
        select {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type="checkbox"] {
            margin-right: 5px;
        }

        button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }

        button:hover {
            background-color: #45a049;
        }
    </style>
    <script>
    
    document.getElementById("Email_checkbox").addEventListener("change", function() {
        if (this.checked) {
            window.location.href = "emailAlert.jsp";
        }
    });
    
    function displayMessage() {
        // Get the checkbox element
        var checkbox = document.getElementById("wfh_checkbox");

        // Check if the checkbox is unchecked
        if (!checkbox.checked) {
            // Display the message
            alert("Please accept to WFH for successful application of Leave");
        }
    }
    function confirmSubmit() {
        return confirm("Leave Applied Successfully!!");
    }
    function formatDate(date) {
        const month = (date.getMonth() + 1).toString().padStart(2, '0');
        const day = date.getDate().toString().padStart(2, '0');
        const year = date.getFullYear();
        return `${month}-${day}-${year}`;
    }
        function calculateLeaves() {
            var startDate = new Date(document.getElementById("start_date").value);
            var endDate = new Date(document.getElementById("end_date").value);
            var leaveType = document.getElementById("leave_type").value;
            var holidays = ['01-26-2024', '05-01-2024','08-15-2024','10-02-2024','01-01-2024','01-15-2024','03-29-2024','09-07-2024']; 
            var noOfDays,holiday=0;
            if(endDate.getTime()==startDate.getTime())noOfDays=Math.round((endDate - startDate) / (1000 * 60 * 60 * 24)) + 0.5
            else 
            	noOfDays = Math.round((endDate - startDate) / (1000 * 60 * 60 * 24)) + 1;
            var countWeekends = 0;
            for (var i = startDate; i <= endDate; i.setDate(i.getDate() + 1)) {
                if (i.getDay() === 0 || i.getDay() === 6) {
                    countWeekends++;
                }
                if (holidays.includes(formatDate(i))) {
                    holiday++; // Subtract holiday from total days
                }
            }
            var totalLeaves = noOfDays - countWeekends-holiday;
            document.getElementById("no_of_leaves").value = totalLeaves;
            document.getElementById("leave_type_selected").value = leaveType;
        }
    </script>
</head>
<body>
    <h2>Leave Application</h2>
    <form action="LoginServlet" method="post" onsubmit="return confirmSubmit()">
    
        <label for="employeeID">Your ID:</label>
        <input type="text" id="employID" name="employID" required><br>
        <label for="leave_type">Type of Leave:</label>
        <select id="leave_type" name="leave_type" required>
            <option value="Sick Leave">SL</option>
            <option value="Casual Leave">CL</option>
            <option value="Loss of Pay">LoP</option>
        </select><br><br>

        <label for="start_date">Start Date:</label>
        <input type="date" id="start_date" name="start_date" required><br>

        <label for="end_date">End Date:</label>
        <input type="date" id="end_date" name="end_date" required><br>

        <label for="no_of_leaves">Number of Leaves:</label>
        <input type="text" id="no_of_leaves" name="no_of_leaves" readonly><br>
<button type="button" onclick="calculateLeaves()">Calculate No.of.Days</button>
        <input type="hidden" id="leave_type_selected" name="leave_type_selected"><br>

<input type="checkbox" id="wfh_checkbox" name="wfh_checkbox"  checked onchange="displayMessage()">
        <label for="wfh_checkbox">Ready to Work From Home</label><br>
        
<input type="checkbox" id="Email_checkbox" name="Email_checkbox">
<label for="Email_checkbox">Send Email Alert</label>

        
        <button type="submit">Submit</button>
    </form>
</body>
</html>
