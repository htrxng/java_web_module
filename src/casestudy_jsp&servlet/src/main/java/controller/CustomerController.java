package controller;

import model.Customer;
import model.CustomerType;
import service.ICustomerService;
import service.ICustomerTypeService;
import service.impl.CustomerServiceImpl;
import service.impl.CustomerTypeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CustomerController", urlPatterns = "/customers")
public class CustomerController extends HttpServlet {
    ICustomerService customerService = new CustomerServiceImpl();
    ICustomerTypeService customerTypeService = new CustomerTypeServiceImpl();
    static boolean checkGender;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertCustomer(request, response);
                break;
            case "edit":
                updateCustomer(request, response);
                break;
        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String customerCode = request.getParameter("customerCode");
        Integer customerTypeId = Integer.parseInt(request.getParameter("customerTypeId"));
        String name = request.getParameter("name");
        String birthDay = request.getParameter("birthDay");
        int gender = Integer.parseInt(request.getParameter("gender"));
        if (gender == 0) {
            checkGender = false;
        } else if (gender == 1) {
            checkGender = true;
        }
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = customerService.findByID(id);
        RequestDispatcher requestDispatcher;
        if (customer == null) {
            requestDispatcher = request.getRequestDispatcher("/view/customer/edit.jsp");
        } else {
            customer.setCustomerCode(customerCode);
            customer.setCustomerId(id);
            customer.setCustomerTypeId(customerTypeId);
            customer.setCustomerName(name);
            customer.setCustomerBirthday(birthDay);
            customer.setCustomerGender(checkGender);
            customer.setCustomerIdCard(idCard);
            customer.setCustomerPhone(phone);
            customer.setCustomerEmail(email);
            customer.setCustomerAddress(address);
            Map<String, String> map = customerService.updateUser(customer);
            if (map.isEmpty()) {
                try {
                    response.sendRedirect("/customers");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                List<CustomerType> typeCustomerList = customerTypeService.getList();
                request.setAttribute("typeCustomers", typeCustomerList);
                request.setAttribute("customer", customer);
                request.setAttribute("error", map);
                request.getRequestDispatcher("/view/customer/edit.jsp").forward(request, response);
            }
        }
    }

    private void insertCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer customerId = null;
        String customerCode = request.getParameter("customerCode");
        int customerTypeId = Integer.parseInt(request.getParameter("customerTypeId"));
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
        Customer customer = new Customer(customerCode, customerId, customerTypeId, customerName, birthday, checkGender, idCard, phone, email, address);
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
        request.setCharacterEncoding("UTF-8"); //viet tieng viet
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                List<CustomerType> typeCustomerList = customerTypeService.getList();
                request.setAttribute("typeCustomers", typeCustomerList);
                request.getRequestDispatcher("/view/customer/create.jsp").forward(request, response);
                break;
            case "search":
                String customerTypeId = request.getParameter("customerTypeId");
                String keyWordName = request.getParameter("keyWordName");
                String keyWordEmail = request.getParameter("keyWordEmail");
                List<Customer> customerListSearch = customerService.search(customerTypeId, keyWordName, keyWordEmail);
                typeCustomerList = customerTypeService.getList();
                request.setAttribute("customers", customerListSearch);
                request.setAttribute("typeCustomers", typeCustomerList);
                request.getRequestDispatcher("/view/customer/list.jsp").forward(request, response);
                break;
            case "remove":
                removeCustomer(request, response);
                List<Customer> customerList = customerService.getList();
                typeCustomerList = customerTypeService.getList();
                request.setAttribute("message", "Delete successfully!");
                request.setAttribute("customers", customerList);
                request.setAttribute("typeCustomers", typeCustomerList);
                request.getRequestDispatcher("/view/customer/list.jsp").forward(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            default:
                customerList = customerService.getList();
                typeCustomerList = customerTypeService.getList();
                request.setAttribute("customers", customerList);
                request.setAttribute("typeCustomers", typeCustomerList);
                request.getRequestDispatcher("/view/customer/list.jsp").forward(request, response);
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Customer existingCustomer = this.customerService.findByID(id);
        List<CustomerType> typeCustomerList = customerTypeService.getList();
        request.setAttribute("customer", existingCustomer);
        request.setAttribute("typeCustomers", typeCustomerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/customer/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void removeCustomer(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getParameter("id"));
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
