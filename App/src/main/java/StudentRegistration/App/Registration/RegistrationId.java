//package StudentRegistration.App.Registration;
//
//import StudentRegistration.App.Course.CourseID;
//
//import java.io.Serializable;
//import java.util.Objects;
//
//public class RegistrationId implements Serializable {
//    private String student_username;
//    private String course_program;
//    private int course_number;
//
//    public RegistrationId(String student_username, String course_program, int course_number) {
//        this.student_username = student_username;
//        this.course_program = course_program;
//        this.course_number = course_number;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        RegistrationId other = (RegistrationId) o;
//        boolean name = student_username.equals(other.student_username);
//        boolean prog = course_program.equals(other.course_program);
//        boolean numb = course_number == other.course_number;
//
//        return name && prog && numb;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(student_username, course_program, course_number);
//    }
//
//}
