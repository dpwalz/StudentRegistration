package StudentRegistration.App.Users;

import StudentRegistration.App.Section.Section;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

//@Entity
@Table(name = "users")
@MappedSuperclass
public abstract class User implements Serializable {

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

    public String username;
    private String user_password;
    private String FName;
    private String LName;
    private String StudentID;
    private String student_flag;
    private String teacher_flag;
    private String admin_flag;

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
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
        this.setUser_password(userPassword);
    }

    public User(String username, String userPassword, String FName, String LName, String studentID, String studentFlag, String teacherflag, String adminflag) {
        this.username = username;
        this.user_password = userPassword;
        this.FName = FName;
        this.LName = LName;
        this.StudentID = studentID;
        this.student_flag = studentFlag;
        this.teacher_flag = teacherflag;
        this.admin_flag = adminflag;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Id
    public String getUsername() {
        return username;
    }

    public String getStudent_flag() {
        return student_flag;
    }

    public void setStudent_flag(String student_flag) {
        this.student_flag = student_flag;
    }

    public String getTeacher_flag() {
        return teacher_flag;
    }

    public void setTeacher_flag(String teacher_flag) {
        this.teacher_flag = teacher_flag;
    }

    public String getAdmin_flag() {
        return admin_flag;
    }

    public void setAdmin_flag(String admin_flag) {
        this.admin_flag = admin_flag;
    }

    @Override
    public String toString() {
        return this.username + " " + this.getUser_password();
    }






}
