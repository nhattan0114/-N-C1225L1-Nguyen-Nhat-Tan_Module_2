package CleanCode.controller;

import CleanCode.entity.Customer;
import CleanCode.service.impl.CustomerService;

import java.util.ArrayList;

public class CustomerController {
    CustomerService customerService = new CustomerService();

    public ArrayList<Customer> getList(){
        return customerService.showList();
    }
    public void deleteCustomer(){

    }

    public Customer findCustomerByName(){
        return null;
    }
}
