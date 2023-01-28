package carl.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @className: UserLoginDTO
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/4/12 11:39
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginDTO implements Serializable {
    /**
     * 可以是 账号 / 邮箱 / 手机号
     */
    private String account;

    private String password;
}
