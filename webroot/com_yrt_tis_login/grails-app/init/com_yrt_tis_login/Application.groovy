package com_yrt_tis_login

import grails.boot.GrailsApp
import grails.boot.config.GrailsAutoConfiguration
import groovy.sql.Sql
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.context.annotation.Bean
import org.springframework.data.redis.serializer.StringRedisSerializer
import redis.clients.jedis.JedisPool
import redis.clients.jedis.JedisPoolConfig

@EnableDiscoveryClient
class Application extends GrailsAutoConfiguration {
    static void main(String[] args) {
        GrailsApp.run(Application, args)
    }

    @Bean
    StringRedisSerializer stringRedisSerializer(){
        return new StringRedisSerializer()
    }

    @Bean
    JedisPool jedisPool(){
        JedisPoolConfig config = new JedisPoolConfig()
//        config.setMaxActive(1024)
        config.setMaxIdle(200)
        config.setTestOnBorrow(true)
        return new JedisPool(config, "172.16.105.143", 6379, 30000, "123456")
    }

    @Bean
    Sql sqlEX(){
        return new Sql(grailsApplication.mainContext.getBean("dataSource"))
    }
}