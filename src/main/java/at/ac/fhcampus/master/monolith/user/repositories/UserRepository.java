package at.ac.fhcampus.master.monolith.user.repositories;

import at.ac.fhcampus.master.monolith.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
