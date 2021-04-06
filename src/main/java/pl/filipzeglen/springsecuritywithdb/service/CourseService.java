package pl.filipzeglen.springsecuritywithdb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.filipzeglen.springsecuritywithdb.model.elearning.Course;
import pl.filipzeglen.springsecuritywithdb.model.repository.CourseRepository;

import java.util.Optional;

@Service
public class CourseService {

    private CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) { this.courseRepository = courseRepository; }

    public Optional<Course> findById(Long id) {
        return courseRepository.findById(id);
    }

    public Iterable<Course> findAll() {
        return courseRepository.findAll();
    }

    public Course save(Course course) {
        return courseRepository.save(course);
    }

    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
        save(new Course("Wzorce Projektowe", "Wielopoziomowy schemat rowiązywania jakiegoś problemu...", "Gabriel Rojek", 10, "100%"));
        save(new Course("Metody elementów skończonych", "MES...", "Andrij Milenin", 12, "100%"));
        save(new Course("Grafika komputerowa", "OpenGL i...", "Tomasz Dębiński", 12, "100%"));
        save(new Course("Programowanie rónoległe", "Tworzenie wątków...", "Krzysztof Banaś", 8, "100%"));
        save(new Course("Programowanie aplikacji okienkowych i mobilnych", "Projektowanie aplikacji...", "Łukasz Rauch", 8, "100%"));
        save(new Course("Advanced programming in C++", "Smart pointers...", "Piotr Macioł", 10, "100%"));
    }
}
