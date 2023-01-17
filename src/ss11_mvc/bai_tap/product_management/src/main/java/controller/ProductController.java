package controller;

import model.Product;
import service.IProductService;
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

@WebServlet(name = "ProductController", urlPatterns = {"/product", "/"})
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
                createProduct(request, response);
                break;
            }
            case "update":
                updateProduct(request, response);
                break;
            case "detail":
                List<Product> productList = iProductService.getList();
                request.setAttribute("products", productList);
                request.getRequestDispatcher("list.jsp").forward(request, response);
                break;
            default: {
                productList = iProductService.getList();
                request.setAttribute("products", productList);
                request.getRequestDispatcher("list.jsp").forward(request, response);
            }
        }
    }

    private void removeProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.iProductService.findByID(id);
        RequestDispatcher requestDispatcher;
        if (product == null) {
            requestDispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            this.iProductService.remove(id);
            try {
                response.sendRedirect("/product");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        String manufacturer = request.getParameter("manufacturer");
        Product product = this.iProductService.findByID(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            product.setNameProduct(name);
            product.setPrice(price);
            product.setDescription(description);
            product.setManufacturer(manufacturer);
            String notice = this.iProductService.update(id, product);
            request.setAttribute("product", product);
            request.setAttribute("message", notice);
            dispatcher = request.getRequestDispatcher("update.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nameProduct = request.getParameter("name");
        Double price = Double.valueOf(request.getParameter("price"));
        String description = request.getParameter("description");
        String manufacturer = request.getParameter("manufacturer");
        Integer id = (int) (Math.random() * 1000);
        Product product = new Product(id, nameProduct, price, description, manufacturer);
        Map<String, String> map = iProductService.save(product);
        if (map.isEmpty()) {
            response.sendRedirect("/product");
        } else {
            request.setAttribute("error", map);
            request.getRequestDispatcher("create.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println(action);
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                request.getRequestDispatcher("create.jsp").forward(request, response);
                break;
            case "update":
                showEditForm(request, response);
                break;
            case "remove":
                removeProduct(request, response);
                break;
            case "detail":
                showDetail(request, response);
                break;
            case "search": {
                String name = request.getParameter("name");
                List<Product> productListSearched = iProductService.search(name);
                request.setAttribute("products", productListSearched);
                request.getRequestDispatcher("list.jsp").forward(request, response);
                break;
            }
            default: {
                List<Product> productList = iProductService.getList();
                request.setAttribute("products", productList);
                request.getRequestDispatcher("list.jsp").forward(request, response);
            }
        }
    }

    private void showDetail(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.iProductService.findByID(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("product", product);
            dispatcher = request.getRequestDispatcher("detail.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.iProductService.findByID(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("product", product);
            dispatcher = request.getRequestDispatcher("update.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
