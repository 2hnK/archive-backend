package hello.archivebackend.domain.project.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(
        name = "projects",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_projects_slug", columnNames = "slug")
        }
)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, length = 200)
    private String title;

    @Column(name = "slug", nullable = false, length = 220)
    private String slug;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "thumbnail_url", length = 1000)
    private String thumbnailUrl;

    @Column(name = "repository_url", length = 1000)
    private String repositoryUrl;

    @Column(name = "demo_url", length = 1000)
    private String demoUrl;

    @Column(name = "completed_at", length = 7)
    private String completedAt;

    @Lob
    @Column(name = "content_markdown", columnDefinition = "LONGTEXT")
    private String contentMarkdown;

    public Project(
            String title,
            String slug,
            String description,
            String thumbnailUrl,
            String repositoryUrl,
            String demoUrl,
            String completedAt,
            String contentMarkdown
    ) {
        this.title = title;
        this.slug = slug;
        this.description = description;
        this.thumbnailUrl = thumbnailUrl;
        this.repositoryUrl = repositoryUrl;
        this.demoUrl = demoUrl;
        this.completedAt = completedAt;
        this.contentMarkdown = contentMarkdown;
    }

    public void update(
            String title,
            String slug,
            String description,
            String thumbnailUrl,
            String repositoryUrl,
            String demoUrl,
            String completedAt,
            String contentMarkdown
    ) {
        this.title = title;
        this.slug = slug;
        this.description = description;
        this.thumbnailUrl = thumbnailUrl;
        this.repositoryUrl = repositoryUrl;
        this.demoUrl = demoUrl;
        this.completedAt = completedAt;
        this.contentMarkdown = contentMarkdown;
    }

}
