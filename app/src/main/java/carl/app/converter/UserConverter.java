package carl.app.converter;

import carl.app.dto.UserEditDTO;
import carl.app.dto.UserRegisterDTO;
import carl.app.vo.UserInfoVO;
import carl.domain.user.aggregate.User;

/**
 * @className: UserConverter
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/4/6 16:46
 */
public class UserConverter {

    public static User toUser(UserRegisterDTO userRegisterDTO) {
        User user = new User();
        user.setAccount(userRegisterDTO.getAccount());
        user.setPassword(userRegisterDTO.getPassword());
        user.setGender(userRegisterDTO.getGender());
        user.setEmail(userRegisterDTO.getEmail());
        user.setName(userRegisterDTO.getName());
        user.setPhone(userRegisterDTO.getPhone());
        return user;
    }

    public static User toUser(UserEditDTO userEditDTO) {
        User user = new User();
        user.setId(userEditDTO.getId());
        user.setName(userEditDTO.getName());
        user.setPhone(userEditDTO.getPhone());
        user.setEmail(userEditDTO.getEmail());
        user.setGender(userEditDTO.getGender());
        user.setPassword(userEditDTO.getPassword());
        return user;
    }

    public static UserInfoVO toUserInfoVO(User user) {
        UserInfoVO userInfoVO = new UserInfoVO();
        userInfoVO.setAccount(user.getAccount());
        userInfoVO.setName(user.getName());
        userInfoVO.setEmail(user.getEmail());
        userInfoVO.setPhone(user.getPhone());
        userInfoVO.setGender(user.getGender());
        userInfoVO.setTopicCount(user.getTopicCount());
        userInfoVO.setReplyCount(user.getReplyCount());
        return userInfoVO;
    }
}
