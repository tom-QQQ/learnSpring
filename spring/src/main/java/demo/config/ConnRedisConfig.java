package demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author Ning
 * @date Create in 2019/4/6
 */
@Configuration
public class ConnRedisConfig {


    @Value("${redis.ip}")
    private String redisIp;

    @Value("${redis.port}")
    private Integer redisPort;

    @Value("${redis.db}")
    private Integer redisDb;

    @Value("${redis.use.pool}")
    private String redisUsePool;

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {

        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setHostName(redisIp);
        jedisConnectionFactory.setPort(redisPort);
        jedisConnectionFactory.setUsePool(Boolean.parseBoolean(redisUsePool));
        jedisConnectionFactory.setDatabase(redisDb);
        return jedisConnectionFactory;
    }

    @Bean
    @Primary
    public StringRedisTemplate stringRedisTemplate() {

        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(jedisConnectionFactory());
        stringRedisTemplate.setKeySerializer(new StringRedisSerializer());
        return stringRedisTemplate;
    }

    @Bean("countTimesRedisTemplate")
    public RedisTemplate<String, Long> countTimesRedisTemplate() {

        RedisTemplate<String, Long> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());

        // redis的存储的值是需要序列化的, 当不使用提供的StringRedisTemplate时, 如果key为String, hashKey和key的序列化建议使用StringRedisSerializer()
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericToStringSerializer<>(Long.class));
        return redisTemplate;
    }
}
