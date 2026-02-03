import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/MyCookie") //Annotation
public class MySession extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        HttpSession session = request.getSession(true);
        out.print("<B>");
        Date d = (Date) session.getAttribute("date");
        if (d! == null) {
            out.print(" last access " +d+ "<br>");
        }
         d= new Date();
         session.setAttribute("date", d);
         out.print("current access " + d + "<br>");
    }
}


            