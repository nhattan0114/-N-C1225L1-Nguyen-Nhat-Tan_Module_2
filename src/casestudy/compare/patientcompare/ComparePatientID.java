package casestudy.compare.patientcompare;

import casestudy.entity.Patient;

import java.util.Comparator;

public class ComparePatientID implements Comparator<Patient> {
    @Override
    public int compare(Patient o1, Patient o2) {
        return o1.getPatientID().compareTo(o2.getPatientID());
    }
}
