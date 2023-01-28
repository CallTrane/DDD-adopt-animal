package carl.domain.communication.repository;

import carl.domain.communication.aggregate.Topic;
import carl.domain.communication.entity.ReplyMO;
import carl.domain.communication.entity.ReplyUser;
import carl.domain.communication.entity.TopicMO;
import carl.domain.communication.entity.TopicUserAnimal;
import reactor.util.function.Tuple2;

import java.util.List;

/**
 * @className: CommunicationRepository
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/4/6 16:34
 */
public interface CommunicationRepository {
    void publishTopic(TopicMO topicMO);

    void replyTopic(ReplyMO replyMO);

    /**
     * 最好不要用Tuple，这里是为了方便记录总数用于计算分页
     *
     * @param pageIndex
     * @return <data, count>
     */
    Tuple2<List<Topic>, Long> getPageData(Integer pageIndex);

    List<ReplyUser> getRepliesByTopicId(Long topicId);

    TopicUserAnimal getTopicDetailInfo(Long topicId);

    List<Topic> search(String context);

    List<Topic> topList();

}
