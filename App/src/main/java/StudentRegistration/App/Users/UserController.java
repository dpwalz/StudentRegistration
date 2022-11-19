package StudentRegistration.App.Users;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

        JSONObject jo = new JSONObject();

        User response;

        try {

            response = userService.checkLoginCredentials(credentials);

            jo.put("username", response.getUsername());

            if (response.getStudent_flag().equals("1"))
                jo.put("endpoint", "student_view");

            if (response.getTeacher_flag().equals("1"))
                jo.put("endpoint", "teacher_view");

            jo.put("status", HttpStatus.OK);
            System.out.println("Here");

        } catch (Exception e) {
            jo.put("username", "");
            jo.put("endpoint", "");
            jo.put("status", HttpStatus.NOT_FOUND.ordinal());
        }

        String s = jo.toString();
        System.out.println(s);
        return s;

    }

}
