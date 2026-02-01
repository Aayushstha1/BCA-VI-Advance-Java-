import java.io.IOException;
import java.math.BigInteger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/factorial")
public class FactorialServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        java.io.PrintWriter out = resp.getWriter();
        out.println("<!doctype html><html><head><meta charset='utf-8'><title>Factorial Calculator</title></head><body>");
        out.println("<h2>Factorial Calculator</h2>");
        out.println("<form method='post' action='factorial'>");
        out.println("Enter a non-negative integer: <input type='number' name='number' min='0' required>");
        out.println("<button type='submit'>Compute Factorial</button>");
        out.println("</form>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String numStr = req.getParameter("number");
        resp.setContentType("text/plain;charset=UTF-8");
        java.io.PrintWriter out = resp.getWriter();

        if (numStr == null || numStr.trim().isEmpty()) {
            out.print("Invalid number");
            return;
        }

        try {
            long nLong = Long.parseLong(numStr.trim());
            if (nLong < 0) {
                out.print("Please enter a non-negative integer.");
            } else if (nLong > 10000) {
                // Safety cap to avoid extremely long computations
                out.print("Number too large. Please enter a smaller value (<= 10000).");
            } else {
                BigInteger result = factorial(BigInteger.valueOf(nLong));
                out.print(result.toString());
            }
        } catch (NumberFormatException e) {
            out.print("Invalid number: " + numStr);
        }
    }

    private BigInteger factorial(BigInteger n) {
        BigInteger result = BigInteger.ONE;
        for (BigInteger i = BigInteger.ONE; i.compareTo(n) <= 0; i = i.add(BigInteger.ONE)) {
            result = result.multiply(i);
        }
        return result;
    }
}
