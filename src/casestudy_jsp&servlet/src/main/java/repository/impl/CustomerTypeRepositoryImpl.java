package repository.impl;

import model.Customer;
import model.CustomerType;
import repository.BaseRepository;
import repository.ICustomerTypeRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepositoryImpl implements ICustomerTypeRepository {
    private BaseRepository baseRepository = new BaseRepository();

    private static final String SELECT_ALL_CUSTOMER_TYPE = "select customer_type_id,customer_type_name from customer_type;";
    @Override
    public List<CustomerType> getList() {
        PreparedStatement preparedStatement = null;
        List<CustomerType> customerTypeList = new ArrayList<>();
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDataBase()
                    .prepareStatement(SELECT_ALL_CUSTOMER_TYPE);
            ResultSet resultSet = preparedStatement.executeQuery();
            CustomerType customerType;
            while (resultSet.next()) {
                customerType = new CustomerType();
                customerType.setCustomerTypeId(resultSet.getInt("customer_type_id"));
                customerType.setCustomerTypeName(resultSet.getString("customer_type_name"));
                customerTypeList.add(customerType);
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
        return customerTypeList;
    }
}
