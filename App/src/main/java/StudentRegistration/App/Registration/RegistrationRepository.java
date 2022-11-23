package StudentRegistration.App.Registration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import StudentRegistration.App.Section.Section;

import java.util.List;

@Transactional
@Repository
public interface RegistrationRepository extends JpaRepository<Registration, RegistrationId> {

    List<Registration> findRegistrationByStudent(String Student);

    @Query(value = "SELECT r FROM Registration r WHERE r.student.username = ?1 and r.section.section_year = ?2")
    List<Registration> findRegistrationByStudentAndYear(String student, int year);

    @Modifying
    @Query(value = "DELETE FROM Registration r WHERE r.student.username = ?1 and r.section = ?2")
    void deleteBySectionStudent(String username, Section section);

}
