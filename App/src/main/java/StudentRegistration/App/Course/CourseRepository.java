package StudentRegistration.App.Course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface CourseRepository extends JpaRepository<Course, CourseID> {
    List<Course> findCourseByName(String Name);

    List<Course> findCourseByNameAndNumber(String Name, int Number);

    List<Course> findCourseByNumber(String Number);

    void deleteCourseByNameAndNumber(String name, int number);

    @Modifying
    @Query("update courses c set c.name = :name, c.number = :number  where c.number = :oldnumber and c.name = :oldname ")
    void updateCourse(@Param(value = "name") String name, @Param(value = "number") int number, @Param(value = "oldname") String oldname, @Param(value = "oldnumber") int oldnumber);

}
