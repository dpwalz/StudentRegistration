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

    public Set<Section> getSections() {
        return sections;
    }

    public void setSections(Set<Section> sections) {
        this.sections = sections;
    }

    public Set<Course> getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(Set<Course> prerequisites) {
        this.prerequisites = prerequisites;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
