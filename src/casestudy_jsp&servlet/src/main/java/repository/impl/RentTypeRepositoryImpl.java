package repository.impl;

import model.ServiceRentType;
import repository.BaseRepository;
import repository.IRentTypeRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentTypeRepositoryImpl implements IRentTypeRepository {
    BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_ALL_RENT_TYPE = "select rent_type_id, rent_type_name, rent_type_cost from rent_type;";

    @Override
    public List<ServiceRentType> getList() {
        List<ServiceRentType> rentTypeList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDataBase()
                    .prepareStatement(SELECT_ALL_RENT_TYPE);
            ResultSet resultSet = preparedStatement.executeQuery();
            ServiceRentType rentType;
            while (resultSet.next()) {
                rentType = new ServiceRentType();
                rentType.setRentTypeId(resultSet.getInt("rent_type_id"));
                rentType.setRentTypeName(resultSet.getString("rent_type_name"));
                rentType.setRentTypeCost(resultSet.getDouble("rent_type_cost"));
                rentTypeList.add(rentType);
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
        return rentTypeList;
    }
}
