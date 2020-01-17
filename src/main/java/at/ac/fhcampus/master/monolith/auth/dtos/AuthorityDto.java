package at.ac.fhcampus.master.monolith.auth.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthorityDto {

    private Long id;

    private String authority;

}
