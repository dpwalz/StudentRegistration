package StudentRegistration.App.Registration;

import StudentRegistration.App.Course.Course;
import StudentRegistration.App.Section.Section;
import StudentRegistration.App.Student.Student;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/registration")
public class RegistrationController {

    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/USER/{username}")
    public String allRegistrations(@PathVariable("username") String username) {
        return "pass";
    }

    @GetMapping("/USER/{username}/YEAR/{year}")
    public String allRegistrations(@PathVariable("username") String username, @PathVariable("year") int year) {
        List<Registration> registrations = registrationService.getRegistrationsByYear(username, year);
        return toJSON(registrations);
    }


    @PostMapping(path = "STUDENT/{username}")
    public String addRegistration(@RequestBody Section section, @PathVariable("username") String username) {

        System.out.println(section.getCourse().getName());
        System.out.println(section.getCourse().getNumber());
        System.out.println(section.getSection_number());
        System.out.println(section.getSection_year());
        System.out.println(username);

        registrationService.addRegistration(section, username);

        return "Pass";
    }

    @DeleteMapping(path = "STUDENT/{username}")
    public String deleteRegistration(@RequestBody Section section, @PathVariable("username") String username) {
        
        List<Registration> registrations = registrationService.deleteRegistration(section, username);
        return toJSON(registrations);
    }


    private String toJSON(List<Registration> registrations) {

        JSONObject jo;
        JSONArray ja = new JSONArray();

        for (Registration r : registrations) {
            jo = new JSONObject();

            Section section = r.getSection();
            Course course = section.getCourse();
            jo.put("cname", course.getName());
            jo.put("cnumber", course.getNumber());
            jo.put("sectionID", section.getSection_number());
            ja.put(jo);
        }

        return ja.toString();
    }

}
