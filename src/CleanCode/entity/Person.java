package CleanCode.entity;

import java.time.LocalDate;

public class Person {
    private String name;
    private LocalDate dob;
    private String address;


    public Person(){
    }

    public Person(String address, LocalDate dob, String name) {
        this.address = address;
        this.dob = dob;
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                '}';
    }
}
