package carl.common.enums;

import lombok.AllArgsConstructor;

/**
 * @className: RedisKey
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/4/12 14:04
 */
@AllArgsConstructor
public enum RedisKey {

    USER_KEY("user:"),
    TOP_TOPIC_KEY("top_topic");

    private String name;

    public String getName() {
        return name;
    }
}
