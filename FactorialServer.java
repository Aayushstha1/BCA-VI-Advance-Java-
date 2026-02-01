import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/FactorialServlet")
public class FactorialServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int number = Integer.parseInt(request.getParameter("number"));
        long factorial = 1;

        for (int i = 1; i <= number; i++) {
            factorial = factorial * i;
        }

        out.println("<html><body>");
        out.println("<h2>Factorial Result</h2>");
        out.println("Factorial of " + number + " is: " + factorial);
        out.println("</body></html>");
    }
}
