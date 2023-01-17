package controller;

import model.HinhThucThanhToan;
import model.PhongTro;
import service.IHinhThucThanhToanService;
import service.IPhongTroService;
import service.impl.HinhThucThanhToanServiceImpl;
import service.impl.PhongTroServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "PhongTroController", urlPatterns = "/phongtros")

public class PhongTroController extends HttpServlet {
    private IHinhThucThanhToanService iHinhThucThanhToanService = new HinhThucThanhToanServiceImpl();
    private IPhongTroService iPhongTroService = new PhongTroServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                goCreate(request, response);
                break;
            case "search":
                goSearch(request, response);
                break;
            default:
                goList(request, response);
        }
    }

    private void goCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<HinhThucThanhToan> hinhThucThanhToanList = iHinhThucThanhToanService.getList();
        request.setAttribute("hinhThucThanhToans", hinhThucThanhToanList);
        request.getRequestDispatcher("/view/phongtro/create.jsp").forward(request, response);
    }

    private void goSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maPhongTro = request.getParameter("maPhongTro");
        String tenNguoiThue = request.getParameter("ten");
        String hinhThucThanhToan = request.getParameter("hinhThucThanhToan");
        List<PhongTro> phongTroListSearched = iPhongTroService.search(maPhongTro, tenNguoiThue, hinhThucThanhToan);
        List<HinhThucThanhToan> hinhThucThanhToanList = iHinhThucThanhToanService.getList();
        if (phongTroListSearched.size() == 0) {
            request.setAttribute("message", "No data found!");
        } else {
            request.setAttribute("hinhThucThanhToans", hinhThucThanhToanList);
            request.setAttribute("phongtros", phongTroListSearched);
        }
        request.getRequestDispatcher("/view/phongtro/list.jsp").forward(request, response);
    }

    private void goList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<HinhThucThanhToan> hinhThucThanhToanList = iHinhThucThanhToanService.getList();
        List<PhongTro> phongTroList = iPhongTroService.getList();
        if (phongTroList.size() != 0) {
            request.setAttribute("hinhThucThanhToans", hinhThucThanhToanList);
            request.setAttribute("phongtros", phongTroList);
        } else {
            request.setAttribute("message", "Không có dữ liệu cho bảng này");
        }
        request.getRequestDispatcher("/view/phongtro/list.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "remove":
                doRemovePhongTro(request, response);
                break;
            case "create":
                insertPhongTro(request, response);
                break;
            default:
                goList(request, response);
        }
    }

    private void insertPhongTro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = null;
        String tenNguoiThueTro = request.getParameter("name");
        String soDienThoai = request.getParameter("phone");
        String ngayBatDauThueTro = request.getParameter("date_start");
        int hinhThucThanhToanID = Integer.parseInt(request.getParameter("hinhThucThanhToanId"));
        String ghiChu = request.getParameter("note");
        PhongTro phongTro = new PhongTro(tenNguoiThueTro, soDienThoai, ngayBatDauThueTro, hinhThucThanhToanID, ghiChu);
        Map<String, String> map = iPhongTroService.save(phongTro);
        if (map.isEmpty()) {
            List<HinhThucThanhToan> hinhThucThanhToanList = iHinhThucThanhToanService.getList();
            List<PhongTro> phongTroList = iPhongTroService.getList();
            request.setAttribute("hinhThucThanhToans", hinhThucThanhToanList);
            request.setAttribute("phongtros", phongTroList);
            request.setAttribute("message", "Add successfully!");
            request.getRequestDispatcher("/view/phongtro/list.jsp").forward(request, response);
        } else {
            request.setAttribute("error", map);
            request.getRequestDispatcher("/view/phongtro/list.jsp").forward(request, response);
        }
    }

    private void doRemovePhongTro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id.matches("^\\d+$")) {
            Integer maPhongTro = Integer.parseInt(request.getParameter("id"));
            this.iPhongTroService.remove(maPhongTro);
            request.setAttribute("message", "delete successfully!");
            goList(request, response);
        }
    }
}
