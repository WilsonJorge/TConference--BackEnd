package TConference.BackEnd.repository;

import TConference.BackEnd.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean findByUsername(String username);
    boolean findByEmail(String email);
}

