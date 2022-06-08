package electiviesforumbackend.platform.repository.userRepository;

import electiviesforumbackend.platform.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserDao extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    User findByLogin(String login);
}