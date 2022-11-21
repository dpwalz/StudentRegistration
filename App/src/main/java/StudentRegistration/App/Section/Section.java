package StudentRegistration.App.Section;

import StudentRegistration.App.Users.Student;
import StudentRegistration.App.Users.Teacher;
import StudentRegistration.App.Users.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "sections")
@IdClass(SectionID.class)
public class Section {

    @Id
    private String course_name;

    @Id
    private int course_number;

    @Id
    private int section_number;

    @Id
    private int section_year;

    @ManyToMany(targetEntity = Student.class, cascade = CascadeType.ALL)
    @JoinTable(
            name="REGISTRATION",
            joinColumns = {
                    @JoinColumn(name = "course_name"),
                    @JoinColumn(name = "course_number"),
                    @JoinColumn(name = "section_number"),
                    @JoinColumn(name = "section_year")
            },
            inverseJoinColumns = @JoinColumn(name = "student_username")
    )
    private Set<Student> enrolledStudents = new HashSet<>();


    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Teacher.class)
    @JoinColumn(name = "teacher")
    private Teacher teacher;


    public String getCourse_name() {
        return course_name;
    }

    public int getCourse_number() {
        return course_number;
    }

    public int getSection_number() {
        return section_number;
    }

    public int getSection_year() {
        return section_year;
    }

    public Set<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public Teacher getTeacher() {
        return teacher;
    }


}
