package hello.archivebackend.domain.project.repository;

import hello.archivebackend.domain.project.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
