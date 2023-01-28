package carl.domain.user.repository;

import carl.domain.user.aggregate.User;

import java.util.Optional;

/**
 * @className: UserRepository
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/4/6 15:03
 */
public interface UserRepository {

    /**
     * 注册用户
     */
    void register(User user);

    Optional<User> login(String account, String password);

    User getUserInfo(Long userId);

    void updateInfo(User user);
}
