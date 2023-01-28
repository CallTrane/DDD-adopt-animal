package carl.domain.user.aggregate;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @className: User
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/4/6 15:02
 */
@Data
@NoArgsConstructor
public class User {
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

    private Long topicCount;

    private Long replyCount;
}
