package hello.archivebackend.domain.category.repository;

import hello.archivebackend.domain.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
