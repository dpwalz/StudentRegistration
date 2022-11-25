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
}
