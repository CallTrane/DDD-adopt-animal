package carl.app.service;

import carl.app.dto.UserEditDTO;
import carl.app.dto.UserLoginDTO;
import carl.app.dto.UserRegisterDTO;
import carl.app.vo.UserInfoVO;
import carl.common.exception.BizException;
import carl.domain.user.aggregate.User;
import carl.domain.user.service.UserDomainService;
import carl.app.converter.UserConverter;
import carl.infr.gateway.UserGateway;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @className: UserApplicationService
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/4/6 18:18
 */
@Service
public class UserApplicationService {

    @Autowired
    private UserDomainService userDomainService;

    @Autowired
    private UserGateway userGateway;

    public void registerUser(UserRegisterDTO userRegisterDTO) {
        if (StringUtils.isAnyEmpty(userRegisterDTO.getAccount(), userRegisterDTO.getPassword())) {
            throw new BizException("注册用户时账号及密码不能为空");
        }
        userDomainService.register(UserConverter.toUser(userRegisterDTO));
    }

    public User login(UserLoginDTO userLoginDTO) {
        // 参数校验
        if (StringUtils.isAnyEmpty(userLoginDTO.getAccount(), userLoginDTO.getPassword())) {
            throw new BizException("账号及密码不能为空");
        }
        Optional<User> user = userDomainService.login(userLoginDTO.getAccount(), userLoginDTO.getPassword());
        if (user.isEmpty()) throw new BizException("账号密码有误，或该用户还未注册");
        return user.get();
    }

    public UserInfoVO getUserInfo(Long userId) {
        User user = userDomainService.getUserInfo(userId);
        return UserConverter.toUserInfoVO(user);
    }

    public void validPhone(String phone) {
        if (ObjectUtils.isNotEmpty(userGateway.validPhone(phone))) throw new BizException("该手机号已被注册");
    }

    public void validEmail(String email) {
        if (ObjectUtils.isNotEmpty(userGateway.validEmail(email))) throw new BizException("该邮箱已被注册");
    }

    public void editInfo(UserEditDTO userEditDTO) {
        if (!validUserEdit(userEditDTO)) throw new BizException("更新信息必须输入数据");
        if (ObjectUtils.isNotEmpty(userEditDTO.getPhone())) validPhone(userEditDTO.getPhone());
        if (ObjectUtils.isNotEmpty(userEditDTO.getEmail())) validEmail(userEditDTO.getEmail());
        User user = UserConverter.toUser(userEditDTO);
        userDomainService.editInfo(user);
    }

    private boolean validUserEdit(UserEditDTO userEditDTO) {
        if (StringUtils.isAllEmpty(userEditDTO.getGender(), userEditDTO.getEmail(), userEditDTO.getPhone(), userEditDTO.getName(), userEditDTO.getPassword()))
            return false;
        return true;
    }
}
