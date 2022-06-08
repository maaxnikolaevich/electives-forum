package electiviesforumbackend.platform.service.userService;

import electiviesforumbackend.platform.entity.User;

import java.util.List;

public interface UserService {
    User register(User user);

    List<User> getAll();

    User findByLogin(String login);

    User findById(Long id);

    void delete(Long id);
}


