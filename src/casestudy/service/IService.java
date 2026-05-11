package casestudy.service;


import casestudy.entity.Doctor;

import java.util.List;

public interface IService<T> {
    boolean add(T object);
    boolean delete(String id);
    boolean update(String id,T object);
    List<T> searchByName(String name);
    List<T> searchByID(String id);
    List<T> searchByHospitalDepartment(String department);
    List<T> getList();
    boolean sortByName();
    boolean sortByID();
    boolean sortByHospitalDepartment();
}
