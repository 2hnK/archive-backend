package hello.archivebackend.domain.category.entity;

import hello.archivebackend.domain.common.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(
        name = "categories",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_categories_name", columnNames = "name"),
                @UniqueConstraint(name = "uk_categories_slug", columnNames = "slug")
        },
        indexes = {
                @Index(name = "idx_categories_slug", columnList = "slug")
        }
)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "slug", nullable = false, length = 80)
    private String slug;

    @Column(name = "sort_order", nullable = false) // TODO: 검토
    private int sortOrder;

    public Category (String name, String slug, int sortOrder) {
        this.name = name;
        this.slug = slug;
        this.sortOrder = sortOrder;
    }

    public void update(String name, String slug, int sortOrder) {
        this.name = name;
        this.slug = slug;
        this.sortOrder = sortOrder;
    }

}
