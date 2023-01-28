package carl.infr.dao;

import carl.infr.entity.AnimalDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @className: AnimalDAO
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/4/6 16:36
 */
@Mapper
public interface AnimalDAO extends BaseMapper<AnimalDO> {
}
