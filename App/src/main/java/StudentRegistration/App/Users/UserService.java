package StudentRegistration.App.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final testRepository testRepository;

    @Autowired
    public UserService(testRepository testRepository) {
        this.testRepository = testRepository;
    }

    public List<User> getAllUsers() {
        return testRepository.findAll();
    }

}
