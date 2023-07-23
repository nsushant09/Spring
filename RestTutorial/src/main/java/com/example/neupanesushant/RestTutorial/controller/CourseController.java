package com.example.neupanesushant.RestTutorial.controller;

import com.example.neupanesushant.RestTutorial.model.Course;
import com.example.neupanesushant.RestTutorial.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public List<Course> getCourses() {
        return this.courseService.getCourses();
    }

    @RequestMapping(value = "/courses/{courseId}", method = RequestMethod.GET)
    public Course getCourse(@PathVariable String courseId) {
        return this.courseService.getCourse(Long.parseLong(courseId));
    }

    @RequestMapping(value = "/courses", method = RequestMethod.POST)
    public Course addCourse(@RequestBody Course course) {
        return this.courseService.addCourse(course);
    }

    @RequestMapping(value = "/courses", consumes = "application/json", method = RequestMethod.PUT)
    public Course updateCourse(@RequestBody Course course) {
        return this.courseService.updateCourse(course);
    }

    @RequestMapping(value = "/courses/{courseId}", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {
        try {
            this.courseService.deleteCourse(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
