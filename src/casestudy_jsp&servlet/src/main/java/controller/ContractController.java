package controller;

import model.*;
import service.*;
import service.impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ContractController", urlPatterns = "/contracts")
public class ContractController extends HttpServlet {
    IContractService iContractService = new ContractServiceImpl();
    IAttachServiceService iAttachServiceService = new AttachServiceServiceImpl();
    IContractDetailService iContractDetailService = new ContractDetailServiceImpl();
    IEmployeeService iEmployeeService = new EmployeeServiceImpl();
    ICustomerService iCustomerService = new CustomerServiceImpl();
    IServiceService iServiceService = new ServiceServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if(action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertContract(request,response);
                break;
        }
    }

    private void insertContract(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        Integer contractId = null;
        String startDate  =  request.getParameter("startDate");
        String endDate  =  request.getParameter("endDate");
        Double deposit = Double.parseDouble(request.getParameter("deposit"));
        Double total = Double.parseDouble(request.getParameter("total"));
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        int serviceId = Integer.parseInt(request.getParameter("serviceId"));
        Contract contract = new Contract(startDate,endDate,deposit,total,employeeId,customerId,serviceId);
        Map<String,String> map = iContractService.save(contract);
        if(map.isEmpty()){
            response.sendRedirect("/contracts");
        } else {
            request.setAttribute("error",map);
            request.getRequestDispatcher("/view/contract/create.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                request.getRequestDispatcher("/view/contract/create.jsp").forward(request,response);
            break;
            default:
                List<Contract> contractList = iContractService.getList();
                List<Employee> employeeList = iEmployeeService.getList();
                List<Customer> customerList = iCustomerService.getList();
                List<Service> serviceList = iServiceService.getList();
                 request.setAttribute("contracts", contractList);
                 request.setAttribute("employees",employeeList);
                 request.setAttribute("customers",customerList);
                 request.setAttribute("services",serviceList);
                request.getRequestDispatcher("/view/contract/list.jsp").forward(request,response);

        }
    }
}
