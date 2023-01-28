package carl.domain.communication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @className: ReplyMO
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/4/13 21:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReplyMO implements Serializable {
    private Long topicId;

    private Long userId;

    private String replyText;
}
