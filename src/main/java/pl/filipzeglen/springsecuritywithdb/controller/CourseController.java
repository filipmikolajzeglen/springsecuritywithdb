package pl.filipzeglen.springsecuritywithdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.filipzeglen.springsecuritywithdb.model.elearning.Course;
import pl.filipzeglen.springsecuritywithdb.service.CourseService;

import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/all")
    public Iterable<Course> getAllCourses() {
        return courseService.findAll();
    }

    @GetMapping
    public Optional<Course> getCourseById(@RequestParam Long index) {
        return courseService.findById(index);
    }

    @PostMapping
    public Course addCourse(@RequestBody Course course) {
        return courseService.save(course);
    }

    @PutMapping
    public Course updateCourse(@RequestBody Course course) {
        return courseService.save(course);
    }

    @DeleteMapping
    public void deleteCourse(@RequestParam Long index) {
        courseService.deleteById(index);
    }
}
