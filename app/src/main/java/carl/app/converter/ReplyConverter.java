package carl.app.converter;

import carl.app.dto.TopicReplyDTO;
import carl.app.vo.ReplyVO;
import carl.domain.communication.entity.ReplyMO;
import carl.domain.communication.entity.ReplyUser;
import carl.infr.config.GlobalConfig;

/**
 * @className: ReplyConverter
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/4/6 16:47
 */
public class ReplyConverter {
    public static ReplyMO toReplyMO(TopicReplyDTO topicReplyDTO) {
        ReplyMO replyMO = new ReplyMO();
        replyMO.setTopicId(topicReplyDTO.getTopicId());
        replyMO.setUserId(topicReplyDTO.getUserId());
        replyMO.setReplyText(topicReplyDTO.getReplyText());
        return replyMO;
    }

    public static ReplyVO toReplyVO(ReplyUser replyUser){
        ReplyVO replyVO = new ReplyVO();
        replyVO.setUserId(replyUser.getUserId());
        replyVO.setUserName(replyUser.getName());
        replyVO.setReplyText(replyUser.getText());
        replyVO.setAddTime(GlobalConfig.getDateFormat().format(replyUser.getAddTime()));
        return replyVO;
    }
}
