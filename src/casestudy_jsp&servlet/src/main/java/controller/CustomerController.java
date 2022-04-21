package controller;

import dto.CustomerListDTO;
import model.Customer;
import service.ICustomerService;
import service.impl.CustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CustomerController", urlPatterns = "/customers")
public class CustomerController extends HttpServlet {
    ICustomerService customerService = new CustomerService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertUser(request, response);
                break;
//            case "edit":
//                try {
//                    updateUser(request, response);
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
//                break;
//        }
        }
    }

    boolean checkGender;

    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer customerId = null;
        Integer customerTypeId = Integer.parseInt(request.getParameter("customerType"));
        String customerName = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        Integer gender = Integer.parseInt(request.getParameter("gender"));
        if (gender == 0) {
            checkGender = false;
        } else if (gender == 1) {
            checkGender = true;
        }
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(customerId,customerTypeId, customerName, birthday, checkGender, idCard, phone, email, address);
        Map<String, String> map = customerService.save(customer);
        if (map.isEmpty()) {
            try {
                response.sendRedirect("/customers");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            request.setAttribute("error", map);
            request.getRequestDispatcher("/view/customer/create.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                request.getRequestDispatcher("/view/customer/create.jsp").forward(request, response);
                break;
            case "search":
                String keyWord = request.getParameter("keyWord");
                List<CustomerListDTO> customerListDTOSSearch = customerService.search(keyWord);
                request.setAttribute("customers", customerListDTOSSearch);
                request.getRequestDispatcher("/view/customer/list.jsp").forward(request, response);
                break;
            case "remove":
                removeCustomer(request, response);
                List<CustomerListDTO> customerListt = customerService.getList();
                request.setAttribute("customers", customerListt);
                request.getRequestDispatcher("/view/customer/list.jsp").forward(request, response);
                break;
            default:
                List<CustomerListDTO> customerList = customerService.getList();
                request.setAttribute("customers", customerList);
                request.getRequestDispatcher("/view/customer/list.jsp").forward(request, response);
        }
    }

    private void removeCustomer(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Customer user = this.customerService.findByID(id);
        RequestDispatcher requestDispatcher;
        if (user == null) {
            requestDispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            this.customerService.remove(id);
        }
    }
}
