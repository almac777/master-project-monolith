package at.ac.fhcampus.master.monolith.auth.repositories;

import at.ac.fhcampus.master.monolith.auth.entities.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Long, Authority> {
}
