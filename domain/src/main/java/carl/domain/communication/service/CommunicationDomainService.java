package carl.domain.communication.service;

import carl.domain.communication.aggregate.Topic;
import carl.domain.communication.entity.ReplyMO;
import carl.domain.communication.entity.ReplyUser;
import carl.domain.communication.entity.TopicMO;
import carl.domain.communication.entity.TopicUserAnimal;
import carl.domain.communication.repository.CommunicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.util.function.Tuple2;

import java.util.List;

/**
 * @className: CommunicationDomainService
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/4/6 16:56
 */
@Service
public class CommunicationDomainService {

    @Autowired
    CommunicationRepository communicationRepository;

    public void publishTopic(TopicMO topicMO) {
        communicationRepository.publishTopic(topicMO);
    }

    public void replyTopic(ReplyMO replyMO) {
        communicationRepository.replyTopic(replyMO);
    }

    /**
     * 最好不要用Tuple，这里是为了方便记录总数用于计算分页
     *
     * @param pageIndex
     * @return <data, count>
     */
    public Tuple2<List<Topic>, Long> getPageData(Integer pageIndex) {
        return communicationRepository.getPageData(pageIndex);
    }

    public List<ReplyUser> getRepliesByTopicId(Long topicId) {
        return communicationRepository.getRepliesByTopicId(topicId);
    }

    public TopicUserAnimal getTopicDetailInfo(Long topicId) {
        return communicationRepository.getTopicDetailInfo(topicId);
    }

    public List<Topic> search(String context) {
        return communicationRepository.search(context);
    }

    public List<Topic> topList() {
        return communicationRepository.topList();
    }
}
