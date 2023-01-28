package carl.app.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @className: PageDetailReplyVO
 * @description:
 * @author: Carl Tong
 * @date: 2022/4/14 16:05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReplyVO implements Serializable {
    private Long userId;
    private String userName;
    private String replyText;
    private String addTime;
}
