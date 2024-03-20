<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Send Email Alert</title>
    <style>
        /* CSS styles */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
            background-image: url('https://th.bing.com/th/id/R.229079c8f5240851cece598cf8eee770?rik=JND2PKmC%2fxzB1w&riu=http%3a%2f%2fpngimg.com%2fuploads%2femail%2femail_PNG11.png&ehk=6sNwAjueFilXp3tCehLPbXDGgZgsYZdR7y6dZ3vpSk4%3d&risl=&pid=ImgRaw&r=0.jpg');
             background-size: cover;
             background-repeat: no-repeat;
        }

        h1 {
            text-align: center;
            color: #333;
            margin-top: 50px;
        }

        form {
            text-align: center;
            margin-top: 20px;
        }

        input[type="text"], textarea {
            width: 80%;
            padding: 10px;
            margin: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            cursor: pointer;
            font-size: 16px;
            border-radius: 5px;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h1>Send Email Alert</h1>
    <form action="SendEmailServlet" method="post">
        <label for="senderEmail">Sender's Email:</label><br>
        <input type="text" id="senderEmail" name="senderEmail" required><br>

        <label for="subject">Subject:</label><br>
        <input type="text" id="subject" name="subject" required><br>

        <label for="message">Message(please Mention your empID):</label><br>
        <textarea id="message" name="message" rows="4" required></textarea><br>

        <input type="submit" value="Send Email Alert">
    </form>
</body>
</html>
