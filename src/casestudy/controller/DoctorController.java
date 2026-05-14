package casestudy.controller;

import casestudy.entity.Doctor;
import casestudy.service.impl.DoctorService;

import java.util.List;

public class DoctorController {
    DoctorService doctorService = new DoctorService();

    public List<Doctor> getList(){
        return doctorService.getList();
    }

    public boolean add(Doctor doctor){
        return doctorService.add(doctor);
    }

    public boolean delete(String id){
        return doctorService.delete(id);
    }

    public boolean update(String id,Doctor doctor){
        return doctorService.update(id,doctor);
    }

    public List<Doctor> searchByName(String name){
        return doctorService.searchByName(name);
    }

    public Doctor searchByID(String id){
        return doctorService.searchByID(id);
    }

    public List<Doctor> searchByHospitalDepartment(String department){
        return doctorService.searchByHospitalDepartment(department);
    }

    public boolean sortByName(){
        return doctorService.sortByName();
    }

    public boolean sortByID(){
        return doctorService.sortByDoctorID();
    }

    public boolean sortByHospitalDepartment(){
        return doctorService.sortByHospitalDepartment();
    }
}
