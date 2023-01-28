package carl.infr.gateway;

import carl.infr.entity.UserDO;

/**
 * @className: UserQueryGateway
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/4/12 17:52
 */
public interface UserGateway {
    UserDO validPhone(String phone);

    UserDO validEmail(String email);
}
