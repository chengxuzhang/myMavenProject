package com_yrt_tis_login

import redis.clients.jedis.Jedis
import redis.clients.jedis.JedisPool
import redis.clients.jedis.JedisPoolConfig

/**
 * Created by srun(LuoXS) on 2017/10/23.
 */
class redisFactory {

    static JedisPool jedisPool

    static Jedis getJedis() {
        Jedis shardJedis = null;
        try {
            if(jedisPool == null) {
                JedisPoolConfig config = new JedisPoolConfig()
//                config.setMaxActive(1024)
                config.setMaxIdle(200)
                config.setTestOnBorrow(true)
                jedisPool = new JedisPool(config, "172.16.105.143", 6379, 30000, "123456")
            }
            shardJedis = jedisPool.getResource();
            return shardJedis;
        } catch (Exception e) {
            e.printStackTrace();
            if(null != shardJedis)
                shardJedis.close();
        }
        return null;
    }

    static void close(Jedis jedis) {
        jedis.close();
    }
}

