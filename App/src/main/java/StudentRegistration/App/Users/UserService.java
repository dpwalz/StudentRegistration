package StudentRegistration.App.Users;

import StudentRegistration.App.Student.Student;
import StudentRegistration.App.Student.StudentService;
import StudentRegistration.App.Teacher.Teacher;
import StudentRegistration.App.Teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final StudentService studentService;
    private final TeacherService teacherService;

    @Autowired
    public UserService(StudentService studentService, TeacherService teacherService) {
        this.studentService = studentService;
        this.teacherService = teacherService;
    }

    public List<User> getAllUsers() {
        List<Student> students = studentService.getAllStudents();
        List<User> users = new ArrayList<>();

        for (Student student : students){
            users.add((User) student);
        }

        return users;
    }

    public User checkLoginCredentials(Login credentials) throws RuntimeException {

        Optional<Student> student = studentService.findByUsername(credentials.getUsername());
        Optional<Teacher> teacher = teacherService.findByUsername(credentials.getUsername());
        User user;

        if (student.isPresent())
            user = student.get();
        else if (teacher.isPresent()) {
            user = teacher.get();
        } else {
            throw new RuntimeException("Username not present");
        }

        if (!user.getPassword().equals(credentials.getPassword()))
            throw new RuntimeException("Password does not match");

        return user;
    }

}
