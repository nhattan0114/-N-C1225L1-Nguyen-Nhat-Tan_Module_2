package CleanCode.repository;

import CleanCode.entity.Customer;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CustomerRepository {
    private final String FILE_PATH  = "src/CleanCode/data/CustomerData.csv";

    public ArrayList<Customer> getCustomerList(){
        ArrayList<Customer> customerList = new ArrayList<>();
        try(FileReader fileReader = new FileReader(FILE_PATH);
        BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            String[] data;
            Customer customer;
            while ((line=bufferedReader.readLine())!=null){
                if (line.trim().isEmpty()){
                    continue;
                }
                data=line.split(",");
                customer=new Customer(data[0],data[1], LocalDate.parse(data[2],DateTimeFormatter.ofPattern("yyyy-MM-dd")),data[3]);
                customerList.add(customer);
            }

        }catch (FileNotFoundException e){
            System.out.println("Lỗi không tìm thấy file!");
        }catch (IOException e){
            System.out.println("Lỗi đọc file!");
        }

        return customerList;
    }


    public boolean addCustomer(Customer customer){
        try(FileWriter fileWriter = new FileWriter(FILE_PATH,true);
        BufferedWriter bufferedWriter= new BufferedWriter(fileWriter)) {
            bufferedWriter.write(converterCustomerToString(customer));
            bufferedWriter.newLine();
        }catch (IOException e){
            System.out.println("Lỗi ghi file!");
        }
        return true;
    }

    public String converterCustomerToString(Customer customer){
        String date=customer.getDob().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return customer.getId()+","+customer.getName()+","+date+","+customer.getAddress();
    }

    public boolean saveCustomerList(ArrayList<Customer> customerList){
        try(FileWriter fileWriter= new FileWriter(FILE_PATH,false);
        BufferedWriter bufferedWriter=new BufferedWriter(fileWriter)){
            for(Customer customer : customerList){
                bufferedWriter.write(converterCustomerToString(customer));
                bufferedWriter.newLine();
            }
            return true;
        }catch (IOException e){
            System.out.println("Lỗi ghi file!");
            return false;
        }
    }

    public boolean deleteCustomer(String target){
        ArrayList<Customer> CustomerList=getCustomerList();
        CustomerList.removeIf(customer -> customer.getId().equals(target));
        return saveCustomerList(CustomerList);
    }


    public ArrayList<Customer> findCustomerByName(String name){
        ArrayList<Customer> CustomerList=getCustomerList();
        ArrayList<Customer> result = new ArrayList<>();
        for(Customer customer : CustomerList){
            if(customer.getName().toLowerCase().contains(name.toLowerCase())){
                result.add(customer);
            }
        }
        return result;
    }

}
