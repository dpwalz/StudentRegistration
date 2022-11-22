package StudentRegistration.App.Student;

import StudentRegistration.App.Section.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping(path = "/{username}")
    public String addRegistration(@RequestBody Section section, @PathVariable("username") String username) {

//        System.out.println(section.getCourse().getName());
//        System.out.println(section.getCourse().getNumber());
//        System.out.println(section.getSection_number());
//        System.out.println(section.getSection_year());
//        System.out.println(username);

        studentService.register(section, username);

        return "Pass";
    }


}
