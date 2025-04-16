package spring.aos.curriculo.modules.curriculum.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class CurriculumDTO {
    private UUID id;
    private String formation;
    private String experience;
    private String skills;
    private String languages;
    private String description;
    private UUID userId;

}