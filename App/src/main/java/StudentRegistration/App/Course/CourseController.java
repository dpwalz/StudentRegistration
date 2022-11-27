package StudentRegistration.App.Course;

import StudentRegistration.App.Section.Section;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
    public String getCourse() {

        List<Course> courses = courseService.getAllCourses();

        return toJSON(courses);

    }

    @GetMapping(value = "/{prog}/NUMBER/{id}")
    public String searchCourse(@PathVariable("prog") String prog, @PathVariable("id") int id) {

        List<Course> courses = courseService.getCourses(prog, id);
        return toJSON(courses);
    }

    private String toJSON(List<Course> courses) {

        JSONObject jo;
        JSONArray ja = new JSONArray();

        for (Course c : courses) {

            jo = new JSONObject();
            jo.put("cname", c.getName());
            jo.put("cnumber", c.getNumber());
            jo.put("sections", c.getSectionID());


            List<String> pre = new ArrayList<>();

            for (Course course: c.getPrerequisites()) {
                pre.add(course.getName() + " " + course.getNumber());
            }

            jo.put("prerequisites", pre);

            ja.put(jo);
        }

        return ja.toString();
    }
}
