package model;

public class HinhThucThanhToan {
    private int hinhThucThanhToanId;
    private String hinhThucThanhToan;

    public HinhThucThanhToan() {
    }

    public HinhThucThanhToan(int hinhThucThanhToanId, String hinhThucThanhToan) {
        this.hinhThucThanhToanId = hinhThucThanhToanId;
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public int getHinhThucThanhToanId() {
        return hinhThucThanhToanId;
    }

    public void setHinhThucThanhToanId(int hinhThucThanhToanId) {
        this.hinhThucThanhToanId = hinhThucThanhToanId;
    }

    public String getHinhThucThanhToan() {
        return hinhThucThanhToan;
    }

    public void setHinhThucThanhToan(String hinhThucThanhToan) {
        this.hinhThucThanhToan = hinhThucThanhToan;
    }
}
