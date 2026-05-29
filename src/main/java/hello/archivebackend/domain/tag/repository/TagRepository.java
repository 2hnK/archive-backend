package hello.archivebackend.domain.tag.repository;

import hello.archivebackend.domain.tag.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {

}
