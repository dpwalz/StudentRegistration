package StudentRegistration.App.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User checkLoginCredentials(Login credentials) throws RuntimeException {
        Optional<User> entry = userRepository.findUserByUsername(credentials.getUsername());
        User user = entry.get();

        if (!user.getUserPassword().equals(credentials.getPassword()))
            throw new RuntimeException("Password does not match");

        return user;
    }

}
