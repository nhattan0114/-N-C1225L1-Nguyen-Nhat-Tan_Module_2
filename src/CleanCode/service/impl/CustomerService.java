package CleanCode.service.impl;

import CleanCode.entity.Customer;
import CleanCode.repository.CustomerRepository;
import CleanCode.service.ICustomerService;

import java.util.ArrayList;

public class CustomerService implements ICustomerService {
    private final CustomerRepository customerRepository = new CustomerRepository();
    @Override
    public ArrayList<Customer> showList() {
        return customerRepository.getCustomerList();
    }


    @Override
    public boolean deleteCustomer(String target) {
        return customerRepository.deleteCustomer(target);

    }

    @Override
    public ArrayList<Customer> findCustomerByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return new ArrayList<>();
        }

        return customerRepository.findCustomerByName(name);
    }

    @Override
    public boolean addCustomer(Customer customer) {
        if (customer == null) {
            return false;
        }
        ArrayList<Customer> customerList = customerRepository.getCustomerList();

        if(customer.getId()==null||customer.getId().trim().isEmpty()){
            return false;
        }
        for(Customer c : customerList){
            if(c.getId().equals(customer.getId())){
                return false;
            }
        }
       return customerRepository.addCustomer(customer);

    }
}
