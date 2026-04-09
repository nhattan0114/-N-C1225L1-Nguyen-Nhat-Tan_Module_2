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
    public void deleteCustomer() {

    }

    @Override
    public Customer findCustomerByName() {
        return null;
    }
}
