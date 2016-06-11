package com.xxbase.cache;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.io.Serializable;

/**
 * Created by admin on 16/06/11.
 */
public class RedisCacheProvider implements CacheProvider{

    private RedisTemplate<String, Serializable> redisTemplate;

    public RedisTemplate<String, Serializable> getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<String, Serializable> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void put(String key, Serializable cacheObject) {
        redisTemplate.execute(new RedisCallback<Serializable>() {
            @Override
            public Serializable doInRedis(RedisConnection redisConnection) throws DataAccessException {
                RedisSerializer<Serializable> value = (RedisSerializer<Serializable>) redisTemplate.getValueSerializer();
                redisConnection.set(redisTemplate.getStringSerializer().serialize(key), value.serialize(cacheObject));
                return null;
            }
        });
    }

    @Override
    public Serializable get(String key) {
        redisTemplate.execute(new RedisCallback<Serializable>() {
            @Override
            public Serializable doInRedis(RedisConnection redisConnection) throws DataAccessException {
                byte[] redisKey = redisTemplate.getStringSerializer().serialize(key);

                if(redisConnection.exists(redisKey)){
                    byte[] value = redisConnection.get(redisKey);
                    Serializable valueSerial = (Serializable) redisTemplate.getValueSerializer().deserialize(value);
                    return valueSerial;
                }

                return null;
            }
        });
        return null;
    }

    @Override
    public void remove(String key) {
        redisTemplate.delete(key);
    }
}
