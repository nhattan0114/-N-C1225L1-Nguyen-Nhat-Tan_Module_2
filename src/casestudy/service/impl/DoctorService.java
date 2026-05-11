package casestudy.service.impl;

import casestudy.entity.Doctor;
import casestudy.repository.DoctorRepository;
import casestudy.service.IService;

import java.util.ArrayList;
import java.util.List;

public class DoctorService implements IService<Doctor> {

    DoctorRepository doctorRepository= new DoctorRepository();

    @Override
    public List<Doctor> getList() {
        return doctorRepository.getDoctorList();
    }

    @Override
    public boolean add(Doctor doctor) {
        if(doctor==null){
            return false;
        }
        ArrayList<Doctor> doctors = doctorRepository.getDoctorList();
        if(doctor.getDoctorID()==null||doctor.getDoctorID().trim().isEmpty()){
            return false;
        }
        for(Doctor d : doctors){
            if(d.getDoctorID().equalsIgnoreCase(doctor.getDoctorID())){
                return false;
            }
        }
        return doctorRepository.addDoctor(doctor);
    }

    @Override
    public boolean delete(String id) {
        if(id==null||id.trim().isEmpty()){
            return false;
        }

        return doctorRepository.deleteDoctor(id);
    }

    @Override
    public boolean update(String id,Doctor newDoctor) {
        if(id==null||id.trim().isEmpty()||newDoctor==null){
            return false;
        }
        return doctorRepository.updateDoctor(id,newDoctor);
    }

    @Override
    public List<Doctor> searchByName(String name) {
        if(name==null||name.trim().isEmpty()){
            return new ArrayList<>();
        }
        return doctorRepository.searchByName(name);
    }

    @Override
    public List<Doctor> searchByID(String id) {
        if(id==null||id.trim().isEmpty()){
            return new ArrayList<>();
        }
        return doctorRepository.searchByID(id);
    }

    @Override
    public List<Doctor> searchByHospitalDepartment(String department) {
        if(department==null||department.trim().isEmpty()){
            return new ArrayList<>();
        }
        return doctorRepository.searchBySpecialization(department);
    }

    @Override
    public boolean sortByName() {
        return doctorRepository.sortByName();
    }

    @Override
    public boolean sortByID() {
        return doctorRepository.sortByID();
    }

    @Override
    public boolean sortByHospitalDepartment() {
        return doctorRepository.sortByHospitalDepartment();
    }
}
