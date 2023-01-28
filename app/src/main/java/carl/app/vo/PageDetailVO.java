package carl.app.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @className: PageDetailVO
 * @description:
 * @author: Carl Tong
 * @date: 2022/4/14 15:28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageDetailVO implements Serializable {
    private TopicVO topicVO;
    private AnimalVO animalVO;
    private List<ReplyVO> replyVOs;
}
