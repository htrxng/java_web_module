import model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet" ,urlPatterns = {"/customer"})
public class CustomerServlet extends HttpServlet {
    static List<Customer>  customerList = new ArrayList<>();
    static {
        System.out.println("static");
        Customer customer1 = new Customer("Nguyen Huu Tiep", "1/1/1993", "Quảng Trị",
                "https://haycafe.vn/wp-content/uploads/2021/11/Anh-avatar-dep-chat-lam-hinh-dai-dien.jpg");
        Customer customer2 = new Customer("Luong Thanh Tuan", "1/1/1995", "Quảng Nam",
                "https://haycafe.vn/wp-content/uploads/2021/11/Anh-avatar-dep-chat-lam-hinh-dai-dien.jpg");
        Customer customer3 = new Customer("Nguyen Thi Dieu My", "1/1/1999", "Quảng Trị",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTvmbficGo6wY2b-tTzZCxWBqAO_NkeO3WGri1dMy9yaXbr0EZRKCTreW-1T1Ic09z_yU8&usqp=CAU");
        Customer customer4 = new Customer("Nguyen Thi Thao Ly", "2/10/2002", "Quảng Nam",
                "https://tophinhanh.com/wp-content/uploads/2021/12/hinh-avatar-cute-nhat-1-564x375.jpg");
        customerList.add(customer1);
        customerList.add(customer2);
        customerList.add(customer3);
        customerList.add(customer4);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { }

    @Override
    public void init() throws ServletException {
        System.out.println("init");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("customers", customerList);
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }
}
