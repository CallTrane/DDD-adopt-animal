package carl.domain.communication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @className: ReplyUser
 * @description:
 * @author: Carl Tong
 * @date: 2022/4/14 19:18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReplyUser {
    private Long userId;
    private String name;
    private String text;
    private Timestamp addTime;
}
