package hello.archivebackend.domain.article.entity;

import hello.archivebackend.domain.category.entity.Category;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Article {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String slug;
    private String author;
    private String description;

    @ManyToOne
    private Category category;

    @Lob
    private String contentMarkdown;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime publishedAt;
}
