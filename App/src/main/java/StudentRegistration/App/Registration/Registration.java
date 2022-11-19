//package StudentRegistration.App.Registration;
//
//import StudentRegistration.App.Users.User;
//
//import javax.persistence.*;
//import java.io.Serializable;
//
//@Entity
//@Table(name = "registration")
//@IdClass(RegistrationId.class)
//public class Registration implements Serializable {
//
//    @SequenceGenerator(
//            name = "registration_sequence",
//            sequenceName = "registration_sequence",
//            allocationSize = 1
//    )
//
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "registration_sequence"
//    )
//
//    @Id
//    @OneToOne(mappedBy= "USERS")
//    private User student_username;
//
//    @Id
//    private String course_program;
//
//    @Id
//    private int course_number;
//
//    private String grade;
//
//    public Registration() {
//    }
//
//    public Registration(String student_username, String course_program, int course_number, String grade) {
//        this.student_username = student_username;
//        this.course_program = course_program;
//        this.course_number = course_number;
//        this.grade = grade;
//    }
//
//    public String getStudent_username() {
//        return student_username;
//    }
//
//    public void setStudent_username(String student_username) {
//        this.student_username = student_username;
//    }
//
//    public String getCourse_program() {
//        return course_program;
//    }
//
//    public void setCourse_program(String course_program) {
//        this.course_program = course_program;
//    }
//
//    public int getCourse_number() {
//        return course_number;
//    }
//
//    public void setCourse_number(int course_number) {
//        this.course_number = course_number;
//    }
//
//    public String getGrade() {
//        return grade;
//    }
//
//    public void setGrade(String grade) {
//        this.grade = grade;
//    }
//}
