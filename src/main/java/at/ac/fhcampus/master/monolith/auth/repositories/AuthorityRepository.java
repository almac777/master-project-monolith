package at.ac.fhcampus.master.monolith.auth.repositories;

import at.ac.fhcampus.master.monolith.auth.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Role, Long> {
}
