package at.ac.fhcampus.master.monolith.auth.dtos;

import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
public class AuthorityDto {

    private Long id;

    private String authority;

}
