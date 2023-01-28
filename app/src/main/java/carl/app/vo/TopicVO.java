package carl.app.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @className: TopicVO
 * @description: 首页下每个主题预览
 * @author: Carl Tong
 * @date: 2022/4/13 21:38
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopicVO implements Serializable {
    private Long userId;
    private String userName;
    private Long topicId;
    private String topicName;
    private String topicText;
}
