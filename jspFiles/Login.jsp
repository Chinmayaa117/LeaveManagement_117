<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Leave Management System</title>
   <style>
        /* CSS code */
        body {
            font-family: Arial, sans-serif;
            background-image: url('https://th.bing.com/th/id/OIP.jI3FwdZg_OzrXLhus5rt1QAAAA?w=290&h=197&c=7&r=0&o=5&cb=10&dpr=1.3&pid=1.7.jpg');
            background-size: cover;
            background-position: center;
            margin: 0;
            padding: 0;
        }

        h1 {
            color: #ff0000;
            text-align: center;
            margin-top: 50px;
        }

        h2 {
            color: #333;
            text-align: center;
            margin-top: 20px;
        }

        form {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-bottom: 10px;
            color: #363;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        .button-container {
            text-align: center; /* Center the buttons */
        }

        button[type="submit"] {
            background-color: #ff8800;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            margin-bottom: 10px; /* Add margin bottom for spacing */
        }
         
        button[type="button"] {
            background-color: #ff8800;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            margin-bottom: 10px; /* Add margin bottom for spacing */
            margin-left: 526px; /* Move the button 20px to the right */
            <--margin-bottom: 250px;--!>
        }
     
        button[type="submit"]:hover,
        button[type="button"]:hover {
            background-color: #cc0000;
        }
    </style>
</head>
<body>
    <h1>Leave Management System</h1>
    <h2>Enter Details</h2>
    <form action="RegisterServlet" method="post">
        <label for="username">Employee ID:</label>
        <input type="text" id="username" name="username">
        <label for="password">Password:</label>
        <input type="password" id="password" name="password">
        <button type="submit">Login</button>
        <br>
    </form>
    <button type="button" onclick="LeaveStatus()">Check Leave Status</button><br>
    <script>
        function LeaveStatus() {
            // Redirect to checkstatus.jsp
            window.location.href = 'checkStatus.jsp';
        }
    </script>
    
</body>
</html>
