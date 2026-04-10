package CleanCode.service.impl;

import CleanCode.entity.Customer;
import CleanCode.repository.CustomerRepository;
import CleanCode.service.ICustomerService;

import java.util.ArrayList;

public class CustomerService implements ICustomerService {
    private CustomerRepository customerRepository = new CustomerRepository();
    @Override
    public ArrayList<Customer> showList() {
        return customerRepository.ShowList();
    }


    @Override
    public boolean deleteCustomer(String target) {
        return customerRepository.deleteCustomer(target);

    }

    @Override
    public ArrayList<Customer> findCustomerByName(String name) {
        return customerRepository.findCustomerByName(name);
    }

    @Override
    public void addCustomer(Customer customer) {
        customerRepository.addCustomer(customer);

    }
}
