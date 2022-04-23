package service.impl;

import model.Employee;
import repository.IEmployeeRepository;
import repository.impl.EmployeeRepositoryImpl;
import service.IEmployeeService;
import utils.RegularExpression;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeServiceImpl implements IEmployeeService {
    IEmployeeRepository iEmployeeRepository = new EmployeeRepositoryImpl();
    private static RegularExpression reGex = new RegularExpression();

    @Override
    public List<Employee> getList() {
        return iEmployeeRepository.getList();
    }

    @Override
    public Map<String, String> updateUser(Employee employee) {
        Map<String, String> map = new HashMap<>();
        if (employee.getEmployeeName().equals("")) {
            map.put("name", "Name is not be empty!");
        } else if (!employee.getEmployeeName().matches("^((\\p{Lu}(\\p{Ll})+)(\\s)?)+$")) {
            map.put("name", "Name is not invalid!");
        }
        if (!reGex.phoneNumberValidate(employee.getEmployeePhone())) {
            map.put("phone", "Phone is not invalid! ||" +
                    "model: [090xxxxxxx]/[091xxxxxxx] \n" +
                    "or [(84)+90xxxxxxx]/[(84)+91xxxxxxxx]");
        }
        if (!reGex.passportValidate(employee.getEmployeeIdCard())) {
            map.put("idCard", "ID Card is not invalid! || ID CARD must be have 9 or 12 number.");
        }
        if(!reGex.emailValidate(employee.getEmployeeEmail())) {
            map.put("email","email is not invalid! || model: huutrungg02@gmail.com");
        }
        if(!reGex.numberPositive(String.valueOf(employee.getSalary()))) {
            map.put("salary","salary must be a positive number");
        }
        if (map.isEmpty()) {
            iEmployeeRepository.updateUser(employee);
        }

        return map;
    }

    @Override
    public void remove(Integer id) {
        iEmployeeRepository.remove(id);
    }

    @Override
    public Map<String, String> save(Employee employee) {
        Map<String, String> map = new HashMap<>();
        if (employee.getEmployeeName().equals(" ")) {
            map.put("name", "Name is not be empty!");
        } else if (!employee.getEmployeeName().matches("^((\\p{Lu}(\\p{Ll})+)(\\s)?)+$")) {
            map.put("name", "Name is not invalid!");
        }
        if (!reGex.phoneNumberValidate(employee.getEmployeePhone())) {
            map.put("phone", "Phone is not invalid! ||" +
                    "model: [090xxxxxxx]/[091xxxxxxx] \n" +
                    "or [(84)+90xxxxxxx]/[(84)+91xxxxxxxx]");
        }
        if (!reGex.passportValidate(employee.getEmployeeIdCard())) {
            map.put("idCard", "ID Card is not invalid! || ID CARD must be have 9 or 12 number.");
        }
        if(!reGex.emailValidate(employee.getEmployeeEmail())) {
            map.put("email","email is not invalid! || model: huutrungg02@gmail.com");
        }
        if(!reGex.numberPositive(String.valueOf(employee.getSalary()))) {
            map.put("salary","salary must be a positive number");
        }
        if (map.isEmpty()) {
            iEmployeeRepository.save(employee);
        }
        return map;
    }

    @Override
    public List<Employee> search(String positionId, String keyWordName, String divisionId) {
        return iEmployeeRepository.search(positionId, keyWordName, divisionId);
    }

    @Override
    public Employee findById(Integer id) {

        return iEmployeeRepository.findById(id);
    }
}
