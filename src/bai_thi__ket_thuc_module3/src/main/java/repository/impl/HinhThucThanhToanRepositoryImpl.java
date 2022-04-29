package repository.impl;

import model.HinhThucThanhToan;
import repository.BaseRepository;
import repository.IHinhThucThanhToanRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HinhThucThanhToanRepositoryImpl implements IHinhThucThanhToanRepository {
    BaseRepository baseRepository = new BaseRepository();

    private static final String SELECT_ALL_HINH_THUC_THANH_TOAN = "select hinh_thuc_thanh_toan_id, hinh_thuc_thanh_toan from hinh_thuc_thanh_toan;";
    @Override
    public List<HinhThucThanhToan> getList() {
        List<HinhThucThanhToan> hinhThucThanhToanList = new ArrayList<>();
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDatabase()
                    .prepareStatement(SELECT_ALL_HINH_THUC_THANH_TOAN);
            ResultSet resultSet = preparedStatement.executeQuery();
            HinhThucThanhToan hinhThucThanhToan;
            while (resultSet.next()) {
                hinhThucThanhToan = new HinhThucThanhToan();
                hinhThucThanhToan.setHinhThucThanhToanId(resultSet.getInt("hinh_thuc_thanh_toan_id"));
                hinhThucThanhToan.setHinhThucThanhToan(resultSet.getString("hinh_thuc_thanh_toan"));
                hinhThucThanhToanList.add(hinhThucThanhToan);
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
        return hinhThucThanhToanList;
    }
}
