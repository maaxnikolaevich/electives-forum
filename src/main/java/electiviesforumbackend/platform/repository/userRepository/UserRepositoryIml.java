package electiviesforumbackend.platform.repository.userRepository;

import electiviesforumbackend.platform.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserRepositoryIml implements UserRepository {

    private final UserDao userDao;

    @Override
    public User getById(Long id) {
        return userDao.findById(id).orElse(null);
    }

    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public User findByLogin(String username) {
        return userDao.findByLogin(username);
    }

    @Override
    public void deleteById(Long id) {
        userDao.deleteById(id);
    }

}
