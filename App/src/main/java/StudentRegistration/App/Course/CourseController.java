package StudentRegistration.App.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/course")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getCourse() {
        return courseService.getAllCourses();
    }

    @GetMapping(value = "/{prog}/{id}")
    public List<Course> searchCourse(@PathVariable("prog") String prog, @PathVariable("id") int id) {
        return courseService.getCourses(prog, id);
    }

}
