package carl.app.service;

import carl.app.converter.AnimalConverter;
import carl.app.converter.ReplyConverter;
import carl.app.converter.TopicConverter;
import carl.app.dto.TopicPublishDTO;
import carl.app.dto.TopicReplyDTO;
import carl.app.vo.PageDetailVO;
import carl.app.vo.PageVO;
import carl.app.vo.ReplyVO;
import carl.app.vo.TopicVO;
import carl.common.exception.BizException;
import carl.domain.communication.aggregate.Topic;
import carl.domain.communication.entity.ReplyMO;
import carl.domain.communication.entity.ReplyUser;
import carl.domain.communication.entity.TopicMO;
import carl.domain.communication.entity.TopicUserAnimal;
import carl.domain.communication.service.CommunicationDomainService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.util.function.Tuple2;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * @className: CommunicationApplicationService
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/4/6 16:22
 */
@Slf4j
@Service
public class CommunicationApplicationService {

    @Autowired
    private CommunicationDomainService communicationDomainService;

    public void publish(TopicPublishDTO topicPublishDTO) {
        if (ObjectUtils.isEmpty(topicPublishDTO.getUserId())) throw new BizException("登录过期，请重新登录");
        if (ObjectUtils.isEmpty(topicPublishDTO.getTopicName())) throw new BizException("请输入主题贴名");
        if (ObjectUtils.isEmpty(topicPublishDTO.getSpeciesId())) throw new BizException("请选择动物品种");
        TopicMO topicMO = TopicConverter.toTopicMO(topicPublishDTO);
        communicationDomainService.publishTopic(topicMO);
    }

    public void reply(TopicReplyDTO topicReplyDTO) {
        ReplyMO replyMO = ReplyConverter.toReplyMO(topicReplyDTO);
        communicationDomainService.replyTopic(replyMO);
    }

    public PageVO getPageData(Integer pageIndex) {
        // 最好不要用Tuple，这里是为了方便记录总数用于计算分页
        Tuple2<List<Topic>, Long> tuple2 = communicationDomainService.getPageData(pageIndex);
        return toPageVO(tuple2.getT1(), pageIndex, tuple2.getT2());
    }

    private static PageVO toPageVO(List<Topic> topicList, Integer pageIndex, Long total) {
        PageVO pageVO = new PageVO();
        List<TopicVO> data = topicList.stream().map(TopicConverter::toTopicVO).collect(Collectors.toList());
        pageVO.setTopicVOs(data);
        pageVO.setPageIndex(pageIndex);
        pageVO.setTotal(total);
        return pageVO;
    }

    public List<TopicVO> search(String context) {
        List<Topic> topicList = communicationDomainService.search(context);
        return topicList.stream().map(TopicConverter::toTopicVO).collect(Collectors.toList());
    }

    public PageDetailVO getTopicDetail(Long topicId) {
        // 根据主题id 拿到所有相关回复
        CompletableFuture<List<ReplyUser>> future = CompletableFuture.supplyAsync(() -> communicationDomainService.getRepliesByTopicId(topicId));
        // 根据主题id 拿到用户、动物
        TopicUserAnimal entity = communicationDomainService.getTopicDetailInfo(topicId);
        AtomicReference<PageDetailVO> pageDetailVO = new AtomicReference<>();
        future.whenComplete((result, throwable) -> pageDetailVO.set(toPageDetailVO(result, entity)));
        return pageDetailVO.get();
    }

    private static PageDetailVO toPageDetailVO(List<ReplyUser> replies, TopicUserAnimal entity) {
        PageDetailVO pageDetailVO = new PageDetailVO();
        if (ObjectUtils.isNotEmpty(replies)) {
            List<ReplyVO> replyVOs = replies.stream().map(ReplyConverter::toReplyVO).collect(Collectors.toList());
            pageDetailVO.setReplyVOs(replyVOs);
        }
        if (ObjectUtils.isNotEmpty(entity.getTopicId())) pageDetailVO.setTopicVO(TopicConverter.toTopicVO(entity));
        if (ObjectUtils.isNotEmpty(entity.getAnimalId())) pageDetailVO.setAnimalVO(AnimalConverter.toAnimalVO(entity));
        return pageDetailVO;
    }

    public List<TopicVO> topList() {
        List<Topic> list = communicationDomainService.topList();
        return list.stream().map(TopicConverter::toTopicVO).collect(Collectors.toList());
    }
}
