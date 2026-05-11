package casestudy.compare.doctorcompare;

import casestudy.entity.Doctor;
import java.util.Comparator;


public class CompareByDoctorID implements Comparator<Doctor> {
    @Override
    public int compare(Doctor o1, Doctor o2) {
        return o1.getDoctorID().compareTo(o2.getDoctorID());
    }
}
