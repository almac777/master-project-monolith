package at.ac.fhcampus.master.monolith.user.repositories;

import at.ac.fhcampus.master.monolith.user.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Role, Long> {
}
