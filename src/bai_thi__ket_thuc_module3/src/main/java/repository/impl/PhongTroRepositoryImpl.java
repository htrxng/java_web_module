package repository.impl;

import model.PhongTro;
import repository.BaseRepository;
import repository.IPhongTroRepository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhongTroRepositoryImpl implements IPhongTroRepository {
    BaseRepository baseRepository = new BaseRepository();

    private static final String SELECT_ALL_PHONG_TRO = "select phong_tro_id, ten_nguoi_thue_tro,so_dien_thoai,ngay_bat_dau_thue_tro,hinh_thuc_thanh_toan_id,ghi_chu from phong_tro;";

    @Override
    public List<PhongTro> getList() {
        List<PhongTro> phongTroList = new ArrayList<>();
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDatabase()
                    .prepareStatement(SELECT_ALL_PHONG_TRO);
            ResultSet resultSet = preparedStatement.executeQuery();
            PhongTro phongTro;
            while (resultSet.next()) {
                phongTro = new PhongTro();
                phongTro.setPhongTroId(resultSet.getInt("phong_tro_id"));
                phongTro.setTenNguoiThueTro(resultSet.getString("ten_nguoi_thue_tro"));
                phongTro.setSoDienThoai(resultSet.getString("so_dien_thoai"));
                phongTro.setNgayBatDauThueTro(resultSet.getString("ngay_bat_dau_thue_tro"));
                phongTro.setHinhThucThanhToanId(resultSet.getInt("hinh_thuc_thanh_toan_id"));
                phongTro.setGhiChu(resultSet.getString("ghi_chu"));
                phongTroList.add(phongTro);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return phongTroList;
    }

    private static final String DELETE_THONG_TIN_PHONG_TRO = "delete from phong_tro where phong_tro_id = ?";

    @Override
    public void remove(Integer id) {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDatabase()
                    .prepareStatement(DELETE_THONG_TIN_PHONG_TRO);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    private static final String INSERT_PHONG_TRO = "insert into phong_tro(ten_nguoi_thue_tro,so_dien_thoai,ngay_bat_dau_thue_tro,hinh_thuc_thanh_toan_id,ghi_chu) value(?,?,?,?,?);";

    @Override
    public void save(PhongTro phongTro) {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDatabase()
                    .prepareStatement(INSERT_PHONG_TRO);
            preparedStatement.setString(1, phongTro.getTenNguoiThueTro());
            preparedStatement.setString(2, phongTro.getSoDienThoai());
            preparedStatement.setDate(3, Date.valueOf(phongTro.getNgayBatDauThueTro()));
            preparedStatement.setInt(4, phongTro.getHinhThucThanhToanId());
            preparedStatement.setString(5, phongTro.getGhiChu());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    private static final String SELECT_ALL_PHONG_TRO_BY_KEY_WORD =
            "select phong_tro_id, ten_nguoi_thue_tro,so_dien_thoai,ngay_bat_dau_thue_tro," +
                    "hinh_thuc_thanh_toan.hinh_thuc_thanh_toan_id,ghi_chu " +
                    "from phong_tro " +
                    "join hinh_thuc_thanh_toan on phong_tro.hinh_thuc_thanh_toan_id = hinh_thuc_thanh_toan.hinh_thuc_thanh_toan_id " +
                    "where (phong_tro_id like ? and ten_nguoi_thue_tro like ? and hinh_thuc_thanh_toan.hinh_thuc_thanh_toan_id = ?); ";

    @Override
    public List<PhongTro> searchByMaPhongTroAndTenNguoiThueAndHinhThucThanhToan
            (String maPhongTro, String tenNguoiThue, int hinhThucThanhToan) {
        List<PhongTro> phongTroList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDatabase()
                    .prepareStatement(SELECT_ALL_PHONG_TRO_BY_KEY_WORD);
            preparedStatement.setString(1, "%" + maPhongTro + "%");
            preparedStatement.setString(2, "%" + tenNguoiThue + "%");
            preparedStatement.setInt(3, hinhThucThanhToan);
            ResultSet resultSet = preparedStatement.executeQuery();
            PhongTro phongTro;
            while (resultSet.next()) {
                phongTro = new PhongTro();
                phongTro.setPhongTroId(resultSet.getInt("phong_tro_id"));
                phongTro.setTenNguoiThueTro(resultSet.getString("ten_nguoi_thue_tro"));
                phongTro.setSoDienThoai(resultSet.getString("so_dien_thoai"));
                phongTro.setNgayBatDauThueTro(resultSet.getString("ngay_bat_dau_thue_tro"));
                phongTro.setHinhThucThanhToanId(resultSet.getInt("hinh_thuc_thanh_toan_id"));
                phongTro.setGhiChu(resultSet.getString("ghi_chu"));
                phongTroList.add(phongTro);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return phongTroList;
    }

    private static final String SELECT_ALL_PHONG_TRO_BY_MA_PHONG_TRO_VA_NGUOI_THUE =
            "select phong_tro_id, ten_nguoi_thue_tro,so_dien_thoai,ngay_bat_dau_thue_tro," +
                    "hinh_thuc_thanh_toan_id, ghi_chu " +
                    "from phong_tro " +
                    "where (phong_tro_id like ? and ten_nguoi_thue_tro like ?); ";

    @Override
    public List<PhongTro> searchByMaPhongTroVaNguoiThue(String maPhongTro, String tenNguoiThue) {
        List<PhongTro> phongTroList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDatabase()
                    .prepareStatement(SELECT_ALL_PHONG_TRO_BY_MA_PHONG_TRO_VA_NGUOI_THUE);
            preparedStatement.setString(1, "%" + maPhongTro + "%");
            preparedStatement.setString(2, "%" + tenNguoiThue + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            PhongTro phongTro;
            while (resultSet.next()) {
                phongTro = new PhongTro();
                phongTro.setPhongTroId(resultSet.getInt("phong_tro_id"));
                phongTro.setTenNguoiThueTro(resultSet.getString("ten_nguoi_thue_tro"));
                phongTro.setSoDienThoai(resultSet.getString("so_dien_thoai"));
                phongTro.setNgayBatDauThueTro(resultSet.getString("ngay_bat_dau_thue_tro"));
                phongTro.setHinhThucThanhToanId(resultSet.getInt("hinh_thuc_thanh_toan_id"));
                phongTro.setGhiChu(resultSet.getString("ghi_chu"));
                phongTroList.add(phongTro);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return phongTroList;
    }
}
