package StudentRegistration.App.Section;

import java.io.Serializable;
import java.util.Objects;

public class SectionID implements Serializable {

    private String course_name;
    private int course_number;
    private int section_number;
    private int section_year;


    public SectionID(String course_name, int course_number, int section_number, int section_year) {
        this.course_name = course_name;
        this.course_number = course_number;
        this.section_number = section_number;
        this.section_year = section_year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SectionID)) return false;
        SectionID sectionID = (SectionID) o;
        return course_number == sectionID.course_number && section_number == sectionID.section_number && section_year == sectionID.section_year && Objects.equals(course_name, sectionID.course_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course_name, course_number, section_number, section_year);
    }
}
