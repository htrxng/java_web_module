package model;

public class PhongTro {
    private int phongTroId;
    private String tenNguoiThueTro;
    private String soDienThoai;
    private String ngayBatDauThueTro;
    private int hinhThucThanhToanId;
    private String ghiChu;

    public PhongTro() {
    }

    public PhongTro(int phongTroId, String tenNguoiThueTro, String soDienThoai, String ngayBatDauThueTro, int hinhThucThanhToanId, String ghiChu) {
        this.phongTroId = phongTroId;
        this.tenNguoiThueTro = tenNguoiThueTro;
        this.soDienThoai = soDienThoai;
        this.ngayBatDauThueTro = ngayBatDauThueTro;
        this.hinhThucThanhToanId = hinhThucThanhToanId;
        this.ghiChu = ghiChu;
    }

    public PhongTro(String tenNguoiThueTro, String soDienThoai, String ngayBatDauThueTro, Integer hinhThucThanhToanID, String ghiChu) {
        this.tenNguoiThueTro = tenNguoiThueTro;
        this.soDienThoai = soDienThoai;
        this.ngayBatDauThueTro = ngayBatDauThueTro;
        this.hinhThucThanhToanId = hinhThucThanhToanID;
        this.ghiChu = ghiChu;
    }

    public int getPhongTroId() {
        return phongTroId;
    }

    public void setPhongTroId(int phongTroId) {
        this.phongTroId = phongTroId;
    }

    public String getTenNguoiThueTro() {
        return tenNguoiThueTro;
    }

    public void setTenNguoiThueTro(String tenNguoiThueTro) {
        this.tenNguoiThueTro = tenNguoiThueTro;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getNgayBatDauThueTro() {
        return ngayBatDauThueTro;
    }

    public void setNgayBatDauThueTro(String ngayBatDauThueTro) {
        this.ngayBatDauThueTro = ngayBatDauThueTro;
    }

    public int getHinhThucThanhToanId() {
        return hinhThucThanhToanId;
    }

    public void setHinhThucThanhToanId(int hinhThucThanhToanId) {
        this.hinhThucThanhToanId = hinhThucThanhToanId;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}

