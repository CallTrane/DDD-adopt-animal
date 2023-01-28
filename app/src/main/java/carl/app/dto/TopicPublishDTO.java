package carl.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @className: TopicPublishDTO
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/4/12 21:11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopicPublishDTO implements Serializable {
    private Long userId;

    private String topicName;

    private String topicText;

    private String animalName;

    private String animalGender;

    private Long speciesId;

    private String animalAddress;
}
