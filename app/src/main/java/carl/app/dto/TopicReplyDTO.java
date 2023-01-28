package carl.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @className: TopicReplyDTO
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/4/13 21:13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopicReplyDTO implements Serializable {
    private Long topicId;

    private Long userId;

    private String replyText;
}
