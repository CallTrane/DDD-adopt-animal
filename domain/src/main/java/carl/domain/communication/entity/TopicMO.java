package carl.domain.communication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @className: TopicMO
 * @description: TODO
 * @author: Carl Tong.
 * @date: 2022/4/13 10:44
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopicMO implements Serializable {
    private Long userId;

    private String topicName;

    private String topicText;

    private String animalName;

    private String animalGender;

    private Long speciesId;

    private String animalAddress;
}
