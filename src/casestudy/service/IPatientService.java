package casestudy.service;

import casestudy.entity.Patient;

import java.util.List;

public interface IPatientService extends IService<Patient>{
    List<Patient> searchByName(String name);
    Patient searchByID(String id);
    List<Patient> searchByDisease(String department);
    List<Patient> getList();
    boolean sortByName();
    boolean sortByPatientID();
    boolean sortByDisease();
}
