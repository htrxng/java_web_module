package controller;

import model.Category;
import model.Color;
import model.Product;
import service.ICategoryService;
import service.IColorService;
import service.IProductService;
import service.impl.CategoryServiceImpl;
import service.impl.ColorServiceImpl;
import service.impl.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ProductController", urlPatterns =  "/products")
public class ProductController extends HttpServlet {
    IColorService iColorService = new ColorServiceImpl();
    ICategoryService iCategoryService = new CategoryServiceImpl();
    IProductService iProductService = new ProductServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertProduct(request,response);
                break;
        }
    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer productId = null;
        String productName = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int colorId = Integer.parseInt(request.getParameter("colorId"));
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        Product product = new Product(productName,price,quantity,colorId,categoryId);
        Map<String,String> map = iProductService.save(product);
        if(map.isEmpty()) {
            try {
                List<Product> productList = iProductService.getList();
                List<Color> colorList = iColorService.getList();
                List<Category> categoryList = iCategoryService.getList();
                request.setAttribute("colors",colorList);
                request.setAttribute("categories",categoryList);
                request.setAttribute("products",productList);
                request.setAttribute("message","create successfully!");
                request.getRequestDispatcher("/view/product/list.jsp").forward(request,response);
            } catch (ServletException |IOException e) {
                e.printStackTrace();
            }
        } else {
            request.setAttribute("error",map);
            request.getRequestDispatcher("/view/product/create.jsp").forward(request,response);
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
                List<Color> colorList = iColorService.getList();
                List<Category> categoryList = iCategoryService.getList();
                request.setAttribute("colors",colorList);
                request.setAttribute("categories",categoryList);
                request.getRequestDispatcher("/view/product/create.jsp").forward(request,response);
                break;
            case "remove":
                removeProduct(request,response);
                List<Product> productList = iProductService.getList();
                categoryList = iCategoryService.getList();
                colorList = iColorService.getList();
                request.setAttribute("message","Delete successfully!");
                request.setAttribute("colors",colorList);
                request.setAttribute("categories",categoryList);
                request.setAttribute("products",productList);
                request.getRequestDispatcher("/view/product/list.jsp").forward(request, response);
                break;
            default:
                colorList = iColorService.getList();
                categoryList = iCategoryService.getList();
                productList = iProductService.getList();
                request.setAttribute("colors",colorList);
                request.setAttribute("categories",categoryList);
                request.setAttribute("products",productList);
                request.getRequestDispatcher("/view/product/list.jsp").forward(request,response);
        }
    }

    private void removeProduct(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("id"));
//        Product product = this.iProductService.findById(id);
//        RequestDispatcher requestDispatcher;
//        if(product == null) {
//            requestDispatcher = request.getRequestDispatcher("error-404.jsp");
//        } else {
            this.iProductService.remove(id);
//        }
    }
}
