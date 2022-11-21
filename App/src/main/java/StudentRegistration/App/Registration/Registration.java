package StudentRegistration.App.Registration;

import StudentRegistration.App.Section.Section;
import StudentRegistration.App.Student.Student;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "registrations")
public class Registration implements Serializable {

    @Id
    @ManyToOne(targetEntity = Student.class)
    @JoinColumn(name = "studentusername", referencedColumnName = "username")
    private Student student;

    @Id
    @ManyToOne(targetEntity = Section.class)
    @JoinColumns ({
        @JoinColumn(name = "coursename"),
        @JoinColumn(name = "coursenumber"),
        @JoinColumn(name = "sectionnumber"),
        @JoinColumn(name = "sectionyear")
    })
    private Section section;

    @Column(name = "Grade")
    private String grade;


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
