package StudentRegistration.App.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public List<Course> getCourses(String program, int id) {
        return courseRepository.findCourseByNameAndNumber(program, id);
    }

    public Set<Course> getPrerequisitesByCourse(Course c) {
        List<Course> courses = courseRepository.findCourseByNameAndNumber(c.getName(), c.getNumber());

        if (courses.size() != 1)
            throw new RuntimeException("Course not found");

        Course course = courses.get(0);
        return course.getPrerequisites();
    }
}
