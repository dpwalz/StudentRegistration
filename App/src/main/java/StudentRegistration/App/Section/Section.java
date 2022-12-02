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
    private int sectionnumber;

    @Id
    @Column(name = "sectionyear")
    private int sectionyear;


    @JsonIgnore
    @OneToMany(targetEntity = Registration.class, cascade = CascadeType.ALL, mappedBy = "section")
    private Set<Registration> registeredStudents = new HashSet<>();

    @ManyToOne(targetEntity = Teacher.class, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "teacher")
    private Teacher teacher;

    @Id
    @ManyToOne(targetEntity = Course.class, cascade = CascadeType.REFRESH)
    @JoinColumns ({
            @JoinColumn(name = "coursename", referencedColumnName = "cname"),
            @JoinColumn(name = "coursenumber", referencedColumnName = "cnumber")
    })
    private Course course;

    public int getSectionnumber() {
        return sectionnumber;
    }

    public void setSectionnumber(int section_number) {
        this.sectionnumber = section_number;
    }

    public int getSectionyear() {
        return sectionyear;
    }

    public void setSectionyear(int section_year) {
        this.sectionyear = section_year;
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
        return sectionnumber == section.sectionnumber && sectionyear == section.sectionyear && course.equals(section.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sectionnumber, sectionyear, course);
    }

    public void addRegistration(Registration r) {
        registeredStudents.add(r);
    }
}
