package CleanCode.repository;

import CleanCode.entity.Customer;

import java.time.LocalDate;
import java.util.ArrayList;

public class CustomerRepository {
    private static final ArrayList<Customer> CustomerList = new ArrayList<>() ;

    static {
        CustomerList.add(new Customer("DN", LocalDate.now(),"Nguyen Nhat Tan","KH101"));
        CustomerList.add(new Customer("QN", LocalDate.now(),"Nguyen Thi Nhat Minh","KH102"));
        CustomerList.add(new Customer("Hue", LocalDate.now(),"Nguyen Tan Tai","KH103"));
    }

    public ArrayList<Customer> ShowList(){
        return CustomerList;
    }

    public boolean deleteCustomer(String target){
        for (Customer cus: CustomerList){
            if(target.equalsIgnoreCase(cus.getId())){
                CustomerList.remove(cus);
                return true;
            }
        }
        return false;
    }

    public void addCustomer(Customer customer){
        CustomerList.add(customer);
    }

    public ArrayList<Customer> findCustomerByName(String name){
        ArrayList<Customer> result = new ArrayList<>();

        if (name == null || name.trim().isEmpty()) {
            return result;
        }

        for (Customer cus :CustomerList){
            if (cus.getName()!=null &&cus.getName().toLowerCase().contains(name.toLowerCase())){
                result.add(cus);
            }
        }
        return result;
    }

}
