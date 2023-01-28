package carl.infr.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @className: UserDO
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/4/6 16:25
 */
@TableName("user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDO {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    private String gender;

    private String email;

    private String account;

    private String password;

    private String phone;

    private Integer isDeleted;

    private Timestamp addTime;

    private Timestamp updateTime;
}
