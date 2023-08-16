package com.example.neupanesushant.RestTutorial.course.controller;

import com.example.neupanesushant.RestTutorial.course.model.Course;
import com.example.neupanesushant.RestTutorial.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public List<Course> getCourses() {
        return this.courseService.getCourses();
    }

    @RequestMapping(value = "/courses/{courseId}", method = RequestMethod.GET)
    public ResponseEntity<HashMap<String, Course>> getCourse(@PathVariable String courseId) {
        Course course = this.courseService.getCourse(Long.parseLong(courseId));
        Course nextCourse = this.courseService.getCourse(Long.parseLong(courseId) + 10);
        HashMap<String, Course> response = new HashMap<>();
        {
            response.put("course", course);
            response.put("nextCourse", nextCourse);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
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