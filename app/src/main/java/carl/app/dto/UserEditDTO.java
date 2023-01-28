package carl.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @className: UserEditDTO
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/4/12 17:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEditDTO implements Serializable {

    private Long id;

    private String name;

    private String phone;

    private String gender;

    private String email;

    private String password;
}
