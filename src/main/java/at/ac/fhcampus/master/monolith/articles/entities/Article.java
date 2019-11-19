package at.ac.fhcampus.master.monolith.articles.entities;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "articles")
@Entity
@Builder
public class Article {

    @Id @GeneratedValue private Long id;

    private String url;

}
