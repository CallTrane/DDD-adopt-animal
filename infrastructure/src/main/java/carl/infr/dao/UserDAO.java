package carl.infr.dao;

import carl.infr.entity.UserDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @className: UserDAO
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/4/6 16:37
 */
@Mapper
public interface UserDAO extends BaseMapper<UserDO> {
    UserDO login(String account, String password);
}
