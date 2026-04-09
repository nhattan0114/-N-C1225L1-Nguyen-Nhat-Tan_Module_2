package CleanCode.entity;

import com.sun.javafx.binding.StringFormatter;

import java.time.LocalDate;

public class Customer extends Person{
    private String id;


    public Customer(){
    }

    public Customer(String address, LocalDate dob, String name, String id) {
        super(address, dob, name);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Customer's name: "+super.getName()+" , "+"ID: "+ this.getId()+" , DOB: "+super.getDob()+" , ADD: "+super.getAddress();
    }
}
