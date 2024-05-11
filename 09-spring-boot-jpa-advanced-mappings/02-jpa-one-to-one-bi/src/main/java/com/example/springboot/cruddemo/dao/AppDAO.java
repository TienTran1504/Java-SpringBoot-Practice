package com.example.springboot.cruddemo.dao;

import com.example.springboot.cruddemo.entity.Instructor;
import com.example.springboot.cruddemo.entity.InstructorDetail;


public interface AppDAO {
    void save(Instructor instructor);
    Instructor findInstructorById(int id);
    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);
    void deleteInstructorDetailById(int id);
//    public void update();
//    public void delete();
//    public void get();
}
