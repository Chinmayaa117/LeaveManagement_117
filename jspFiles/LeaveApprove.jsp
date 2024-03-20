<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Leave Request Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
             background-image: url('https://th.bing.com/th/id/OIP.jI3FwdZg_OzrXLhus5rt1QAAAA?w=290&h=197&c=7&r=0&o=5&cb=10&dpr=1.3&pid=1.7.jpg');
            background-size: cover;
        }

        h2 {
            color: #333;
            text-align:center;
        }

        form {
            max-width: 400px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-bottom: 10px;
            color: #333;
        }

        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h2>Search for Leave Request Forms</h2>
    <form action="ApprovalServlet" method="doGet">
        <!-- Your input fields here -->
      
        <label for="employeeid">Enter empID:</label>
        <input type="text" id="employeeid" name="employeeid"><br><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>


    