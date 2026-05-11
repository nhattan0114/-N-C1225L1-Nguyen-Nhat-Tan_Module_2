package casestudy.entity;

import java.time.LocalDate;

public class Patient extends Person{
    private String patientID;
    private LocalDate admissionDate;
    private String disease;

    public Patient(){
    }

    public Patient(String patientID, LocalDate admissionDate,String disease) {
        this.patientID = patientID;
        this.admissionDate = admissionDate;
        this.disease=disease;
    }

    public Patient(String patientID, LocalDate dob, String name, LocalDate admissionDate, String address, String phoneNumber,String disease) {
        super(name, dob, address, phoneNumber);
        this.patientID = patientID;
        this.admissionDate = admissionDate;
        this.disease=disease;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    @Override
    public String toString() {
        return String.format("| %-5s | %-25s | %-20s | %-20s | %-20s | %-10s | %-15s |", this.getPatientID(),this.getName(), this.getDob(), this.getAdmissionDate(), this.getPhoneNumber(), this.getAddress(),this.getDisease());
    }
}
