package StudentRegistration.App.Section;

import StudentRegistration.App.Registration.RegistrationService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/section")
public class SectionController {

    private final SectionService sectionService;
    private final RegistrationService registrationService;

    @Autowired
    public SectionController(SectionService sectionService, RegistrationService registrationService) {
        this.sectionService = sectionService;
        this.registrationService = registrationService;
    }

    @GetMapping(value = "/COURSE/{prog}/NUMBER/{id}")
    public String searchCourse(@PathVariable("prog") String prog, @PathVariable("id") int id) {
        List<Section>  sections = sectionService.getSectionsByCourse(prog, id);

        JSONObject jo;
        JSONArray ja = new JSONArray();

        for(Section section: sections) {
            jo = new JSONObject();
            jo.put("Number", section.getSectionnumber());
            jo.put("Year", section.getSectionyear());
            jo.put("Students", registrationService.registeredStudents(section));

            ja.put(jo);
        }

        return ja.toString();

    }


}
