package service;

import model.Employee;
import repository.IEmployeeRepository;

import java.util.List;
import java.util.Map;

public interface IEmployeeService extends ICrudService<Employee> {

    List<Employee> search(String positionId, String keyWordName, String divisionId);

    Employee findById(Integer id);
}
