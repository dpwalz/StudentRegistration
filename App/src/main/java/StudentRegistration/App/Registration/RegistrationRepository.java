package StudentRegistration.App.Registration;

import StudentRegistration.App.Course.Course;
import StudentRegistration.App.Student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import StudentRegistration.App.Section.Section;

import java.util.List;

@Transactional
@Repository
public interface RegistrationRepository extends JpaRepository<Registration, RegistrationId> {

    List<Registration> findRegistrationByStudent(String Student);

    List<Registration> findRegistrationByStudent_UsernameAndSection_Sectionyear(String username, int section_year);
    List<Registration> findRegistrationByStudentAndSection_Course(Student student, Course course);
    List<Registration> findRegistrationByStudent(Student student);
    int countRegistrationsBySection(Section s);

    @Modifying
    @Query(
            value = "INSERT INTO REGISTRATIONS (StudentUsername, CourseName, CourseNumber, SectionNumber, SectionYear, Grade) VALUES (:user, :name, :cnum, :snum, :syear, :grade)",
            nativeQuery = true)
    void insertRegistration(@Param("user") String username, @Param("name") String name, @Param("cnum") int coursenumber, @Param("snum") int sectionnumber, @Param("syear") int year, @Param("grade") String grade);
    
    @Modifying
    @Query(value = "DELETE FROM Registration r WHERE r.student.username = ?1 and r.section = ?2")
    void deleteBySectionStudent(String username, Section section);



}
