package StudentRegistration.App.Course;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import StudentRegistration.App.Section.Section;

@Entity(name = "courses")
@IdClass(CourseID.class)
public class Course implements Serializable {

    @Id
    @Column(name = "cname")
    private String name;

    @Id
    @Column(name = "cnumber")
    private int number;

    @OneToMany(targetEntity = Section.class, mappedBy = "course")
    private Set<Section> sections = new HashSet<>();

    @ManyToMany(targetEntity = Course.class, cascade = CascadeType.ALL)
    @JoinTable(
            name = "PREREQUISITES",
            joinColumns = {
                    @JoinColumn(name = "coursename", referencedColumnName = "cname"),
                    @JoinColumn(name = "coursenumber", referencedColumnName = "cnumber")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "prerequisitename", referencedColumnName = "cname"),
                    @JoinColumn(name = "prerequisitenumber", referencedColumnName = "cnumber")
            }
    )
    private Set<Course> prerequisites = new HashSet<>();
}
