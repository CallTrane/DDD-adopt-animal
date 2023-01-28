package carl.app.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @className: UserInfoVO
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/4/12 14:45
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoVO implements Serializable {
    private String account;

    private String name;

    private String email;

    private String phone;

    private String gender;

    /**
     * 发帖数
     */
    private Long topicCount;

    /**
     * 回复数
     */
    private Long replyCount;
}
