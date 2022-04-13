import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DiscountServlet", urlPatterns = "/display-discount")
public class DiscountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("describe");
        double fixed_price = Double.parseDouble(request.getParameter("fixed_price"));
        double discount_percent = Double.parseDouble(request.getParameter("discount_percent"));

        double discount_amount = fixed_price * discount_percent * 0.01;
        double discount_price = fixed_price - discount_amount;


        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("product: " + description + " have discount amount " + discount_amount + " and discount price " + discount_price);
        writer.println("</html>");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
