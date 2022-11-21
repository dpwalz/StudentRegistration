package StudentRegistration.App.Users;

import StudentRegistration.App.Student.Student;
import StudentRegistration.App.Student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final StudentService studentService;

    @Autowired
    public UserService(StudentService studentService) {
        this.studentService = studentService;
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
        User user = student.get();

        if (!user.getPassword().equals(credentials.getPassword()))
            throw new RuntimeException("Password does not match");

        return user;
    }

}
