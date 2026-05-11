package casestudy.compare.patientcompare;

import casestudy.entity.Patient;

import java.util.Comparator;

public class CompareDisease implements Comparator<Patient> {
    @Override
    public int compare(Patient o1, Patient o2) {
        return o1.getDisease().compareTo(o2.getDisease());
    }
}
