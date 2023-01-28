package carl.domain.user.service;

import carl.domain.user.aggregate.User;
import carl.domain.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @className: UserDomainService
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/4/6 16:56
 */
@Service
public class UserDomainService {

    @Autowired
    UserRepository userRepository;

    public void register(User user) {
        userRepository.register(user);
    }

    public Optional<User> login(String account, String password) {
        return userRepository.login(account, password);
    }

    public User getUserInfo(Long userId) {
        return userRepository.getUserInfo(userId);
    }

    public void editInfo(User user) {
        userRepository.updateInfo(user);
    }
}
