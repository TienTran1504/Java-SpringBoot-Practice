package com.example.springboot.cruddemo.dao;

import com.example.springboot.cruddemo.entity.Instructor;


public interface AppDAO {
    void save(Instructor instructor);
    Instructor findInstructorById(int id);
    void deleteInstructorById(int id);
//    public void update();
//    public void delete();
//    public void get();
}
