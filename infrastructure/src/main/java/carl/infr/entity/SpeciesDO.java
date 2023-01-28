package carl.infr.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @className: SpeciesDO
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/4/6 16:26
 */
@TableName("species")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpeciesDO {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    public SpeciesDO(String name) {
        this.name = name;
    }
}
