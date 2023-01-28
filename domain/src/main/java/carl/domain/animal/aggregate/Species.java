package carl.domain.animal.aggregate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @className: Species
 * @description:
 * @author: Carl Tong
 * @date: 2022/4/19 20:37
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Species {
    private Long id;
    private String name;
}
