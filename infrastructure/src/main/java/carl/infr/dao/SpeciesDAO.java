package carl.infr.dao;

import carl.infr.entity.SpeciesDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @className: SpeciesDAO
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/4/6 16:37
 */
@Mapper
public interface SpeciesDAO extends BaseMapper<SpeciesDO> {
    void test(@Param("list") List<SpeciesDO> speciesDOs);
}
