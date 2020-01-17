package at.ac.fhcampus.master.monolith.auth.entities;

import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "roles")
@Builder
public class Authority implements GrantedAuthority {

    @Id @GeneratedValue private Long id;

    private String authority;

}
