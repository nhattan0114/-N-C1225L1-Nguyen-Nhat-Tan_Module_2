package casestudy.controller;



import casestudy.entity.Patient;
import casestudy.service.impl.PatientService;

import java.util.List;

public class PatientController {
    PatientService patientService = new PatientService();

    public List<Patient> getList(){
        return patientService.getList();
    }

    public boolean add(Patient patient){
        return patientService.add(patient);
    }

    public boolean delete(String id){
        return patientService.delete(id);
    }

    public boolean update(String id,Patient patient){
        return patientService.update(id,patient);
    }

    public List<Patient> searchByName(String name){
        return patientService.searchByName(name);
    }

    public List<Patient> searchByID(String id){
        return patientService.searchByID(id);
    }

    public List<Patient> searchByHospitalDepartment(String department){
        return patientService.searchByHospitalDepartment(department);
    }

    public boolean sortByName(){
        return patientService.sortByName();
    }

    public boolean sortByID(){
        return patientService.sortByID();
    }

    public boolean sortByHospitalDepartment(){
        return patientService.sortByHospitalDepartment();
    }
}
