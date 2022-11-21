package StudentRegistration.App.Users;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class User implements Serializable {

    @Id
    @Column(name = "Username")
    public String username;

    @Column(name = "UPassword")
    private String password;

    @Column(name = "FName")
    private String firstName;

    @Column(name = "LName")
    private String lastName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
