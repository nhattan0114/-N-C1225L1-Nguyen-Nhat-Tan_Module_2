package casestudy.repository;

import casestudy.compare.CompareByName;
import casestudy.compare.patientcompare.CompareDisease;
import casestudy.compare.patientcompare.ComparePatientID;
import casestudy.entity.Patient;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PatientRepository {
    private static final String FILE_PATH = "src/casestudy/data/Patient.csv";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public ArrayList<Patient> getPatientList(){

        ArrayList<Patient> patientList = new ArrayList<>();

        try(FileReader fileReader=new FileReader(FILE_PATH);
            BufferedReader bufferedReader=new BufferedReader(fileReader)){
            String line;
            String[] data;
            Patient patient;
            while ((line=bufferedReader.readLine())!=null){
                if (line.trim().isEmpty()){
                    continue;
                }
                data=line.split(",");
                patient=new Patient(data[0], LocalDate.parse(data[1], DATE_FORMATTER),data[2],LocalDate.parse(data[3],DATE_FORMATTER),data[4],data[5],data[6] );
                patientList.add(patient);
            }
        }catch (FileNotFoundException e){
            System.out.println("Không tìm thấy file!");
        }catch (IOException e){
            System.out.println("Lỗi đọc file!");
        }

        return patientList;
    }

    public String converterPatientToString(Patient patient){
        String dob=patient.getDob().format(DATE_FORMATTER);
        String admissionDate=patient.getAdmissionDate().format(DATE_FORMATTER);
        return patient.getPatientID()+","+dob+","+patient.getName()+","+admissionDate+","+patient.getAddress()+","+patient.getPhoneNumber()+","+patient.getDisease();
    }

    public boolean saveDoctorList(ArrayList<Patient> patientList){
        try(FileWriter fileWriter=new FileWriter(FILE_PATH,false);
            BufferedWriter bufferedWriter =new BufferedWriter(fileWriter)){
            for(Patient patient : patientList){
                bufferedWriter.write(converterPatientToString(patient));
                bufferedWriter.newLine();
            }
            return true;
        }catch (IOException e){
            System.out.println("Lỗi ghi file!");
            return false;
        }
    }

    public boolean addPatient(Patient patient){
        try(FileWriter fileWriter=new FileWriter(FILE_PATH,true);
            BufferedWriter bufferedWriter =new BufferedWriter(fileWriter)){
            bufferedWriter.write(converterPatientToString(patient));
            bufferedWriter.newLine();
            return true;
        }catch (IOException e){
            System.out.println("Lỗi ghi file!");
            return false;
        }
    }

    public boolean deletePatient(String id){
        ArrayList<Patient> patientlist = getPatientList();
        patientlist.removeIf(patient -> patient.getPatientID().toLowerCase().equals(id));
        return saveDoctorList(patientlist);
    }

    public boolean updatePatient(String id,Patient patient){
        ArrayList<Patient> patientList = getPatientList();
        for(Patient p : patientList){
            if(p.getPatientID().toLowerCase().equals(id)){
                p.setPatientID(patient.getPatientID());
                p.setName(patient.getName());
                p.setDob(patient.getDob());
                p.setAdmissionDate(patient.getAdmissionDate());
                p.setAddress(patient.getAddress());
                p.setPhoneNumber(patient.getPhoneNumber());
                p.setDisease(patient.getDisease());
            }
        }
        return saveDoctorList(patientList);
    }

    public Patient searchByID(String id){
        List<Patient> patientList = getPatientList();
        for(Patient p : patientList){
            if (p.getPatientID().toLowerCase().equals(id)){
                return p;
            }
        }
        return null;
    }

    public List<Patient> searchByName(String name){
        List<Patient> patientList = getPatientList();
        List<Patient> result = new ArrayList<>();
        for(Patient p : patientList){
            if (p.getName().toLowerCase().contains(name.toLowerCase())){
                result.add(p);
            }
        }
        return result;
    }

    public List<Patient> searchByDisease(String disease){
        List<Patient> patientList = getPatientList();
        List<Patient> result = new ArrayList<>();
        for(Patient p : patientList){
            if (p.getDisease().toLowerCase().contains(disease.toLowerCase())){
                result.add(p);
            }
        }
        return result;
    }

    public boolean sortByName(){
        List<Patient> patientList = getPatientList();
        patientList.sort(new CompareByName<>());
        return saveDoctorList(new ArrayList<>(patientList));
    }

    public boolean sortByDisease(){
        List<Patient> patientList = getPatientList();
        patientList.sort(new CompareDisease());
        return saveDoctorList(new ArrayList<>(patientList));
    }

    public boolean sortByID(){
        List<Patient> patientList = getPatientList();
        patientList.sort(new ComparePatientID());
        return saveDoctorList(new ArrayList<>(patientList));
    }
}
