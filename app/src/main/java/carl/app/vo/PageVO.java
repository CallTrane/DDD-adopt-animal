package carl.app.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @className: PageVO
 * @description:
 * @author: Carl Tong
 * @date: 2022/4/13 22:55
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageVO implements Serializable {
    private List<TopicVO> topicVOs;
    private Integer pageIndex;
    private Long total;
}
