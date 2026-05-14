package casestudy.service;

import casestudy.entity.Doctor;

import java.util.List;

public interface IDoctorService extends IService<Doctor>{
    List<Doctor> searchByName(String name);
    Doctor searchByID(String id);
    List<Doctor> searchByHospitalDepartment(String department);
    List<Doctor> getList();
    boolean sortByName();
    boolean sortByDoctorID();
    boolean sortByHospitalDepartment();
}
