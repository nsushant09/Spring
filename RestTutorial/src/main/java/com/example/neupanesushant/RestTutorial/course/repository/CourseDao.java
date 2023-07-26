package com.example.neupanesushant.RestTutorial.course.repository;

import com.example.neupanesushant.RestTutorial.course.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Course : Entity that is being worked with
// Long : Datatype of Primary key of Course
@Repository
public interface CourseDao extends JpaRepository<Course, Long> {
}
