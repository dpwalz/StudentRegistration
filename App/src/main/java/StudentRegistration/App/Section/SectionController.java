package StudentRegistration.App.Section;

import StudentRegistration.App.Course.Course;
import StudentRegistration.App.Course.CourseService;
import StudentRegistration.App.Registration.RegistrationService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/section")
public class SectionController {

    private final SectionService sectionService;
    private final RegistrationService registrationService;
    private final CourseService courseService;

    @Autowired
    public SectionController(SectionService sectionService, RegistrationService registrationService, CourseService courseService) {
        this.sectionService = sectionService;
        this.registrationService = registrationService;
        this.courseService = courseService;
    }

    @GetMapping
    public List<Section> getAllSections() {
        return sectionService.getAllSections();
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

    @PostMapping
    public void AddSection(@RequestBody Section section) {
        sectionService.addNewSection(section);
    }

    @PatchMapping(value = "/COURSE/{course}/NUMBER/{number}/OLDSECTION/{oldSection}/OLDYEAR/{oldYear}/SECTION/{section}/YEAR/{year}")
    public void changeSectionName(@PathVariable("course") String course, @PathVariable("number") int number, @PathVariable("oldSection") int oldSection, @PathVariable("oldYear") int oldYear, @PathVariable("section") int section, @PathVariable("year") int year) {
        sectionService.changeEntry(course, number, oldSection, oldYear, section, year);
    }

    @DeleteMapping(value = "/{prog}/NUMBER/{id}/Section/{sectionid}/YEAR/{year}")
    public void DeleteSection(@PathVariable("prog") String prog, @PathVariable("id") int id, @PathVariable("sectionid") int sectionid, @PathVariable("year") int year) {
        sectionService.deleteSection(prog, id, sectionid, year);
    }


}
