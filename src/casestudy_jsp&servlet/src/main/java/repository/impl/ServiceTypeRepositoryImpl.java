package repository.impl;

import model.ServiceType;
import repository.BaseRepository;
import repository.IServiceTypeRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceTypeRepositoryImpl implements IServiceTypeRepository {
    private BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_ALL_SERVICE_TYPE = "select service_type_id, service_type_name from service_type;";

    @Override
    public List<ServiceType> getList() {
        PreparedStatement preparedStatement = null;
        List<ServiceType> serviceTypeList = new ArrayList<>();
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDataBase()
                    .prepareStatement(SELECT_ALL_SERVICE_TYPE);
            ResultSet resultSet = preparedStatement.executeQuery();
            ServiceType serviceType;
            while (resultSet.next()) {
                serviceType = new ServiceType();
                serviceType.setServiceTypeId(resultSet.getInt("service_type_id"));
                serviceType.setServiceTypeName(resultSet.getString("service_type_name"));
                serviceTypeList.add(serviceType);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return serviceTypeList;
    }
}
