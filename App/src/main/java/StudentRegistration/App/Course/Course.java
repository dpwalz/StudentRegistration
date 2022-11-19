package StudentRegistration.App.Course;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "course")
@IdClass(CourseID.class)
public class Course implements Serializable {


    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )

    @Id
    private String CName;

    @Id
    private int CNumber;

    public Course() {
    }

    public Course(String CName, int CNumber) {
        this.CName = CName;
        this.CNumber = CNumber;
    }

    public String getCName() {
        return CName;
    }

    public void setCName(String CName) {
        this.CName = CName;
    }

    public int getCNumber() {
        return CNumber;
    }

    public void setCNumber(int CNumber) {
        this.CNumber = CNumber;
    }
}
