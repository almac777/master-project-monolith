package at.ac.fhcampus.master.monolith.auth.entities;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "roles")
@Builder
public class Authority implements GrantedAuthority {

    @Id @GeneratedValue private Long id;

    private String authority;

}
