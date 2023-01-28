package carl.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @className: UserRegisterDTO
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/4/11 21:17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterDTO implements Serializable {
    private String name;

    private String gender;

    private String email;

    private String account;

    private String password;

    private String phone;
}
