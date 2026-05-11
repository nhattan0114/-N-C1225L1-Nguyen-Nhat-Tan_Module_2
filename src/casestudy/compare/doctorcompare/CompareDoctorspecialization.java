package casestudy.compare.doctorcompare;

import casestudy.entity.Doctor;

import java.util.Comparator;

public class CompareDoctorspecialization implements Comparator<Doctor> {
    @Override
    public int compare(Doctor o1, Doctor o2) {
        return o1.getSpecialization().compareTo(o2.getSpecialization());
    }
}
