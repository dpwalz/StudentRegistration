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

    public CourseID(Course c) {
        this.name = c.getName();
        this.number = c.getNumber();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
