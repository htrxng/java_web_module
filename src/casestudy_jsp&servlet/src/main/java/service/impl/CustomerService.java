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
        } else if(!customer.getCustomerName().matches("^[a-zA-Z ]+$")) {
            map.put("name","Name is not invalid!");
        }
        if(map.isEmpty()) {
            iCustomerRepository.save(customer);
        }
        return map;
    }


    @Override
    public List<CustomerListDTO> getList() {
        return iCustomerRepository.getList();
    }

    @Override
    public List<CustomerListDTO> search(String keyWord) {
            return iCustomerRepository.search(keyWord);
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
