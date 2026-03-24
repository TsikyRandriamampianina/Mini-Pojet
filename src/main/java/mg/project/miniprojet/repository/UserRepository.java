package mg.project.miniprojet.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import mg.project.miniprojet.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}