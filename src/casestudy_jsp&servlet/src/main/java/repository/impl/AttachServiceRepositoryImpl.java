package repository.impl;

import model.AttachService;
import repository.BaseRepository;
import repository.IAttachServiceRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttachServiceRepositoryImpl implements IAttachServiceRepository {
    BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_ALL_ATTACH_SERVICE = "select attach_service_id,attach_service_name,attach_service_cost,attach_service_unit,attach_service_status from attach_service;";
    @Override
    public List<AttachService> getList() {
        List<AttachService> attachServiceList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDataBase()
                    .prepareStatement(SELECT_ALL_ATTACH_SERVICE);
            ResultSet resultSet = preparedStatement.executeQuery();
            AttachService attachService;
            while (resultSet.next()){
                attachService = new AttachService();
                attachService.setAttachServiceId(resultSet.getInt("attach_service_id"));
                attachService.setAttachServiceName(resultSet.getString("attach_service_name"));
                attachService.setAttachServiceCost(resultSet.getDouble("attach_service_cost"));
                attachService.setAttachServiceUnit(resultSet.getString("attach_service_unit"));
                attachService.setAttachServiceStatus(resultSet.getString("attach_service_status"));
                attachServiceList.add(attachService);
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

        return attachServiceList;
    }
}
