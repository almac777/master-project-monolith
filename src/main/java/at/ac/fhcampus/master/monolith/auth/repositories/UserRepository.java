package at.ac.fhcampus.master.monolith.auth.repositories;

import at.ac.fhcampus.master.monolith.auth.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Long, User> {
}
