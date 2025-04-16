package spring.aos.curriculo.modules.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.aos.curriculo.modules.user.model.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
