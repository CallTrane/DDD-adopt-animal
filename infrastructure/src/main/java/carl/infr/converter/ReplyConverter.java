package carl.infr.converter;

import carl.domain.communication.entity.ReplyMO;
import carl.infr.entity.ReplyDO;

/**
 * @className: ReplyConverter
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/4/6 16:47
 */
public class ReplyConverter {
    public static ReplyDO toReplyDO(ReplyMO replyMO) {
        ReplyDO replyDO = new ReplyDO();
        replyDO.setUserId(replyMO.getUserId());
        replyDO.setTopicId(replyMO.getTopicId());
        replyDO.setText(replyMO.getReplyText());
        return replyDO;
    }
}
