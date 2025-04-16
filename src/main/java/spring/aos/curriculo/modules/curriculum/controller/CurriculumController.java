package spring.aos.curriculo.modules.curriculum.controller;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.aos.curriculo.modules.curriculum.dtos.CurriculumDTO;
import spring.aos.curriculo.modules.curriculum.model.Curriculum;
import spring.aos.curriculo.modules.curriculum.service.CurriculumService;
import spring.aos.curriculo.modules.user.model.User;
import spring.aos.curriculo.modules.user.service.UserService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/curriculums")
@RequiredArgsConstructor
public class CurriculumController {

    private final CurriculumService curriculumService;
    private final ModelMapper modelMapper;
    private final UserService userService;

    @PostMapping("/")
    public ResponseEntity<CurriculumDTO> createCurriculum(@RequestBody CurriculumDTO dto) {
        Curriculum curriculum = modelMapper.map(dto, Curriculum.class);


        User user = userService.getUserById(dto.getUserId());
        curriculum.setUser(user);

        Curriculum created = curriculumService.create(curriculum);
        CurriculumDTO responseDTO = modelMapper.map(created, CurriculumDTO.class);
        responseDTO.setUserId(user.getId());

        return ResponseEntity.status(201).body(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CurriculumDTO> getById(@PathVariable UUID id) {
        Curriculum curriculum = curriculumService.getById(id);
        CurriculumDTO dto = modelMapper.map(curriculum, CurriculumDTO.class);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/")
    public ResponseEntity<List<CurriculumDTO>> getAll() {
        List<Curriculum> curriculums = curriculumService.getAll();
        List<CurriculumDTO> dtos = curriculums.stream()
                .map(c -> modelMapper.map(c, CurriculumDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<CurriculumDTO> getByUserId(@PathVariable UUID userId) {
        Curriculum curriculum = curriculumService.getByUserId(userId);
        CurriculumDTO dto = modelMapper.map(curriculum, CurriculumDTO.class);
        return ResponseEntity.ok(dto);
    }
}