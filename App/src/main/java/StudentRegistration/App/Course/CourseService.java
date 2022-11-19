package StudentRegistration.App.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        CourseID cid = new CourseID(id, program);
//        System.out.println(program);
        return courseRepository.findCourseByCNameAndCNumber(program, id);
    }
}
