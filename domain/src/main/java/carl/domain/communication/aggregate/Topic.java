package carl.domain.communication.aggregate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @className: Topic
 * @description: 主题 聚合根
 * @author: Carl Tong
 * @date: 2022/4/6 14:48
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Topic {
    private Long id;

    private String name;

    private String text;

    private Long userId;

    private String userName;

    private Long animalId;

    private Integer isDeleted;

    private Timestamp addTime;

}
