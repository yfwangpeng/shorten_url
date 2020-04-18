package com.titizz.shorturl.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by code4wt on 17/8/3.
 */
@Configuration
public class RedisConfiguration {

    @Value("${redis.address}")
    private String redisServerAddress;

    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        config.useSingleServer().setAddress(redisServerAddress);
        return Redisson.create(config);
    }
}
