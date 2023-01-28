package carl.infr.dao;

import carl.domain.communication.aggregate.Topic;
import carl.domain.communication.entity.TopicUserAnimal;
import carl.infr.entity.TopicDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @className: TopicDAO
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/4/6 16:37
 */
@Mapper
public interface TopicDAO extends BaseMapper<TopicDO> {
    TopicUserAnimal getTopicDetailInfo(Long topicId);

    List<Topic> getTopic();

    List<Topic> search(String context);

    List<Topic> topList();
}
