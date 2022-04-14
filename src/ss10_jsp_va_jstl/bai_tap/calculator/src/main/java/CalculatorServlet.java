import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Double result = null;
        String message = "End calculator!";
        try {
        double value1 = Double.parseDouble(request.getParameter("first_operand"));
        String operator = request.getParameter("operator");
        double value2 = Double.parseDouble(request.getParameter("second_operand"));
        Calculator calculator = new Calculator();
            switch (operator) {
                case "plus":
                    result = calculator.plus(value1, value2);
                    break;
                case "minus":
                    result = calculator.minus(value1, value2);
                    break;
                case "multiplied":
                    result = calculator.multiplied(value1, value2);
                    break;
                case "divide":
                    result = calculator.divide(value1, value2);
                    break;
            }
        } catch (NumberFormatException numberFormatException) {
            message = "lỗi dữ liệu null";
        } catch (ArithmeticException arithmeticException) {
            message = "Lỗi chia cho 0!";
        }
        request.setAttribute("result", result);
        request.setAttribute("message", message);
        request.getRequestDispatcher("calculate.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
