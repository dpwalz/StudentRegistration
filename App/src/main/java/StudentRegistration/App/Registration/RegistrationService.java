package StudentRegistration.App.Registration;

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
//        List<Registration> allRegistrations = registrationRepository.findRegistrationByStudent(username);
//        List<Registration> yearRegistrations = new ArrayList<>();
//
//        for (Registration r: allRegistrations) {
//            if (r.getSection().getSection_year() == year) {
//                yearRegistrations.add(r);
//            }
//        }
        return registrationRepository.findRegistrationByStudentAndYear(username,year);

    }
}
