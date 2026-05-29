package hello.archivebackend.domain.tag.entity;

import hello.archivebackend.domain.common.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(
        name = "tags",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_tags_name", columnNames = "name"),
                @UniqueConstraint(name = "uk_tags_slug", columnNames = "slug")
        }
)
@NoArgsConstructor
public class Tag extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "slug", nullable = false, length = 80)
    private String slug;

    public Tag(String name, String slug) {
        this.name = name;
        this.slug = slug;
    }

    public void update(String name, String slug) {
        this.name = name;
        this.slug = slug;
    }

}
