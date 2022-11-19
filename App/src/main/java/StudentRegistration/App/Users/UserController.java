package StudentRegistration.App.Users;

import org.springframework.beans.factory.annotation.Autowired;
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

            System.out.println(response.getStudent_flag());

            if (response.getStudent_flag().equals("1"))
                return "student_view";

            if (response.getTeacher_flag().equals("1"))
                return "teacher_view";

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return e.getMessage();
        }

        return "Invalid Username or Password";

    }

}
