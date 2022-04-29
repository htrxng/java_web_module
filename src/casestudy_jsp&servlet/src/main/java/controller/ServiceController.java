package controller;

import model.Service;
import model.ServiceRentType;
import model.ServiceType;
import service.ICustomerTypeService;
import service.IRentTypeService;
import service.IServiceService;
import service.IServiceTypeService;
import service.impl.CustomerTypeServiceImpl;
import service.impl.RentTypeServiceImpl;
import service.impl.ServiceServiceImpl;
import service.impl.ServiceTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ServiceController", urlPatterns = "/services")
public class ServiceController extends HttpServlet {
    IServiceService iServiceService = new ServiceServiceImpl();
    IRentTypeService iRentTypeService = new RentTypeServiceImpl();
    IServiceTypeService iServiceTypeService = new ServiceTypeServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertService(request, response);
                break;
        }
    }

    private void insertService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer serviceId = null;
        String serviceCode = request.getParameter("serviceCode");
        String name = request.getParameter("name");
        int area = Integer.parseInt(request.getParameter("area").equals("") ? "0" : request.getParameter("area"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int capacity = Integer.parseInt(request.getParameter("capacity"));
        int rentTypeId = Integer.parseInt(request.getParameter("rentTypeId"));
        Integer serviceTypeId = Integer.parseInt(request.getParameter("serviceTypeId"));
        String standardRoom = request.getParameter("standardRoom");
        String description = request.getParameter("description");
        double poolArea = Double.parseDouble(request.getParameter("poolArea"));
        String numberFloors = request.getParameter("numberFloors");
        Service service = new Service(serviceCode,serviceId,name,area,cost,capacity,rentTypeId,serviceTypeId,standardRoom,description,poolArea,numberFloors);
        Map<String,String> map = iServiceService.save(service);
        if (map.isEmpty()) {
            try {
                response.sendRedirect("/services");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            request.setAttribute("error", map);
            request.getRequestDispatcher("/view/service/create.jsp").forward(request, response);
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
                List<ServiceRentType> rentTypeList = iRentTypeService.getList();
                List<ServiceType> serviceTypeList = iServiceTypeService.getList();
                request.setAttribute("rentTypes",rentTypeList);
                request.setAttribute("serviceTypes",serviceTypeList);
                request.getRequestDispatcher("/view/service/create.jsp").forward(request,response);
                break;
            default:
                List<Service>  serviceList = iServiceService.getList();
                 rentTypeList = iRentTypeService.getList();
                 serviceTypeList = iServiceTypeService.getList();
                request.setAttribute("services",serviceList);
                request.setAttribute("rentTypes",rentTypeList);
                request.setAttribute("serviceTypes",serviceTypeList);
                request.getRequestDispatcher("/view/service/list.jsp").forward(request,response);
        }
    }
}
