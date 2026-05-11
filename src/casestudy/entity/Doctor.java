package casestudy.entity;

import java.time.LocalDate;

public class Doctor extends Person{
    private String specialization;
    private String doctorID;

    public Doctor(){
    }

    public Doctor(String doctorID, String specialization) {
        this.doctorID = doctorID;
        this.specialization = specialization;
    }

    public Doctor(String name, LocalDate dob, String address, String phoneNumber, String doctorID, String specialization) {
        super(name, dob, address, phoneNumber);
        this.doctorID = doctorID;
        this.specialization = specialization;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString(){
        return String.format("| %-5s | %-25s | %-20s | %-10s | %-20s | %-15s |", this.getDoctorID(),this.getName(), this.getDob(), this.getAddress(), this.getPhoneNumber(), this.getSpecialization());
    }
}
