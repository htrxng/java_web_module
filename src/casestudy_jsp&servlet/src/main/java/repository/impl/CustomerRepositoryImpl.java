package repository.impl;

import dto.CustomerListDTO;
import model.Customer;
import model.CustomerType;
import repository.BaseRepository;
import repository.ICustomerRepository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerRepositoryImpl implements ICustomerRepository {
    private BaseRepository baseRepository = new BaseRepository();

    private static final String SELECT_ALL_CUSTOMERS = "select customer_code, customer_id,customer_type_id,customer_name, customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address from customer;";
    private static final String UPDATE_CUSTOMER = "update customer set customer_type_id = ?, customer_name = ?,customer_birthday= ?, customer_gender =? ,customer_id_card = ?,customer_phone = ?,customer_email =?, customer_address = ? where customer_id = ?;";


    @Override
    public List<Customer> getList() {
        List<Customer> customerList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDataBase().prepareStatement(SELECT_ALL_CUSTOMERS);
            ResultSet resultSet = preparedStatement.executeQuery();
            Customer customer;
            while (resultSet.next()) {
                customer = new Customer();
                customer.setCustomerCode(resultSet.getString("customer_code"));
                customer.setCustomerId(resultSet.getInt("customer_id"));
                customer.setCustomerTypeId(resultSet.getInt("customer_type_id"));
                customer.setCustomerName(resultSet.getString("customer_name"));
                customer.setCustomerBirthday(String.valueOf(resultSet.getDate("customer_birthday")));
                customer.setCustomerGender(resultSet.getBoolean("customer_gender"));
                customer.setCustomerIdCard(resultSet.getString("customer_id_card"));
                customer.setCustomerPhone(resultSet.getString("customer_phone"));
                customer.setCustomerEmail(resultSet.getString("customer_email"));
                customer.setCustomerAddress(resultSet.getString("customer_address"));
                customerList.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return customerList;
    }

    @Override
    public void save(Customer customer) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDataBase()
                    .prepareStatement("insert into customer( `customer_type_id`, `customer_name`, `customer_birthday`, `customer_gender`, `customer_id_card`, `customer_phone`, `customer_email`, `customer_address`,`customer_code`) value (?,?,?,?,?,?,?,?,?);");
            preparedStatement.setInt(1, customer.getCustomerTypeId());
            preparedStatement.setString(2, customer.getCustomerName());
            preparedStatement.setString(3, customer.getCustomerBirthday());
            if (customer.isCustomerGender()) {
                preparedStatement.setInt(4, 1);
            } else {
                preparedStatement.setInt(4, 0);
            }
            preparedStatement.setString(5, customer.getCustomerIdCard());
            preparedStatement.setString(6, customer.getCustomerPhone());
            preparedStatement.setString(7, customer.getCustomerEmail());
            preparedStatement.setString(8, customer.getCustomerAddress());
            preparedStatement.setString(9,customer.getCustomerCode());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private static final String SELECT_ALL_CUSTOMERS_BY_KEYWORD = "select customer_id,customer_type_id,customer_name, customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address,customer_code from customer " +
            "where (customer_name like ? and customer_type_id like ? and customer_email like ?);";
    @Override
    public List<Customer> search(String customerTypeId,String keyWordName , String keyWordEmail) {
        List<Customer> customerList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDataBase()
                    .prepareStatement(SELECT_ALL_CUSTOMERS_BY_KEYWORD);
            preparedStatement.setString(1, "%" + keyWordName + "%");
            preparedStatement.setString(2,"%" +customerTypeId + "%");
            preparedStatement.setString(3, "%" + keyWordEmail + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            Customer customer;
            while (resultSet.next()) {
                customer = new Customer();
                customer.setCustomerCode(resultSet.getString("customer_code"));
                customer.setCustomerId(resultSet.getInt("customer_id"));
                customer.setCustomerTypeId(resultSet.getInt("customer_type_id"));
                customer.setCustomerName(resultSet.getString("customer_name"));
                customer.setCustomerBirthday(String.valueOf(resultSet.getDate("customer_birthday")));
                customer.setCustomerGender(resultSet.getBoolean("customer_gender"));
                customer.setCustomerIdCard(resultSet.getString("customer_id_card"));
                customer.setCustomerPhone(resultSet.getString("customer_phone"));
                customer.setCustomerEmail(resultSet.getString("customer_email"));
                customer.setCustomerAddress(resultSet.getString("customer_address"));
                customerList.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }

    private static final String DELETE_CUSTOMER_SQL = "delete from customer where customer_id = ?;";

    @Override
    public void remove(Integer id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDataBase()
                    .prepareStatement(DELETE_CUSTOMER_SQL);
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

    @Override
    public Customer findById(Integer id) {
        Customer customer = new Customer();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDataBase()
                    .prepareStatement("select customer_code, customer_id,customer_type_id,customer_name, customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address from customer where customer_id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customer.setCustomerCode(resultSet.getString("customer_code"));
                customer.setCustomerId(resultSet.getInt("customer_id"));
                customer.setCustomerTypeId(resultSet.getInt("customer_type_id"));
                customer.setCustomerName(resultSet.getString("customer_name"));
                customer.setCustomerBirthday(resultSet.getString("customer_birthday"));
                customer.setCustomerGender(resultSet.getBoolean("customer_gender"));
                customer.setCustomerIdCard(resultSet.getString("customer_id_card"));
                customer.setCustomerPhone(resultSet.getString("customer_phone"));
                customer.setCustomerEmail(resultSet.getString("customer_email"));
                customer.setCustomerAddress(resultSet.getString("customer_address"));
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
        return customer;
    }


    @Override
    public void updateUser(Customer customer) {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDataBase()
                    .prepareStatement(UPDATE_CUSTOMER);
            preparedStatement.setInt(1, customer.getCustomerTypeId());
            preparedStatement.setString(2, customer.getCustomerName());
            preparedStatement.setString(3, customer.getCustomerBirthday());
            preparedStatement.setBoolean(4, customer.isCustomerGender());
            preparedStatement.setString(5, customer.getCustomerIdCard());
            preparedStatement.setString(6, customer.getCustomerPhone());
            preparedStatement.setString(7, customer.getCustomerEmail());
            preparedStatement.setString(8, customer.getCustomerAddress());
            preparedStatement.setInt(9, customer.getCustomerId());
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
