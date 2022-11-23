package StudentRegistration.App.Section;

import StudentRegistration.App.Course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SectionRepository extends JpaRepository<Section, SectionID> {

    Section findSectionByCourseAndSectionnumberAndSectionyear(Course course, int sectionnumber, int sectionyear);

}
