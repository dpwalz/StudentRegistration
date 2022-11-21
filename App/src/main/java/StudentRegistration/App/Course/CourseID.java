package StudentRegistration.App.Course;

import java.io.Serializable;
import java.util.Objects;

public class CourseID implements Serializable {

    private String name;
    private int number;

    public CourseID() {

    }

    public CourseID(String name, int number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CourseID)) return false;
        CourseID courseID = (CourseID) o;
        return number == courseID.number && Objects.equals(name, courseID.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number);
    }
}
