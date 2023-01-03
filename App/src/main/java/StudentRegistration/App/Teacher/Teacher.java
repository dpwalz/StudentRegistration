package StudentRegistration.App.Teacher;

import StudentRegistration.App.Section.Section;
import StudentRegistration.App.Users.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "teachers")
public class Teacher extends User implements Serializable {

    // Map the teacher to the sections they teach, stored as teacher in the Section table
    @JsonIgnore
    @OneToMany(targetEntity = Section.class, mappedBy = "teacher")
    private Set<Section> taughtCourses = new HashSet<>();

    public Set<Section> getTaughtCourses() {
        return taughtCourses;
    }

    public void setTaughtCourses(Set<Section> taughtCourses) {
        this.taughtCourses = taughtCourses;
    }
}

