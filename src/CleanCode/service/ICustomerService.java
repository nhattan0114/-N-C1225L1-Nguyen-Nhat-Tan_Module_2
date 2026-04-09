package CleanCode.service;

import CleanCode.entity.Customer;

import java.util.ArrayList;

public interface ICustomerService {
    ArrayList<Customer> showList();
    void deleteCustomer();
    Customer findCustomerByName();
}
