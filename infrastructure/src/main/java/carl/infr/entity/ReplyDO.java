package carl.infr.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @className: ReplyDO
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/4/6 16:25
 */
@TableName("reply")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReplyDO {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String text;

    private Long topicId;

    private Long userId;

    private Integer isDeleted;

    private Timestamp addTime;
}
