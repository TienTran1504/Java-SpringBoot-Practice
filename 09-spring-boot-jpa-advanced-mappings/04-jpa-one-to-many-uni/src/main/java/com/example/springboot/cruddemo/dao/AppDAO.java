package com.example.springboot.cruddemo.dao;

import com.example.springboot.cruddemo.entity.Course;
import com.example.springboot.cruddemo.entity.Instructor;
import com.example.springboot.cruddemo.entity.InstructorDetail;

import java.util.List;


public interface AppDAO {
    void save(Instructor instructor);
    Instructor findInstructorById(int id);
    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);
    void deleteInstructorDetailById(int id);

    List<Course> findCoursesByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int id);

    void update(Instructor tempInstructor);

    void update(Course tempCourse);

    Course findCourseById(int theId);

    void deleteCourseById(int theId);

    void save(Course course);

    Course findCourseAndReviewsByCourseId(int theId);

}
