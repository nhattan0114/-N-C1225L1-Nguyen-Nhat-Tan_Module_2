package casestudy.entity;

import java.time.LocalDate;

public class Person {
    private String name;
    private LocalDate dob;
    private String address;
    private String phoneNumber;

    public Person(){}

    public Person(String name, LocalDate dob, String address, String phoneNumber) {
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.phoneNumber = phoneNumber;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    @Override
    public String toString() {
        return String.format("| %-20s | %-10s | %-10s | %-10s |",
                this.getName(), this.getPhoneNumber(), this.getAddress(), this.getDob());
    }
}
