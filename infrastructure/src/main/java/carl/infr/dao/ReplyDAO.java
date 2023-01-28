package carl.infr.dao;

import carl.domain.communication.entity.ReplyUser;
import carl.infr.entity.ReplyDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @className: ReplyDAO
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/4/6 16:36
 */
@Mapper
public interface ReplyDAO extends BaseMapper<ReplyDO> {
    List<ReplyUser> getRepliesByTopicId(Long topicId);
}
