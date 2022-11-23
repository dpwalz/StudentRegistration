package StudentRegistration.App.Section;

import StudentRegistration.App.Course.Course;

import java.io.Serializable;
import java.util.Objects;

public class SectionID implements Serializable {

    private Course course;

    public SectionID() {
    }

    private int sectionnumber;
    private int sectionyear;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SectionID)) return false;
        SectionID sectionID = (SectionID) o;
        return sectionnumber == sectionID.sectionnumber && sectionyear == sectionID.sectionyear && Objects.equals(course, sectionID.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, sectionnumber, sectionyear);
    }

    public SectionID(Course course, int sectionnumber, int sectionyear) {
        this.course = course;
        this.sectionnumber = sectionnumber;
        this.sectionyear = sectionyear;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getSectionnumber() {
        return sectionnumber;
    }

    public void setSectionnumber(int section_number) {
        this.sectionnumber = section_number;
    }

    public int getSectionyear() {
        return sectionyear;
    }

    public void setSectionyear(int sectionyear) {
        this.sectionyear = sectionyear;
    }
}
