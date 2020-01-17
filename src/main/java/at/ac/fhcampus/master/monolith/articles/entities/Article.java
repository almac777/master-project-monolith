package at.ac.fhcampus.master.monolith.articles.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "articles")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Article {

    @Id @GeneratedValue private Long id;

    private String url;

}
