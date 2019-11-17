package at.ac.fhcampus.master.monolith.articles.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "articles")
@Entity
public class Article {

    @Id @GeneratedValue private Long id;

    private String url;

}
