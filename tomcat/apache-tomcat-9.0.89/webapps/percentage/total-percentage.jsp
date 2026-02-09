<%@ page import="java.lang.*" %>

<!DOCTYPE html>
<html>
<head>
    <title>Student Percentage Calculator</title>
</head>
<body>

<h2>Student Percentage Calculator</h2>

<!-- Input Form -->
<form method="post">
    
    Student Name:
    <input type="text" name="name" required>
    <br><br>

    Roll Number:
    <input type="text" name="roll" required>
    <br><br>

    Marks in Subject 1:
    <input type="number" name="marks1"  required>
    <br><br>

    Marks in Subject 2:
    <input type="number" name="marks2"  required>
    <br><br>

    Marks in Subject 3:
    <input type="number" name="marks3"  required>
    <br><br>

    Marks in Subject 4:
    <input type="number" name="marks4"  required>
    <br><br>

    Marks in Subject 5:
    <input type="number" name="marks5" required>
    <br><br>

    <input type="submit" value="Calculate Percentage">

</form>

<hr>

<%
    // Run calculation ONLY after form submit
    if(request.getMethod().equalsIgnoreCase("POST")) {

        try {
            String name = request.getParameter("name");
            String roll = request.getParameter("roll");

            double marks1 = Double.parseDouble(request.getParameter("marks1"));
            double marks2 = Double.parseDouble(request.getParameter("marks2"));
            double marks3 = Double.parseDouble(request.getParameter("marks3"));
            double marks4 = Double.parseDouble(request.getParameter("marks4"));
            double marks5 = Double.parseDouble(request.getParameter("marks5"));

            double totalMarks = marks1 + marks2 + marks3 + marks4 + marks5;
            double percentage = (totalMarks / 500) * 100;

            String division;

            if (percentage >= 80)
                division = "First Division";
            else if (percentage >= 60)
                division = "Second Division";
            else if (percentage >= 40)
                division = "Third Division";
            else
                division = "Fail";
%>

<h3>Result</h3>
Name: <b><%= name %></b> <br>
Roll Number: <b><%= roll %></b> <br>
Total Marks: <b><%= totalMarks %>/500</b> <br>
Percentage: <b><%= String.format("%.2f", percentage) %>%</b> <br>
Division: <b><%= division %></b>

<%
        } catch(Exception e) {
%>
    <p style="color:red;">Invalid input! Please enter valid numbers for marks.</p>
<%
        }
    }
%>

</body>
</html>
