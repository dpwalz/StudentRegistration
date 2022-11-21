package StudentRegistration.App.Course;

import java.io.Serializable;
import java.util.Objects;

public class CourseID implements Serializable {

    private int name;
    private String number;

    public CourseID() {

    }

    public CourseID(int name, String number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CourseID)) return false;
        CourseID courseID = (CourseID) o;
        return name == courseID.name && Objects.equals(number, courseID.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number);
    }
}
