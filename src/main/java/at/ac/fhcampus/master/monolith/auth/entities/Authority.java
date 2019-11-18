package at.ac.fhcampus.master.monolith.auth.entities;

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
public class Authority implements GrantedAuthority {

    @Id @GeneratedValue private Long id;

    private String authority;

//    @Singular @ManyToMany
//    private List<User> users;

}
