package StudentRegistration.App.Registration;

import StudentRegistration.App.Course.Course;
import StudentRegistration.App.Section.Section;
import StudentRegistration.App.Section.SectionID;
import StudentRegistration.App.Section.SectionRepository;
import StudentRegistration.App.Student.Student;
import StudentRegistration.App.Student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class RegistrationService {

    private final RegistrationRepository registrationRepository;
    private final StudentRepository studentRepository;
    private final SectionRepository sectionRepository;

    @Autowired
    public RegistrationService(RegistrationRepository registrationRepository, StudentRepository studentRepository, SectionRepository sectionRepository) {
        this.registrationRepository = registrationRepository;
        this.studentRepository = studentRepository;
        this.sectionRepository = sectionRepository;
    }


    public List<Registration> getRegistrationsByYear(String username, int year) {
        return registrationRepository.findRegistrationByStudent_UsernameAndSection_Sectionyear(username, year);
    }

    public void addRegistration(Section section, String username) {

        Student student = studentRepository.findStudentByUsername(username).get();

        if (student.getEnrolled_courses().size() >= 6) {
            throw new RuntimeException("Cannot enroll in more then 6 classes");
        }


        List<Registration> previousRegistrations = registrationRepository.findRegistrationByStudentAndSection_Course(student, section.getCourse());


        for (Registration r: previousRegistrations) {

            if (r.getSection().getSectionyear() == 2022) {
                throw new RuntimeException("Cannot retake course you have already passed");
            }

            if (!r.getGrade().equals("F")) {
                throw new RuntimeException("Cannot retake course you have already passed");
            }
        }

        registrationRepository.insertRegistration(username, section.getCourse().getName(), section.getCourse().getNumber(), section.getSectionnumber(), section.getSectionyear(), "I");

    }

    public List<Registration> deleteRegistration(Section section, String username) {
        
        registrationRepository.deleteBySectionStudent(username, section);
        return registrationRepository.findRegistrationByStudent_UsernameAndSection_Sectionyear(username, section.getSectionyear());
//        return registrationRepository.findRegistrationByStudentAndSection_Sectionyear(username, section.getSectionyear());
    }
}
