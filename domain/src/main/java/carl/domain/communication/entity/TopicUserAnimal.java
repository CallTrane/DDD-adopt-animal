package carl.domain.communication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @className: TopicUserAnimal
 * @description:
 * @author: Carl Tong
 * @date: 2022/4/14 16:27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopicUserAnimal {
    private Long userId;
    private String userName;
    private Long topicId;
    private String topicName;
    private String topicText;
    private Long animalId;
    private String animalName;
    private String animalGender;
    private String animalAddress;
    private String speciesName;
    private Timestamp animalUpdateTime;
}
