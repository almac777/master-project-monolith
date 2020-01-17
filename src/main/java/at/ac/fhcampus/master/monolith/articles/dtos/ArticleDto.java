package at.ac.fhcampus.master.monolith.articles.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArticleDto {

    private Long id;
    private String url;

}
