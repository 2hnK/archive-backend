package hello.archivebackend.domain.article.entity;

import hello.archivebackend.domain.common.entity.BaseTimeEntity;
import hello.archivebackend.domain.tag.entity.Tag;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(
        name = "article_tags",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_article_tags_article_id_tag_id",
                        columnNames = {"article_id", "tag_id"}
                )
        }
)
@NoArgsConstructor
public class ArticleTag extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "article_id", nullable = false)
    private Article article;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tag_id", nullable = false)
    private Tag tag;

    public ArticleTag(Article article, Tag tag) {
        this.article = article;
        this.tag = tag;
    }
}
