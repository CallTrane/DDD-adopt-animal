package carl.infr.gateway.impl;

import carl.infr.dao.UserDAO;
import carl.infr.entity.UserDO;
import carl.infr.gateway.UserGateway;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @className: UserQueryGatewayImpl
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/4/12 17:53
 */
@Service
public class UserGatewayImpl implements UserGateway {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDO validPhone(String phone) {
        LambdaQueryWrapper<UserDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserDO::getPhone, phone);
        return userDAO.selectOne(wrapper);
    }

    @Override
    public UserDO validEmail(String email) {
        LambdaQueryWrapper<UserDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserDO::getEmail, email);
        return userDAO.selectOne(wrapper);
    }
}
