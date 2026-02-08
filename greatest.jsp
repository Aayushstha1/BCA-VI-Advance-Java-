<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>greast among three!</title>
</head>
<body>
    <form action="greatest.jsp" method="post">
        <label for="num1">Number 1:</label>
        <input type="number" id="num1" name="num1" required><br><br>
        
        <label for="num2">Number 2:</label>
        <input type="number" id="num2" name="num2" required><br><br>
        
        <label for="num3">Number 3:</label>
        <input type="number" id="num3" name="num3" required><br><br>
        
        <input type="submit" value="Find Greatest"> 
    </form>
    <!-- get the parameters -->
    <%
        String num1 = request.getParameter("num1");
        String num2 = request.getParameter("num2");
        String num3 = request.getParameter("num3");
        
        if (num1 != null && num2 != null && num3 != null) {
            try {
                int num1 = Integer.parseInt(num1);
                int num2 = Integer.parseInt(num2);
                int num3 = Integer.parseInt(num3);
                
                int greatest = num1;
                if (num2 > greatest) {
                    greatest = num2;
                }
                if (num3 > greatest) {
                    greatest = num3;
                }
                
                out.println("<h2>The greatest number is: " + greatest + "</h2>");
            } catch (NumberFormatException e) {
                out.println("<h2>Please enter valid numbers.</h2>");
            }
        }
    
</body>
</html>