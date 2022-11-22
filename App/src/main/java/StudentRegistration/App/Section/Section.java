package StudentRegistration.App.Section;

import StudentRegistration.App.Course.Course;
import StudentRegistration.App.Registration.Registration;
import StudentRegistration.App.Teacher.Teacher;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "sections")
@IdClass(SectionID.class)
public class Section implements Serializable {

    @Id
    @Column(name = "sectionnumber")
    private int section_number;

    @Id
    @Column(name = "sectionyear")
    private int section_year;

    @OneToMany(targetEntity = Registration.class, cascade = CascadeType.ALL, mappedBy = "section")
    private Set<Registration> registeredStudents = new HashSet<>();

    @ManyToOne(targetEntity = Teacher.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher")
    private Teacher teacher;

    @Id
    @ManyToOne(targetEntity = Course.class)
    @JoinColumns ({
            @JoinColumn(name = "coursename", referencedColumnName = "cname"),
            @JoinColumn(name = "coursenumber", referencedColumnName = "cnumber")
    })
    private Course course;

    public int getSection_number() {
        return section_number;
    }

    public void setSection_number(int section_number) {
        this.section_number = section_number;
    }

    public int getSection_year() {
        return section_year;
    }

    public void setSection_year(int section_year) {
        this.section_year = section_year;
    }

    public Set<Registration> getRegisteredStudents() {
        return registeredStudents;
    }

    public void setRegisteredStudents(Set<Registration> registeredStudents) {
        this.registeredStudents = registeredStudents;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Section)) return false;
        Section section = (Section) o;
        return section_number == section.section_number && section_year == section.section_year && course.equals(section.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(section_number, section_year, course);
    }
}
