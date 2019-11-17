package at.ac.fhcampus.master.monolith.articles.dtos;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
public class ArticleDto {

    private Long id;
    private String url;

}
