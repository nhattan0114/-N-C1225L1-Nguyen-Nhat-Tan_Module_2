package casestudy.service.impl;

import casestudy.entity.Patient;
import casestudy.repository.PatientRepository;
import casestudy.service.IPatientService;
import casestudy.service.IService;


import java.util.ArrayList;
import java.util.List;

public class PatientService implements IPatientService {

    PatientRepository patientRepository = new PatientRepository();

    @Override
    public List<Patient> getList() {
        return patientRepository.getPatientList();
    }
    @Override
    public boolean add(Patient patient) {
        if(patient==null){
            return false;
        }
        List<Patient> patients = patientRepository.getPatientList();
        if(patient.getPatientID()==null||patient.getPatientID().trim().isEmpty()){
            return false;
        }
        for(Patient p : patients){
            if(p.getPatientID().equalsIgnoreCase(patient.getPatientID())){
                return false;
            }
        }
        return patientRepository.addPatient(patient);
    }

    @Override
    public boolean delete(String id) {
        if(id==null||id.trim().isEmpty()){
            return false;
        }
        return patientRepository.deletePatient(id);
    }

    @Override
    public boolean update(String id, Patient newPatient) {
        if (id == null || id.trim().isEmpty() || newPatient == null){
            return false;
        }
        return patientRepository.updatePatient(id,newPatient);
    }

    @Override
    public List<Patient> searchByName(String name) {
        if(name==null||name.trim().isEmpty()){
            return new ArrayList<>();
        }

        return patientRepository.searchByName(name);
    }

    @Override
    public Patient searchByID(String id) {
        if (id == null || id.trim().isEmpty()){
            return null;
        }
        return patientRepository.searchByID(id);
    }

    @Override
    public List<Patient>searchByDisease(String disease) {
        if (disease==null||disease.trim().isEmpty()){
            return new ArrayList<>();
        }
        return patientRepository.searchByDisease(disease);
    }


    @Override
    public boolean sortByName() {
        return patientRepository.sortByName();
    }

    @Override
    public boolean sortByPatientID() {
         return patientRepository.sortByID();
    }

    @Override
    public boolean sortByDisease() {
        return patientRepository.sortByDisease();
    }


}
