package tr.com.huseyinaydin.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Component;

/**
 * 
 @author Huseyin_Aydin
 @since 1994
 @category Spring Boot Redis
 * 
 */

@Component
public class RedisMessagePublisher implements MessagePublisher {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private ChannelTopic topic;

    public RedisMessagePublisher(RedisTemplate<String, Object> redisTemplate, ChannelTopic topic) {
        this.redisTemplate = redisTemplate;
        this.topic = topic;
    }

    public RedisMessagePublisher() {
    }

    @Override
    public void publish(String message) {
        redisTemplate.convertAndSend(topic.getTopic(),message);
    }
}
