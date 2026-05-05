package CleanCode.service;

import CleanCode.entity.Customer;

import java.util.ArrayList;

public interface ICustomerService {
    ArrayList<Customer> showList();


    boolean deleteCustomer(String target);

    ArrayList<Customer> findCustomerByName(String name);
    boolean addCustomer(Customer customer);
}
