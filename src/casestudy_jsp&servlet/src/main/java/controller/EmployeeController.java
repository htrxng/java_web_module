package controller;

import model.*;
import service.IDivisionService;
import service.IEducationDegreeService;
import service.IEmployeeService;
import service.IPositionService;
import service.impl.DivisionServiceImpl;
import service.impl.EducationDegreeServiceImpl;
import service.impl.EmployeeServiceImpl;
import service.impl.PositionServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "EmployeeController", urlPatterns = "/employees")
public class EmployeeController extends HttpServlet {
    IEmployeeService iEmployeeService = new EmployeeServiceImpl();
    IPositionService iPositionService = new PositionServiceImpl();
    IEducationDegreeService iEducationDegreeService = new EducationDegreeServiceImpl();
    IDivisionService iDivisionService = new DivisionServiceImpl();

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
                insertEmployee(request, response);
                break;
            case "edit":
                updateEmployee(request, response);
                break;
        }
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int employeeId = Integer.parseInt(request.getParameter("id"));
        String employeeName = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int positionId = Integer.parseInt(request.getParameter("positionId"));
        int educationDegreeId = Integer.parseInt(request.getParameter("educationDegreeId"));
        int divisionId = Integer.parseInt(request.getParameter("divisionId"));
        Employee employee = iEmployeeService.findById(employeeId);
        RequestDispatcher requestDispatcher;
        if (employee == null) {
            requestDispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            employee.setEmployeeName(employeeName);
            employee.setEmployeeBirthday(birthday);
            employee.setEmployeeIdCard(idCard);
            employee.setSalary(salary);
            employee.setEmployeePhone(phone);
            employee.setEmployeeEmail(email);
            employee.setEmployeeAddress(address);
            employee.setPositionId(positionId);
            employee.setEducationDegreeId(educationDegreeId);
            employee.setDivisionId(divisionId);
            Map<String, String> map = iEmployeeService.updateUser(employee);
            if (map.isEmpty()) {
                try {
                    response.sendRedirect("/employees");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                List<Position> positionList = iPositionService.getList();
                List<EducationDegree> educationDegreeList = iEducationDegreeService.getList();
                List<Division> divisionList = iDivisionService.getList();
                request.setAttribute("employee", employee);
                request.setAttribute("positions", positionList);
                request.setAttribute("educationDegrees", educationDegreeList);
                request.setAttribute("divisions", divisionList);
                request.setAttribute("error", map);
                request.getRequestDispatcher("/view/employee/edit.jsp").forward(request, response);
            }
        }
    }

    private void insertEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Integer employeeId = null;
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        Double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int positionId = Integer.parseInt(request.getParameter("positionId"));
        int educationDegreeId = Integer.parseInt(request.getParameter("educationDegreeId"));
        int divisionId = Integer.parseInt(request.getParameter("divisionId"));
//        String username = "";
        Employee employee = new Employee(name, birthday, idCard, salary, phone, email, address, positionId, educationDegreeId, divisionId);
        Map<String, String> map = iEmployeeService.save(employee);
        if (map.isEmpty()) {
            try {
                request.getRequestDispatcher("/view/employee/create.jsp").forward(request, response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            request.setAttribute("error", map);
            request.getRequestDispatcher("/view/employee/create.jsp").forward(request, response);
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                List<Position> positionList = iPositionService.getList();
                List<EducationDegree> educationDegreeList = iEducationDegreeService.getList();
                List<Division> divisionList = iDivisionService.getList();
                request.setAttribute("positions", positionList);
                request.setAttribute("educationDegrees", educationDegreeList);
                request.setAttribute("divisions", divisionList);
                request.getRequestDispatcher("/view/employee/create.jsp").forward(request, response);
                break;
            case "search":
                String positionId = request.getParameter("positionId");
                String keyWordName = request.getParameter("keyWordName");
                String divisionId = request.getParameter("divisionId");
                List<Employee> employeeListSearched = iEmployeeService.search(positionId, keyWordName, divisionId);
                positionList = iPositionService.getList();
                educationDegreeList = iEducationDegreeService.getList();
                divisionList = iDivisionService.getList();
                request.setAttribute("employees", employeeListSearched);
                request.setAttribute("positions", positionList);
                request.setAttribute("educationDegrees", educationDegreeList);
                request.setAttribute("divisions", divisionList);
                request.getRequestDispatcher("/view/employee/list.jsp").forward(request, response);
                break;
            case "remove":
                removeEmployee(request, response);
                List<Employee> employeeList = iEmployeeService.getList();
                positionList = iPositionService.getList();
                educationDegreeList = iEducationDegreeService.getList();
                divisionList = iDivisionService.getList();
                request.setAttribute("employees", employeeList);
                request.setAttribute("positions", positionList);
                request.setAttribute("educationDegrees", educationDegreeList);
                request.setAttribute("divisions", divisionList);
                request.getRequestDispatcher("/view/employee/list.jsp").forward(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            default:
                employeeList = iEmployeeService.getList();
                positionList = iPositionService.getList();
                educationDegreeList = iEducationDegreeService.getList();
                divisionList = iDivisionService.getList();
                request.setAttribute("employees", employeeList);
                request.setAttribute("positions", positionList);
                request.setAttribute("educationDegrees", educationDegreeList);
                request.setAttribute("divisions", divisionList);
                request.getRequestDispatcher("/view/employee/list.jsp").forward(request, response);
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Employee existingEmployee = this.iEmployeeService.findById(id);
        List<Position> positionList = iPositionService.getList();
        List<EducationDegree> educationDegreeList = iEducationDegreeService.getList();
        List<Division> divisionList = iDivisionService.getList();
        request.setAttribute("employee", existingEmployee);
        request.setAttribute("positions", positionList);
        request.setAttribute("educationDegrees", educationDegreeList);
        request.setAttribute("divisions", divisionList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/employee/edit.jsp");
        requestDispatcher.forward(request, response);
    }

    private void removeEmployee(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Employee employee = this.iEmployeeService.findById(id);
        RequestDispatcher requestDispatcher;
        if (employee == null) {
            requestDispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            this.iEmployeeService.remove(id);
        }
    }
}
