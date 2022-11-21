package StudentRegistration.App.Section;

import StudentRegistration.App.Course.Course;

import java.io.Serializable;
import java.util.Objects;

public class SectionID implements Serializable {

    private Course course;
    private int section_number;
    private int section_year;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SectionID)) return false;
        SectionID sectionID = (SectionID) o;
        return section_number == sectionID.section_number && section_year == sectionID.section_year && Objects.equals(course, sectionID.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, section_number, section_year);
    }

    public SectionID(Course course, int section_number, int section_year) {
        this.course = course;
        this.section_number = section_number;
        this.section_year = section_year;
    }
}
