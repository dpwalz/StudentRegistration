package StudentRegistration.App.Users;

import StudentRegistration.App.Section.Section;
import StudentRegistration.App.Section.SectionID;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "student")
public class Student extends User implements Serializable {

    private int student_id;

    @JsonIgnore
    @ManyToMany(targetEntity = Section.class, mappedBy = "enrolledStudents", cascade = CascadeType.ALL)
    private Set<Section> courses_test = new HashSet<>();

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public Set<Section> getCourses_test() {
        return courses_test;
    }

    public void setCourses_test(Set<Section> courses_test) {
        this.courses_test = courses_test;
    }
}
