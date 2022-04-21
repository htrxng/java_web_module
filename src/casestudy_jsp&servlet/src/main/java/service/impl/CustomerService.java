package service.impl;

import dto.CustomerListDTO;
import model.Customer;
import repository.ICustomerRepository;
import repository.impl.CustomerRepository;
import service.ICustomerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService implements ICustomerService {
    private static ICustomerRepository iCustomerRepository = new CustomerRepository();

    public Map<String, String> save(Customer customer) {
        Map<String, String>map = new HashMap<>();
        if(customer.getCustomerName().equals("")) {
            map.put("name","Name is not be empty!");
        } else if(!customer.getCustomerName().matches("^((\\p{Lu}(\\p{Ll})+)(\\s)?)+$")) {
            map.put("name","Name is not invalid!");
        }
        if(map.isEmpty()) {
            iCustomerRepository.save(customer);
        }
        return map;
    }

    @Override
    public String updateUser(Customer customer) {
        String notice = "";
        if (customer.getCustomerName().equals("")) {
            notice = "Customer can not be empty!";
        } else if (!customer.getCustomerName().matches("^((\\p{Lu}(\\p{Ll})+)(\\s)?)+$")) {
            notice = "User Name is invalid!";
        }
        if (notice.equals("")) {
            iCustomerRepository.updateUser( customer);
            notice = "Update successful!";
        }
        return notice;
    }


    @Override
    public List<Customer> getList() {
        return iCustomerRepository.getList();
    }

    @Override
    public List<Customer> search(String customerTypeId,String keyWordName , String keyWordEmail) {
            return iCustomerRepository.search(customerTypeId,keyWordName,keyWordEmail);
    }

    @Override
    public void remove(Integer id) {
        iCustomerRepository.remove(id);
    }

    @Override
    public Customer findByID(Integer id) {
        return iCustomerRepository.findById(id);
    }
}
