package spring.aos.curriculo.modules.curriculum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.aos.curriculo.modules.curriculum.model.Curriculum;
import spring.aos.curriculo.modules.curriculum.repository.CurriculumRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CurriculumService {

    private final CurriculumRepository curriculumRepository;



    public Curriculum create(Curriculum curriculum) {
        return curriculumRepository.save(curriculum);
    }

    public Curriculum getById(UUID id) {
        return curriculumRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curriculum not found"));
    }

    public List<Curriculum> getAll() {
        return curriculumRepository.findAll();
    }

    public Curriculum getByUserId(UUID userId) {
        return curriculumRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Curriculum for user not found"));
    }
}
