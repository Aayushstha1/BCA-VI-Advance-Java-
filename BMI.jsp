<%@ page import="java.lang.*" %>

<!DOCTYPE html>
<html>
<head>
    <title>BMI Calculator</title>
</head>
<body>

<h2>BMI Calculator (Single JSP Page)</h2>

<!-- Input Form -->
<form method="post">
    
    Weight (kg):
    <input type="text" name="weight" required>
    <br><br>

    Height (meters):
    <input type="text" name="height" required>
    <br><br>

    <input type="submit" value="Calculate BMI">

</form>

<hr>

<%
    // Run calculation ONLY after form submit
    if(request.getMethod().equalsIgnoreCase("POST")) {

        try {
            double weight = Double.parseDouble(request.getParameter("weight"));
            double height = Double.parseDouble(request.getParameter("height"));

            double bmi = weight / (height * height);

            String category;

            if (bmi < 18.5)
                category = "Underweight";
            else if (bmi < 25)
                category = "Normal";
            else if (bmi < 30)
                category = "Overweight";
            else
                category = "Obese";
%>

<h3>Result</h3>
BMI: <b><%= String.format("%.2f", bmi) %></b> <br>
Category: <b><%= category %></b>

<%
        } catch(Exception e) {
%>
    <p style="color:red;">Invalid input! Please enter numbers only.</p>
<%
        }
    }
%>

</body>
</html>
