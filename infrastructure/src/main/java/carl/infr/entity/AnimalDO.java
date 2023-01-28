package carl.infr.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @className: AnimalDO
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/4/6 16:25
 */
@TableName("animal")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnimalDO {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    private Long speciesId;

    private String gender;

    private String address;

    private Integer isDeleted;

    private Timestamp addTime;

    private Timestamp updateTime;
}
