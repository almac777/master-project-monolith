package at.ac.fhcampus.master.monolith.articles.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDto {

    // @todo: Expand upon this
    private Long id;
    private String url;
}
