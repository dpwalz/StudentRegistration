package StudentRegistration.App.Users;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )

    private String username;
    private String UserPassword;
    private String FName;
    private String LName;
    private String StudentID;
    private String StudentFlag;
    private String TeacherFlag;
    private String AdminFlag;

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
    }

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public User(){

    }

    public User(String username, String userPassword) {
        this.username = username;
        this.setUserPassword(userPassword);
    }

    public User(String username, String userPassword, String FName, String LName, String studentID, String studentFlag, String teacherFlag, String adminFlag) {
        this.username = username;
        this.UserPassword = userPassword;
        this.FName = FName;
        this.LName = LName;
        this.StudentID = studentID;
        this.StudentFlag = studentFlag;
        this.TeacherFlag = teacherFlag;
        this.AdminFlag = adminFlag;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Id
    public String getUsername() {
        return username;
    }

    public String getStudentFlag() {
        return StudentFlag;
    }

    public void setStudentFlag(String studentFlag) {
        StudentFlag = studentFlag;
    }

    public String getTeacherFlag() {
        return TeacherFlag;
    }

    public void setTeacherFlag(String teacherFlag) {
        TeacherFlag = teacherFlag;
    }

    public String getAdminFlag() {
        return AdminFlag;
    }

    public void setAdminFlag(String adminFlag) {
        AdminFlag = adminFlag;
    }

    @Override
    public String toString() {
        return this.username + " " + this.getUserPassword();
    }

}
