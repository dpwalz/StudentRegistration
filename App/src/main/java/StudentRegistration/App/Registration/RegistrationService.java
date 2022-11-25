package StudentRegistration.App.Registration;

import StudentRegistration.App.Course.Course;
import StudentRegistration.App.Section.Section;
import StudentRegistration.App.Section.SectionService;
import StudentRegistration.App.Student.Student;
import StudentRegistration.App.Student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RegistrationService {

    private final RegistrationRepository registrationRepository;
    private final StudentRepository studentRepository;
    private final SectionService sectionService;

    @Autowired
    public RegistrationService(RegistrationRepository registrationRepository, StudentRepository studentRepository, SectionService sectionService) {
        this.registrationRepository = registrationRepository;
        this.studentRepository = studentRepository;
        this.sectionService = sectionService;
    }


    public List<Registration> getRegistrationsByYear(String username, int year) {
        return registrationRepository.findRegistrationByStudent_UsernameAndSection_Sectionyear(username, year);
    }

    public void addRegistration(Section section, String username) {

        Student student = studentRepository.findStudentByUsername(username).get();
        Section s = sectionService.getSection(section);
        Set<Course> prerequisites = sectionService.getPrerequisitesBySection(section);

        if (student.getEnrolled_courses().size() >= 6) {
            throw new RuntimeException("Cannot enroll in more then 6 classes");
        }

        List<Registration> previousRegistrations = registrationRepository.findRegistrationByStudentAndSection_Course(student, section.getCourse());

        for (Registration r: previousRegistrations) {

            if (r.getSection().getSectionyear() == 2022) {
                throw new RuntimeException("Cannot take two sections of the same course");
            }

            if (!r.getGrade().equals("F")) {
                throw new RuntimeException("Cannot retake course you have already passed");
            }

        }

        // Change to all registrations that the student has to check prerequisites
        previousRegistrations = registrationRepository.findRegistrationByStudent(student);

        for (Course course: prerequisites) {

            boolean completed = false;

            for (Registration registration: previousRegistrations){
                if (registration.getSection().getCourse().equals(course)) {
                    completed = true;
                    break;
                }
            }

            if (!completed) {
                String message = "You do not have all of the required prerequisites\nPrerequisites: ";
                for (Course c: prerequisites) {
                    message += c.getName() + " " + c.getNumber() + "   ";
                }
                throw new RuntimeException(message);
            }
        }

        registrationRepository.insertRegistration(username, section.getCourse().getName(), section.getCourse().getNumber(), section.getSectionnumber(), section.getSectionyear(), "I");

    }

    public void deleteRegistration(Section section, String username) {
        
        registrationRepository.deleteBySectionStudent(username, section);

       
    }
}
