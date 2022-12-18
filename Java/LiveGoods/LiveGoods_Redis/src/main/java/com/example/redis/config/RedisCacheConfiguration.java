package com.example.redis.config;

import org.springframework.cache.CacheManager;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

/**
 * 定义一个父类型，用于提供模板配置
 */
public abstract class RedisCacheConfiguration {

    protected RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return redisTemplate;

    }

    protected CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        org.springframework.data.redis.cache.RedisCacheConfiguration configuration =
                org.springframework.data.redis.cache.RedisCacheConfiguration.defaultCacheConfig();

        configuration =
                configuration.entryTtl(Duration.ofMinutes(30L)) // 默认超时时间
                        .disableCachingNullValues() // 不缓存空数据
                        .serializeKeysWith( // key的序列化器
                                RedisSerializationContext.SerializationPair.fromSerializer(
                                        new StringRedisSerializer()
                                )
                        )
                        .serializeValuesWith( // value的序列化器
                                RedisSerializationContext.SerializationPair.fromSerializer(
                                        new GenericJackson2JsonRedisSerializer()
                                )
                        );
        return RedisCacheManager
                .builder(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory))
                .cacheDefaults(configuration)
                .build();
    }
}
