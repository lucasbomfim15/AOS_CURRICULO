package spring.aos.curriculo.modules.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.aos.curriculo.modules.user.model.User;
import spring.aos.curriculo.modules.user.repository.UserRepository;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        if(user.getCurriculum() != null){
            user.getCurriculum().setUser(user);
        }
        return userRepository.save(user);
    }

    public User getUserById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<User> listAllUsers() {
        return userRepository.findAll();
    }
}
