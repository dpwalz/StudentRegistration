package StudentRegistration.App.Course;

import java.io.Serializable;
import java.util.Objects;

public class CourseID implements Serializable {

    private String CNumber;
    private String CName;

    public CourseID() {

    }

    public CourseID(String CNumber, String CName) {
        this.CNumber = CNumber;
        this.CName = CName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseID courseID = (CourseID) o;
        return CNumber.equals(courseID.CNumber) && CName.equals(courseID.CName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CName, CNumber);
    }
}
