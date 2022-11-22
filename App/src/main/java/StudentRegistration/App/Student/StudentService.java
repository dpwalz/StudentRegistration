package StudentRegistration.App.Student;

import StudentRegistration.App.Section.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Optional<Student> findByUsername(String username) {
        return studentRepository.findStudentByUsername(username);
    }

    public void register(Section section, String username) {

    }
}
