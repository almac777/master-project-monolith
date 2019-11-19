package at.ac.fhcampus.master.monolith.articles.dtos;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
public class ArticleDto {

    private Long id;
    private String url;

}
