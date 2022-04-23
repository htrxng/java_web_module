package repository.impl;

import model.Service;
import repository.BaseRepository;
import repository.IServiceRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepositoryImpl implements IServiceRepository {
    BaseRepository baseRepository = new BaseRepository();

    private static final String SELECT_ALL_SERVICE = "select service_code,service_id,service_name,service_area,service_cost,service_max_people,rent_type_id,service_type_id,standard_room,description_other_convenience,pool_area,number_of_floors from service;";

    @Override
    public List<Service> getList() {
        PreparedStatement preparedStatement = null;
        List<Service> serviceList = new ArrayList<>();
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDataBase()
                    .prepareStatement(SELECT_ALL_SERVICE);
            ResultSet resultSet = preparedStatement.executeQuery();
            Service service;
            while (resultSet.next()){
                service = new Service();
                service.setServiceCode(resultSet.getString("service_code"));
                service.setServiceId(resultSet.getInt("service_id"));
                service.setServiceName(resultSet.getString("service_name"));
                service.setServiceArea(resultSet.getInt("service_area"));
                service.setServiceCost(resultSet.getDouble("service_cost"));
                service.setServiceMaxPeople(resultSet.getInt("service_max_people"));
                service.setRentTypeId(resultSet.getInt("rent_type_id"));
                service.setServiceTypeId(resultSet.getInt("service_type_id"));
                service.setStandardRoom(resultSet.getString("standard_room"));
                service.setDescriptionOtherConvenience(resultSet.getString("description_other_convenience"));
                service.setPoolArea(resultSet.getDouble("pool_area"));
                service.setNumberOfFloors(resultSet.getString("number_of_floors"));
                serviceList.add(service);
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
        return serviceList;
    }
    private static final String INSERT_SERVICE = "insert into service(service_code,service_name,service_area,service_cost,service_max_people,rent_type_id,service_type_id,standard_room,description_other_convenience,pool_area,number_of_floors) value (?,?,?,?,?,?,?,?,?,?,?);";
    @Override
    public void save(Service service) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDataBase()
                    .prepareStatement(INSERT_SERVICE);
            preparedStatement.setString(1,service.getServiceCode());
            preparedStatement.setString(2,service.getServiceName());
            preparedStatement.setInt(3,service.getServiceArea());
            preparedStatement.setDouble(4,service.getServiceCost());
            preparedStatement.setInt(5,service.getServiceMaxPeople());
            preparedStatement.setInt(6,service.getRentTypeId());
            preparedStatement.setInt(7,service.getServiceTypeId());
            preparedStatement.setString(8,service.getStandardRoom());
            preparedStatement.setString(9,service.getDescriptionOtherConvenience());
            preparedStatement.setDouble(10,service.getPoolArea());
            preparedStatement.setInt(11, Integer.parseInt(service.getNumberOfFloors()));
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
}
