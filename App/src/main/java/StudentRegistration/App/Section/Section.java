package StudentRegistration.App.Section;

import StudentRegistration.App.Users.User;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

// https://www.youtube.com/watch?v=f5bdUjEIbrg&ab_channel=KrisFoster
@Entity
@Table(name = "sections")
@IdClass(SectionID.class)
public class Section {

    @Id
    private String course_name;

    @Id
    private int course_number;

    @Id
    private int section_number;

    @Id
    private int year;


    private User teacher;

}
