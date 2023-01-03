package StudentRegistration.App.Section;

import StudentRegistration.App.Course.Course;
import StudentRegistration.App.Course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class SectionService {

    private final SectionRepository sectionRepository;
    private final CourseService courseService;

    @Autowired
    public SectionService(SectionRepository sectionRepository, CourseService courseService) {
        this.sectionRepository = sectionRepository;
        this.courseService = courseService;
    }

    public Set<Course> getPrerequisitesBySection(Section section) {
        Course c = section.getCourse();
        return courseService.getPrerequisitesByCourse(c);
    }

    public Section getSection(Section section) {
        return sectionRepository.findSectionByCourseAndSectionnumberAndSectionyear(section.getCourse(), section.getSectionnumber(), section.getSectionyear());
    }

    public List<Section> getSectionsByCourse(String prog, int id) {

        return sectionRepository.findSectionByCourse_NameAndCourse_Number(prog, id);

    }

    public List<Section> getAllSections() {
        return (List<Section>) sectionRepository.findAll();
    }

    public void addNewSection(Section section) {
        String cname = section.getCourse().getName();
        int cnum = section.getCourse().getNumber();

        List<Section> existingSections = sectionRepository.findSectionByCourse_NameAndCourse_Number(cname, cnum);

        if (existingSections.size() == 0)
            return;

        for (Section s : existingSections) {
            if (s.getSectionnumber() == section.getSectionnumber() && s.getSectionyear() == section.getSectionyear()) {
                return;
            }
        }

        sectionRepository.insertSection(cname, cnum, section.getSectionnumber(), section.getSectionyear(), section.getTeacher());
    }

    public void deleteSection(String prog, int id, int sectionid, int year) {
        sectionRepository.deleteSectionByCourse_NameAndCourse_NumberAndSectionnumberAndSectionyear(prog, id, sectionid, year);
    }

    public void changeEntry(String course, int number, int oldSection, int oldYear, int section, int year) {
        sectionRepository.updateSection(course, number, oldSection, oldYear, section, year);
    }
}
