package StudentRegistration.App.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface testRepository extends JpaRepository<User, Long> {

    Optional<User> findStudentByUsername(String Username);

}

