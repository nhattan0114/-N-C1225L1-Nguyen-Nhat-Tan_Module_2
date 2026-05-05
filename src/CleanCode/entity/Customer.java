package CleanCode.entity;



import java.time.LocalDate;

public class Customer extends Person{
    private String id;


    public Customer(){
    }

    public Customer(String address, LocalDate dob, String name, String id) {
        super(address, dob, name);
        this.id = id;
    }

    public Customer(String id, String name, LocalDate dob, String address) {
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
        return String.format("| %-5s | %-25s | %-10s | %-10s |", this.getId(),this.getName(), this.getDob(), this.getAddress());
    }
}
