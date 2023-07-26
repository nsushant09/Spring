package com.example.neupanesushant.RestTutorial.course.service;

import com.example.neupanesushant.RestTutorial.course.model.Course;
import com.example.neupanesushant.RestTutorial.course.repository.CourseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Override
    public List<Course> getCourses() {
        return this.courseDao.findAll();
    }

    @Override
    public Course getCourse(long courseId) {
        return this.courseDao.getReferenceById(courseId);
    }

    @Override
    public Course addCourse(Course course) {
        return this.courseDao.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        return this.courseDao.save((course));
    }

    @Override
    public void deleteCourse(long courseId) {
//        list = this.list.stream().filter(e -> e.getId() != courseId).collect(Collectors.toList());
        this.courseDao.deleteById(courseId);
    }


}
