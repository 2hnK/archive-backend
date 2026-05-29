package hello.archivebackend.domain.article.repository;

import hello.archivebackend.domain.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository implements JpaRepository<Article> {
}
