package repository.impl;

import dto.CustomerListDTO;
import model.Customer;
import repository.BaseRepository;
import repository.ICustomerRepository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private BaseRepository baseRepository = new BaseRepository();

    private static final String SELECT_ALL_CUSTOMERS = "select customer_id,customer_type_name,customer_name, customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address from customer inner  join customer_type on customer_type.customer_type_id = customer.customer_type_id;";
    private static final String SELECT_ALL_CUSTOMERS_BY_KEYWORD = "select customer_id,customer_type_name,customer_name, customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address " +
            "from customer inner  join customer_type on customer_type.customer_type_id = customer.customer_type_id  " +
            "where customer_name like ?;";


    @Override
    public List<CustomerListDTO> getList() {
        List<CustomerListDTO> customerList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDataBase().prepareStatement(SELECT_ALL_CUSTOMERS);
            ResultSet resultSet = preparedStatement.executeQuery();
            CustomerListDTO customer;
            while (resultSet.next()) {
                customer = new CustomerListDTO();
                customer.setCustomerId(resultSet.getInt("customer_id"));
                customer.setCustomerType(resultSet.getString("customer_type_name"));
                customer.setCustomerName(resultSet.getString("customer_name"));
                customer.setCustomerBirthday(resultSet.getDate("customer_birthday"));
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
        System.out.println("ok");
        return customerList;
    }


    @Override
    public void save(Customer customer) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDataBase()
                    .prepareStatement("insert into customer( `customer_type_id`, `customer_name`, `customer_birthday`, `customer_gender`, `customer_id_card`, `customer_phone`, `customer_email`, `customer_address`) value (?,?,?,?,?,?,?,?);");
            preparedStatement.setInt(1, customer.getCustomerTypeId());
            preparedStatement.setString(2, customer.getCustomerName());
            preparedStatement.setString(3,  customer.getCustomerBirthday());
            if (customer.isCustomerGender()) {
                preparedStatement.setInt(4, 1);
            } else {
                preparedStatement.setInt(4, 0);
            }
            preparedStatement.setString(5, customer.getCustomerIdCard());
            preparedStatement.setString(6, customer.getCustomerPhone());
            preparedStatement.setString(7, customer.getCustomerEmail());
            preparedStatement.setString(8, customer.getCustomerAddress());
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


    @Override
    public List<CustomerListDTO> search(String keyWord) {
        List<CustomerListDTO> customerList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDataBase()
                    .prepareStatement(SELECT_ALL_CUSTOMERS_BY_KEYWORD);
            preparedStatement.setString(1, "%" + keyWord + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            CustomerListDTO customerListDTO;
            while (resultSet.next()) {
                customerListDTO = new CustomerListDTO();
                customerListDTO.setCustomerId(resultSet.getInt("customer_id"));
                customerListDTO.setCustomerType(resultSet.getString("customer_type_name"));
                customerListDTO.setCustomerName(resultSet.getString("customer_name"));
                customerListDTO.setCustomerBirthday(resultSet.getDate("customer_birthday"));
                customerListDTO.setCustomerGender(resultSet.getBoolean("customer_gender"));
                customerListDTO.setCustomerIdCard(resultSet.getString("customer_id_card"));
                customerListDTO.setCustomerPhone(resultSet.getString("customer_phone"));
                customerListDTO.setCustomerEmail(resultSet.getString("customer_email"));
                customerListDTO.setCustomerAddress(resultSet.getString("customer_address"));
                customerList.add(customerListDTO);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }
    private static final String DELETE_CUSTOMER_SQL = "delete from customer where id = ?;";
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
                    .prepareStatement("select customer_id,customer_type_id,customer_name, customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address from customer where customer_id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
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
}
