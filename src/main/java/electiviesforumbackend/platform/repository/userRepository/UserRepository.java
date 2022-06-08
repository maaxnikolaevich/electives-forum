package electiviesforumbackend.platform.repository.userRepository;

import electiviesforumbackend.platform.entity.User;

public interface UserRepository {
    User getById(Long id);

    User save(User user);

    User findByLogin(String login);

    void deleteById(Long id);
}
