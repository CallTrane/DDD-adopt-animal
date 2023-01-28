package carl.app.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @className: AnimalVO
 * @description:
 * @author: Carl Tong
 * @date: 2022/4/14 16:10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnimalVO implements Serializable {
    private Long animalId;
    private String speciesName;
    private String animalName;
    private String animalGender;
    private String animalAddress;
    private String animalUpdateTime;
}
