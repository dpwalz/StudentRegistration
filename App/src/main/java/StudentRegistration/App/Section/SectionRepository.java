package StudentRegistration.App.Section;

import StudentRegistration.App.Course.Course;
import StudentRegistration.App.Teacher.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface SectionRepository extends JpaRepository<Section, SectionID> {

    Section findSectionByCourseAndSectionnumberAndSectionyear(Course course, int sectionnumber, int sectionyear);
    List<Section> findSectionByCourse_NameAndCourse_Number(String Name, int number);

    void deleteSectionByCourse_NameAndCourse_NumberAndSectionnumberAndSectionyear(String courseName, int courseNumber, int sectionid, int year);

    @Modifying
    @Query(
            value = "INSERT INTO SECTIONS (CourseName, CourseNumber, SectionNumber, SectionYear, Teacher) VALUES (:cname, :cnum, :snum, :syear, :teacher)",
            nativeQuery = true)
    void insertSection(@Param("cname") String name, @Param("cnum") int coursenumber, @Param("snum") int sectionnumber, @Param("syear") int year, @Param("teacher") Teacher teacher);

    @Modifying
    @Query("update sections s set s.sectionnumber = :section, s.sectionyear = :year  where s.course.name = :course and s.course.number = :number and s.sectionnumber = :oldSection and s.sectionyear = :oldYear ")
    void updateSection(String course, int number, int oldSection, int oldYear, int section, int year);

}
