package CleanCode.controller;

import CleanCode.entity.Customer;
import CleanCode.service.impl.CustomerService;

import java.util.ArrayList;

public class CustomerController {
    CustomerService customerService = new CustomerService();

    public ArrayList<Customer> getList(){
        return customerService.showList();
    }

    public boolean deleteCustomer(String target){
       return customerService.deleteCustomer(target);
    }

    public void addCustomer(Customer customer){
        customerService.addCustomer(customer);
    }

    public ArrayList<Customer> findCustomerByName(String name){
        return customerService.findCustomerByName(name);
    }
}
