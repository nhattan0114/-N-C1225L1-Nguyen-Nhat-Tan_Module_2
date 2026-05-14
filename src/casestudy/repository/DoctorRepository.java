package casestudy.repository;

import casestudy.compare.CompareByName;
import casestudy.compare.doctorcompare.CompareByDoctorID;
import casestudy.compare.doctorcompare.CompareDoctorspecialization;
import casestudy.entity.Doctor;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DoctorRepository {
     private static final String FILE_PATH = "src/casestudy/data/DoctorData.csv";
     private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public ArrayList<Doctor> getDoctorList(){

        ArrayList<Doctor> doctorList = new ArrayList<>();

        try(FileReader fileReader=new FileReader(FILE_PATH);
            BufferedReader bufferedReader=new BufferedReader(fileReader)){
            String line;
            String[] data;
            Doctor doctor;
            while ((line=bufferedReader.readLine())!=null){
                if (line.trim().isEmpty()){
                    continue;
                }
                data=line.split(",");
                doctor=new Doctor(data[0], LocalDate.parse(data[1], DATE_FORMATTER),data[2],data[3],data[4],data[5] );
                doctorList.add(doctor);
            }
        }catch (FileNotFoundException e){
            System.out.println("Không tìm thấy file!");
        }catch (IOException e){
            System.out.println("Lỗi đọc file!");
        }

        return doctorList;
    }

    public String converterDoctorToString(Doctor doctor){
        String date=doctor.getDob().format(DATE_FORMATTER);
        return doctor.getName()+","+date+","+doctor.getAddress()+","+doctor.getPhoneNumber()+","+doctor.getDoctorID()+","+doctor.getSpecialization();
    }

    public boolean saveDoctorList(ArrayList<Doctor> doctorList){
        try(FileWriter fileWriter=new FileWriter(FILE_PATH,false);
        BufferedWriter bufferedWriter =new BufferedWriter(fileWriter)){
            for(Doctor doctor : doctorList){
                bufferedWriter.write(converterDoctorToString(doctor));
                bufferedWriter.newLine();
            }
            return true;
        }catch (IOException e){
            System.out.println("Lỗi ghi file!");
            return false;
        }
    }

    public boolean addDoctor(Doctor doctor){
        try(FileWriter fileWriter=new FileWriter(FILE_PATH,true);
        BufferedWriter bufferedWriter =new BufferedWriter(fileWriter)){
            bufferedWriter.write(converterDoctorToString(doctor));
            bufferedWriter.newLine();
            return true;
        }catch (IOException e){
            System.out.println("Lỗi ghi file!");
            return false;
        }
    }

    public boolean deleteDoctor(String id){
        ArrayList<Doctor> doctorList = getDoctorList();
        doctorList.removeIf(doctor -> doctor.getDoctorID().toLowerCase().equals(id));
        return saveDoctorList(doctorList);
    }

    public boolean updateDoctor(String id,Doctor doctor){
        ArrayList<Doctor> doctorList = getDoctorList();
        for(Doctor d : doctorList){
            if(d.getDoctorID().toLowerCase().equals(id)){
                d.setDoctorID(doctor.getDoctorID());
                d.setName(doctor.getName());
                d.setDob(doctor.getDob());
                d.setAddress(doctor.getAddress());
                d.setPhoneNumber(doctor.getPhoneNumber());
                d.setSpecialization(doctor.getSpecialization());
            }
        }
        return saveDoctorList(doctorList);
    }

    public Doctor searchByID(String id){
        List<Doctor> doctorList = getDoctorList();
        for(Doctor d : doctorList){
            if (d.getDoctorID().toLowerCase().equals(id)){
                return d;
            }
        }
        return null;
    }

    public List<Doctor> searchByName(String name){
        List<Doctor> doctorList = getDoctorList();
        List<Doctor> result = new ArrayList<>();
        for(Doctor d : doctorList){
            if (d.getName().toLowerCase().contains(name.toLowerCase())){
                result.add(d);
            }
        }
        return result;
    }

    public List<Doctor> searchBySpecialization(String specialization){
        List<Doctor> doctorList = getDoctorList();
        List<Doctor> result = new ArrayList<>();
        for(Doctor d : doctorList){
            if (d.getSpecialization().toLowerCase().contains(specialization.toLowerCase())){
                result.add(d);
            }
        }
        return result;
    }

    public boolean sortByName(){
        List<Doctor> doctorList = getDoctorList();
        doctorList.sort(new CompareByName<>());
        return saveDoctorList(new ArrayList<>(doctorList));
    }

    public boolean sortByHospitalDepartment(){
        List<Doctor> doctorList = getDoctorList();
        doctorList.sort(new CompareDoctorspecialization());
        return saveDoctorList(new ArrayList<>(doctorList));
    }

    public boolean sortByID(){
        List<Doctor> doctorList = getDoctorList();
        doctorList.sort(new CompareByDoctorID());
        return saveDoctorList(new ArrayList<>(doctorList));
    }

}
