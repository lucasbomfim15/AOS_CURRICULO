package spring.aos.curriculo.modules.user.dtos;

import lombok.Data;
import spring.aos.curriculo.modules.curriculum.dtos.CurriculumDTO;

import java.util.UUID;

@Data
public class UserDTO {
    private UUID id;
    private String name;
    private String email;
    private String linkedin;
    private String github;
    private String phone;
    private CurriculumDTO curriculum;
}