package StudentRegistration.App.Course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findCourseByCName(String CName);

    List<Course> findCourseByCNameAndCNumber(String CName, int CNumber);

    List<Course> findCourseByCNumber(String CNumber);

}
