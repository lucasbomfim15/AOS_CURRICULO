package spring.aos.curriculo.modules.curriculum.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.aos.curriculo.modules.user.model.User;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity()
@Table(name = "curriculum")
public class Curriculum {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String formation;
    private String experience;
    private String skills;
    private String languages;
    private String description;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;




}
