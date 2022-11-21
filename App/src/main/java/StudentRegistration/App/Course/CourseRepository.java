package StudentRegistration.App.Course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.IdClass;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, CourseID> {
    List<Course> findCourseByName(String Name);

    List<Course> findCourseByNameAndNumber(String Name, int Number);

    List<Course> findCourseByNumber(String Number);

}
