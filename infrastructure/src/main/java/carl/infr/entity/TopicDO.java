package carl.infr.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @className: TopicDO
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/4/6 16:25
 */
@TableName("topic")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopicDO {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    private String text;

    private Long userId;

    private Long animalId;

    private Integer isDeleted;

    private Timestamp addTime;

}
