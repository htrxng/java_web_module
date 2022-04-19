package controller;

import model.User;
import service.IUserSerivce;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "UserController", urlPatterns = {"/users", "/"})
public class UserController extends HttpServlet {
    private IUserSerivce userSerivce = new UserService();


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
            case "edit":
                try {
                    updateUser(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
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
            case "edit":
                try {
                    showEditForm(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "remove":
                removeUser(request, response);
                break;
            case "search":
                String countryName = request.getParameter("country");
                List<User> userListSearched = userSerivce.search(countryName);
                request.setAttribute("users", userListSearched);
                request.getRequestDispatcher("list.jsp").forward(request, response);
                break;
            default:
                List<User> userList = userSerivce.getUserList();
                request.setAttribute("users", userList);
                request.getRequestDispatcher("list.jsp").forward(request, response);
                break;
        }
    }

    private void removeUser(HttpServletRequest request, HttpServletResponse response) {
        try {
            Integer id = Integer.parseInt(request.getParameter("id"));
            User user = this.userSerivce.findByID(id);
            RequestDispatcher requestDispatcher;
            if (user == null) {
                requestDispatcher = request.getRequestDispatcher("error-404.jsp");
            } else {
                this.userSerivce.remove(id);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = this.userSerivce.findByID(id);
        RequestDispatcher requestDispatcher;
        if (user == null) {
            requestDispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            user.setName(name);
            user.setEmail(email);
            user.setCountry(country);
            String notice = userSerivce.updateUser(user);
            RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User newUser = new User(name, email, country);
        Map<String, String> map = userSerivce.save(newUser);
        if (map.isEmpty()) {
            try {
                response.sendRedirect("/users");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            request.setAttribute("error", map);
            try {
                request.getRequestDispatcher("create.jsp").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        User existingUser = this.userSerivce.findByID(id);
        request.setAttribute("user", existingUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
        dispatcher.forward(request, response);
    }

}
