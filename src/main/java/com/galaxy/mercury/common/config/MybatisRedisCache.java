package com.galaxy.mercury.common.config;

import cn.hutool.extra.spring.SpringUtil;
import org.apache.ibatis.cache.Cache;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Mybatis 设置 redis 缓存
 *
 * @author XianYao
 * @version V1.0
 * @date 2021/8/5 21:39
 */
public class MybatisRedisCache implements Cache {
    private static final Logger logger = LoggerFactory.getLogger(MybatisRedisCache.class);
    private final String id;

    private final String searchExpression;
    /**
     * 读写锁
     */
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);
    /**
     * 过期时间(默认一天,单位:ms)
     */
    @Value("${redis.expirationTime:86400000}")
    int expirationTime;
    /**
     * 这里使用 redis 缓存，使用 springboot 自动注入
     */
    private RedisTemplate<Object, Object> redisTemplate;

    public MybatisRedisCache(String id) {
        if (id == null) {
            throw new IllegalArgumentException("缓存实例需要一个 ID");
        }
        this.id = id;
        this.searchExpression = id + ":*";
    }

    public RedisTemplate<Object, Object> getRedisTemplate() {
        if (redisTemplate == null) {
            redisTemplate = SpringUtil.getBean("redisTemplate");
        }
        return redisTemplate;
    }

    public void getExpirationTime() {
        System.out.println("expirationTime ===> " + expirationTime);
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void putObject(Object key, Object value) {
        if (value == null) {
            return;
        }
        redisTemplate = getRedisTemplate();
        redisTemplate.opsForValue().set(getCacheKey(key), value);
        //一天后过期
        redisTemplate.expire(getCacheKey(key), expirationTime, TimeUnit.MILLISECONDS);

    }

    @Override
    public Object getObject(Object key) {
        redisTemplate = getRedisTemplate();
        try {
            if (key != null) {
                return redisTemplate.opsForValue().get(getCacheKey(key));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Object removeObject(Object key) {
        redisTemplate = getRedisTemplate();
        if (key != null) {
            redisTemplate.delete(key.toString());
        }
        return null;
    }

    @Override
    public void clear() {
        System.out.println("清空缓存");
        try {
            for (Object o : Objects.requireNonNull(getRedisTemplate().keys(searchExpression))) {
                getRedisTemplate().delete(o);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public int getSize() {
        try {
            return Objects.requireNonNull(getRedisTemplate().keys(searchExpression)).size();
        } catch (Exception e) {
            logger.error(e.getMessage());
            return 0;
        }
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return this.readWriteLock;
    }

    private @NotNull String getCacheKey(@NotNull Object key) {
        return this.id + ":" + key.toString();
    }
}
