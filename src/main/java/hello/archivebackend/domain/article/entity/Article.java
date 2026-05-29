package hello.archivebackend.domain.article.entity;

import hello.archivebackend.domain.article.ArticleStatus;
import hello.archivebackend.domain.category.entity.Category;
import hello.archivebackend.domain.common.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(
        name = "articles",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_article_slug", columnNames = "slug")
        }
)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Article extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "title", nullable = false, length = 200)
    private String title;

    @Column(name = "slug", nullable = false, length = 220)
    private String slug;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "thumbnail_url", length = 1000)
    private String thumbnailUrl;

    @Lob
    @Column(name = "content_markdown", nullable = false, columnDefinition = "LONGTEXT")
    private String contentMarkdown;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 30)
    private ArticleStatus status;

    @Column(name = "published_at")
    private LocalDateTime publishedAt;

    public Article(
            Category category,
            String title,
            String slug,
            String description,
            String thumbnailUrl,
            String contentMarkdown,
            ArticleStatus status,
            LocalDateTime publishedAt
    ) {
        this.category = category;
        this.title = title;
        this.slug = slug;
        this.description = description;
        this.thumbnailUrl = thumbnailUrl;
        this.contentMarkdown = contentMarkdown;
        this.status = status;
        this.publishedAt = publishedAt;
    }

    public void update(
            Category category,
            String title,
            String slug,
            String description,
            String thumbnailUrl,
            String contentMarkdown,
            ArticleStatus status,
            LocalDateTime publishedAt
    ) {
        this.category = category;
        this.title = title;
        this.slug = slug;
        this.description = description;
        this.thumbnailUrl = thumbnailUrl;
        this.contentMarkdown = contentMarkdown;
        this.status = status;
        this.publishedAt = publishedAt;
    }

    public boolean isPublished() {
        return this.status == ArticleStatus.PUBLISHED;
    }

}
