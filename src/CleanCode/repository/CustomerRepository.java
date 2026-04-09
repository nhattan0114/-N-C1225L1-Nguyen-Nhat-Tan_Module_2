package CleanCode.repository;

import CleanCode.entity.Customer;

import java.time.LocalDate;
import java.util.ArrayList;

public class CustomerRepository {
    private static ArrayList<Customer> CustomerList = new ArrayList<>() ;

    static {
        CustomerList.add(new Customer("DN", LocalDate.now(),"Nguyen Nhat Tan","KH101"));
        CustomerList.add(new Customer("QN", LocalDate.now(),"Nguyen Thi Nhat Minh","KH102"));
        CustomerList.add(new Customer("Hue", LocalDate.now(),"Nguyen Tan Tai","KH103"));
    }

    public ArrayList<Customer> ShowList(){
        return CustomerList;
    }

    public void deleteCustomer(){

    }

    public Customer findCustomerByName(){
        return  null;
    }

}
