package StudentRegistration.App.Users;

import StudentRegistration.App.Section.Section;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Teacher")
public class Teacher extends User implements Serializable {

    private int teacherID;

    @JsonIgnore
    @OneToMany(targetEntity = Section.class, mappedBy = "teacher")
    private Set<Section> taughtCourses = new HashSet<>();

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public Set<Section> getTaughtCourses() {
        return taughtCourses;
    }

    public void setTaughtCourses(Set<Section> taughtCourses) {
        this.taughtCourses = taughtCourses;
    }
}
