<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Leave Status</title>
    <style>
        /* CSS code for styling */
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            background-image: url('https://th.bing.com/th/id/OIP.jI3FwdZg_OzrXLhus5rt1QAAAA?w=290&h=197&c=7&r=0&o=5&cb=10&dpr=1.3&pid=1.7.jpg');
            background-size: cover;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 500px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #333;
            text-align: center;
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 10px;
            color: #666;
        }
        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type="date"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        button[type="submit"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        button[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Check Your Leave Status</h1>
        <form action="StatusServlet" method="post">
            <label for="empID">Employee ID:</label>
            <input type="text" id="empID" name="empID" placeholder="Enter Employee ID">
            <label for="startDate">Start Date:</label>
            <input type="date" id="startDate" name="startDate">
            <button type="submit">Submit</button>
            <br><br>
            
        </form>
    </div>
</body>
</html>
