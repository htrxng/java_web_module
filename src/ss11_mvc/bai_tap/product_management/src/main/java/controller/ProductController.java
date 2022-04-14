package controller;

import model.Product;
import service.IProductService;
import service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ProductController", urlPatterns = {"/product","/"})
public class ProductController extends HttpServlet {
    //    Mô phỏng DI.
    private IProductService iProductService = new ProductServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create": {
                createProduct(request,response);
            }

        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nameProduct = request.getParameter("name");
        Double price = Double.valueOf(request.getParameter("price"));
        Integer amount = Integer.valueOf(request.getParameter("amount"));
        Integer id = (int)(Math.random()*1000);
        Product product =new Product(id,nameProduct,price,amount);
        Map<String,String>map = iProductService.save(product);
        if(map.isEmpty()) {
            response.sendRedirect("/product");
        } else{
            request.setAttribute("error", map);
            request.getRequestDispatcher("create.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println(action);
        if(action == null) {
            action = "";
        }
        switch (action) {
            case "create":
            request.getRequestDispatcher("create.jsp").forward(request,response);
            default: {
                List<Product> productList = iProductService.getList();
                request.setAttribute("products",productList);
                request.getRequestDispatcher("list.jsp").forward(request,response);
            }
        }
    }
}
