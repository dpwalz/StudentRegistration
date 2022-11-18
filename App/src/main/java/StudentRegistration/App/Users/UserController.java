package StudentRegistration.App.Users;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }


    @PutMapping
    public String postUser(@RequestBody Login credentials) {

        User response;
        try {

            response = userService.checkLoginCredentials(credentials);

            if (response.getStudentFlag().equals("1"))
                return "student_view";

            if (response.getTeacherFlag().equals("1"))
                return "teacher_view";

        } catch (Exception e) {
        }

        return "Invalid Username or Password";

    }

}
