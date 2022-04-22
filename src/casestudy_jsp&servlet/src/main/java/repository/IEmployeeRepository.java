package repository;

import model.Employee;

import java.util.List;

public interface IEmployeeRepository extends ICrudRepository<Employee> {
    List<Employee> search(String positionId, String keyWordName, String divisionId);

    Employee findById(Integer id);
}
