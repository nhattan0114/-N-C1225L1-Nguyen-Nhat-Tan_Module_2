package casestudy.service;


import casestudy.entity.Doctor;

import java.util.List;

public interface IService<T> {
    boolean add(T object);
    boolean delete(String id);
    boolean update(String id,T object);

}
