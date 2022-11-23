package StudentRegistration.App.Registration;

import StudentRegistration.App.Section.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegistrationService {

    private final RegistrationRepository registrationRepository;

    @Autowired
    public RegistrationService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }


    public List<Registration> getRegistrationsByYear(String username, int year) {
        return registrationRepository.findRegistrationByStudentAndYear(username,year);
    }

    public void addRegistration(Section section, String username) {
        List<Registration> studentsRegistrations = registrationRepository.findRegistrationByStudentAndYear(username, section.getSection_year());

        for (Registration r: studentsRegistrations) {
            System.out.println(r.getSection().getCourse().getNumber());
            System.out.println(section.getCourse().getNumber());
            if (r.getSection().equals(section)) {
                throw new RuntimeException("Student already registered in this course");
            }
            System.out.println("Not in course");
        }
    }

    public List<Registration> deleteRegistration(Section section, String username) {
        
        registrationRepository.deleteBySectionStudent(username, section);
        return registrationRepository.findRegistrationByStudentAndYear(username, section.getSection_year());
    }
}
