package at.ac.fhcampus.master.monolith.auth.repositories;

import at.ac.fhcampus.master.monolith.auth.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
