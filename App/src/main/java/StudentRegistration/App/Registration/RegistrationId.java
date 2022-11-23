package StudentRegistration.App.Registration;


import StudentRegistration.App.Section.Section;
import StudentRegistration.App.Student.Student;

import java.io.Serializable;
import java.util.Objects;

public class RegistrationId implements Serializable {
    private Student student;
    private Section section;

    public RegistrationId() {
    }

    public RegistrationId(Student student, Section section) {
        this.student = student;
        this.section = section;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RegistrationId)) return false;
        RegistrationId that = (RegistrationId) o;
        return Objects.equals(student, that.student) && Objects.equals(section, that.section);
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, section);
    }
}
