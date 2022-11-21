package StudentRegistration.App.Student;

import StudentRegistration.App.Registration.Registration;
import StudentRegistration.App.Users.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "students")
public class Student extends User implements Serializable {

    @Column(name = "studentid")
    private int studentID;

    @Column(name = "major")
    private String major;

    @JsonIgnore
    @OneToMany(targetEntity = Registration.class, mappedBy = "student", cascade = CascadeType.ALL)
    private Set<Registration> enrolled_courses = new HashSet<>();

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Set<Registration> getEnrolled_courses() {
        return enrolled_courses;
    }

    public void setEnrolled_courses(Set<Registration> enrolled_courses) {
        this.enrolled_courses = enrolled_courses;
    }

}
