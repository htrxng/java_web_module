package repository.impl;

import model.Employee;
import repository.BaseRepository;
import repository.IEmployeeRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements IEmployeeRepository {
    private BaseRepository baseRepository = new BaseRepository();

    private static final String SELECT_ALL_EMPLOYEES = "select employee_id,employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id,username from employee;";
    private static final String INSERT_EMPLOYEE = "insert into employee(employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id) value (?,?,?,?,?,?,?,?,?,?);";
    private static final String DELETE_EMPLOYEE = "delete from employee where employee_id = ?;";
    private static final String SELECT_ALL_EMPLOYEES_BY_KEYWORD = " select employee_id,employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id,username from employee where (employee_name like ? and position_id like ? and division_id like ?);";

    @Override
    public List<Employee> getList() {
        PreparedStatement preparedStatement = null;
        List<Employee> employeeList = new ArrayList<>();

        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDataBase()
                    .prepareStatement(SELECT_ALL_EMPLOYEES);
            ResultSet resultSet = preparedStatement.executeQuery();
            Employee employee;
            while (resultSet.next()) {
                employee = new Employee();
                employee.setEmployeeId(resultSet.getInt("employee_id"));
                employee.setEmployeeName(resultSet.getString("employee_name"));
                employee.setEmployeeBirthday(String.valueOf(resultSet.getDate("employee_birthday")));
                employee.setEmployeeIdCard(resultSet.getString("employee_id_card"));
                employee.setSalary(resultSet.getDouble("employee_salary"));
                employee.setEmployeePhone(resultSet.getString("employee_phone"));
                employee.setEmployeeEmail(resultSet.getString("employee_email"));
                employee.setEmployeeAddress(resultSet.getString("employee_address"));
                employee.setPositionId(resultSet.getInt("position_id"));
                employee.setEducationDegreeId(resultSet.getInt("education_degree_id"));
                employee.setDivisionId(resultSet.getInt("division_id"));
                employee.setUsername(resultSet.getString("username"));
                employeeList.add(employee);
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
        return employeeList;
    }

    @Override
    public void save(Employee employee) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDataBase()
                    .prepareStatement(INSERT_EMPLOYEE);
//            preparedStatement.setInt(1,employee.getEmployeeId());
            preparedStatement.setString(1, employee.getEmployeeName());
            preparedStatement.setString(2, employee.getEmployeeBirthday());
            preparedStatement.setString(3, employee.getEmployeeIdCard());
            preparedStatement.setDouble(4, employee.getSalary());
            preparedStatement.setString(5, employee.getEmployeePhone());
            preparedStatement.setString(6, employee.getEmployeeEmail());
            preparedStatement.setString(7, employee.getEmployeeAddress());
            preparedStatement.setInt(8, employee.getPositionId());
            preparedStatement.setInt(9, employee.getEducationDegreeId());
            preparedStatement.setInt(10, employee.getDivisionId());
//            preparedStatement.setString(12,employee.getUsername());
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

//        private static final String UPDATE_CUSTOMER =
//        "update customer set customer_type_id = ?, customer_name = ?,customer_birthday= ?,
//        customer_gender =? ,customer_id_card = ?,customer_phone = ?,customer_email =?, customer_address = ?
//        where customer_id = ?;";

//  employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,
//  employee_address,position_id,education_degree_id,division_id,
    private static  final String UPDATE_EMPLOYEE = "update employee set employee_name = ?,employee_birthday = ?,employee_id_card = ?,employee_salary = ? ,employee_phone = ?,employee_email = ?,employee_address = ?,position_id = ?, education_degree_id = ?,division_id = ? where employee_id = ?;";
    @Override
    public void updateUser(Employee employee) {
    PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDataBase()
                    .prepareStatement(UPDATE_EMPLOYEE);
            preparedStatement.setString(1,employee.getEmployeeName());
            preparedStatement.setString(2,employee.getEmployeeBirthday());
            preparedStatement.setString(3,employee.getEmployeeIdCard());
            preparedStatement.setDouble(4,employee.getSalary());
            preparedStatement.setString(5,employee.getEmployeePhone());
           preparedStatement.setString(6,employee.getEmployeeEmail());
           preparedStatement.setString(7,employee.getEmployeeAddress());
           preparedStatement.setInt(8,employee.getPositionId());
           preparedStatement.setInt(9,employee.getEducationDegreeId());
           preparedStatement.setInt(10,employee.getDivisionId());
           preparedStatement.setInt(11,employee.getEmployeeId());
           preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }



    @Override
    public void remove(Integer id) {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDataBase()
                    .prepareStatement(DELETE_EMPLOYEE);
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
    public List<Employee> search(String positionId, String keyWordName, String divisionId) {
        PreparedStatement preparedStatement = null;
        List<Employee> employeeList = new ArrayList<>();

        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDataBase()
                    .prepareStatement(SELECT_ALL_EMPLOYEES_BY_KEYWORD);
            preparedStatement.setString(1, "%" + keyWordName + "%");
            preparedStatement.setString(2, "%" + positionId + "%");
            preparedStatement.setString(3, "%" + divisionId + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            Employee employee;
            while (resultSet.next()) {
                employee = new Employee();
                employee.setEmployeeId(resultSet.getInt("employee_id"));
                employee.setEmployeeName(resultSet.getString("employee_name"));
                employee.setEmployeeBirthday(String.valueOf(resultSet.getDate("employee_birthday")));
                employee.setEmployeeIdCard(resultSet.getString("employee_id_card"));
                employee.setSalary(resultSet.getDouble("employee_salary"));
                employee.setEmployeePhone(resultSet.getString("employee_phone"));
                employee.setEmployeeEmail(resultSet.getString("employee_email"));
                employee.setEmployeeAddress(resultSet.getString("employee_address"));
                employee.setPositionId(resultSet.getInt("position_id"));
                employee.setEducationDegreeId(resultSet.getInt("education_degree_id"));
                employee.setDivisionId(resultSet.getInt("division_id"));
                employee.setUsername(resultSet.getString("username"));
                employeeList.add(employee);
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
        return employeeList;
    }


    private static final String FIND_BY_ID = "select employee_id,employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id,username from employee where employee_id = ? ;";

    @Override
    public Employee findById(Integer id) {
        PreparedStatement preparedStatement = null;
        Employee employee = new Employee();
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDataBase()
                    .prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employee.setEmployeeId(resultSet.getInt("employee_id"));
                employee.setEmployeeName(resultSet.getString("employee_name"));
                employee.setEmployeeBirthday(String.valueOf(resultSet.getDate("employee_birthday")));
                employee.setEmployeeIdCard(resultSet.getString("employee_id_card"));
                employee.setSalary(resultSet.getDouble("employee_salary"));
                employee.setEmployeePhone(resultSet.getString("employee_phone"));
                employee.setEmployeeEmail(resultSet.getString("employee_email"));
                employee.setEmployeeAddress(resultSet.getString("employee_address"));
                employee.setPositionId(resultSet.getInt("position_id"));
                employee.setEducationDegreeId(resultSet.getInt("education_degree_id"));
                employee.setDivisionId(resultSet.getInt("division_id"));
                employee.setUsername(resultSet.getString("username"));
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
        return employee;
    }
}
