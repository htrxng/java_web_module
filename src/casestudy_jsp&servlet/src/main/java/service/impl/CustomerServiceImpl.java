package service.impl;

import model.Customer;
import repository.ICustomerRepository;
import repository.impl.CustomerRepositoryImpl;
import service.ICustomerService;
import utils.RegularExpression;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements ICustomerService {
    private static ICustomerRepository iCustomerRepository = new CustomerRepositoryImpl();
    private static RegularExpression reGex = new RegularExpression();

    public Map<String, String> save(Customer customer) {
        Map<String, String>map = new HashMap<>();
        if(customer.getCustomerName().equals("")) {
            map.put("name","Name is not be empty!");
        } else if(!customer.getCustomerName().matches("^((\\p{Lu}(\\p{Ll})+)(\\s)?)+$")) {
            map.put("name","Name is not invalid!");
        }
        if(!reGex.phoneNumberValidate(customer.getCustomerPhone())) {
            map.put("phone","Phone is not invalid! ||" +
                    "model: [090xxxxxxx]/[091xxxxxxx] \n" +
                    "or [(84)+90xxxxxxx]/[(84)+91xxxxxxxx]");
        }
        if(!reGex.passportValidate(customer.getCustomerIdCard())){
            map.put("idCard","ID Card is not invalid! || ID CARD must be have 9 or 12 number.");
        }
        if(!reGex.codeCustomerCheck(customer.getCustomerCode())){
            map.put("customerCode","customerCode: [KH-XXXX] (X is number.)");
        }
        if(!reGex.emailValidate(customer.getCustomerEmail())) {
            map.put("email","email is not invalid! || model: huutrungg02@gmail.com");
        }
        if(map.isEmpty()) {
            iCustomerRepository.save(customer);
        }
        return map;
    }

    @Override
    public Map<String, String> updateUser(Customer customer) {
        Map<String, String>map = new HashMap<>();
        if (customer.getCustomerName().equals("")) {
            map.put("name","Name is not be empty!");
        } else if (!customer.getCustomerName().matches("^((\\p{Lu}(\\p{Ll})+)(\\s)?)+$")) {
            map.put("name","Name is not invalid!");
        }
        if(!reGex.phoneNumberValidate(customer.getCustomerPhone())) {
            map.put("phone","Phone is not invalid! ||" +
                    "model: [090xxxxxxx]/[091xxxxxxx] \n" +
                    "or [(84)+90xxxxxxx]/[(84)+91xxxxxxxx]");
        }
        if(!reGex.passportValidate(customer.getCustomerIdCard())){
            map.put("idCard","ID Card is not invalid! || ID CARD must be have 9 or 12 number.");
        }
        if(!reGex.codeCustomerCheck(customer.getCustomerCode())){
            map.put("customerCode","customerCode: [KH-XXXX] (X is number.)");
        }
        if(!reGex.emailValidate(customer.getCustomerEmail())) {
            map.put("email","email is not invalid! || model: huutrungg02@gmail.com");
        }
        if(map.isEmpty()) {
            iCustomerRepository.updateUser(customer);
        }
        return map;
    }


    @Override
    public List<Customer> getList() {
        return iCustomerRepository.getList();
    }

    @Override
    public List<Customer>search(String customerTypeId,String keyWordName , String keyWordEmail) {
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
