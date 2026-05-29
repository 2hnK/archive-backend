package hello.archivebackend.domain.category.entity;

import hello.archivebackend.domain.article.entity.Article;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue
    private Long id;

    private String

    @OneToMany
    private List<Article> articles;


}
