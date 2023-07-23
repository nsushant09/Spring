package com.example.neupanesushant.RestTutorial.service;

import com.example.neupanesushant.RestTutorial.model.Course;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    List<Course> list;

    public CourseServiceImpl() {
        list = new ArrayList<>();
        {
            list.add(new Course(145, "Java", "This course contains fundamentals of Java"));
            list.add(new Course(155, "Fundamentals of Multimedia", "This course contains fundamentals of Multimedia"));
            list.add(new Course(165, "Digital Security", "This course contains fundamentals of Networking"));
        }
    }

    @Override
    public List<Course> getCourses() {
        return list;
    }

    @Override
    public Course getCourse(long courseId) {
        for (Course c : list) {
            if (c.getId() == courseId) {
                return c;
            }
        }
        return null;
    }

    @Override
    public Course addCourse(Course course) {
        list.add(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
        for (Course c : list) {
            if (c.getId() == course.getId()) {
                c.setTitle(course.getTitle());
                c.setDescription(course.getDescription());
                return c;
            }
        }
        return null;
    }

    @Override
    public void deleteCourse(long courseId) {
        list = this.list.stream().filter(e -> e.getId() != courseId).collect(Collectors.toList());
    }


}
