package spring.aos.curriculo.modules.curriculum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.aos.curriculo.modules.curriculum.model.Curriculum;

import java.util.Optional;
import java.util.UUID;

public interface CurriculumRepository extends JpaRepository<Curriculum, UUID> {
    Optional<Curriculum> findByUserId(UUID userId);

}
