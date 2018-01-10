package com.yrt.utils

import com_yrt_tis_login.redisFactory
import redis.clients.jedis.Jedis

/**
 * Created by srun(LuoXS) on 2017/10/23.
 */
class redisClient {

    /**
     * 序列化
     * @param object
     * @return
     */
    static byte[] serialize(Object object) {
        if (object == null) {
            return null
        }
        ObjectOutputStream oos = null
        ByteArrayOutputStream baos = null
        byte[] bytes = null
        try {
            // 序列化
            baos = new ByteArrayOutputStream()
            oos = new ObjectOutputStream(baos)
            oos.writeObject(object)
            bytes = baos.toByteArray()
        } catch (Exception e) {
            e.printStackTrace()
        } finally {
            close(oos)
            close(baos)
        }
        return bytes
    }

    /**
     * 反序列化
     *
     * @param bytes
     * @return
     */
    static Object unserialize(byte[] bytes) {
        if (bytes == null) {
            return null
        }
        ByteArrayInputStream bais = null
        ObjectInputStream ois = null
        try {
            // 反序列化
            bais = new ByteArrayInputStream(bytes)
            ois = new ObjectInputStream(bais)
            return ois.readObject()
        } catch (Exception e) {
            e.printStackTrace()
        } finally {
            close(bais)
            close(ois)
        }
        return null
    }

    /**
     * 序列化 list 集合
     *
     * @param list
     * @return
     */
    static byte[] serializeList(List<?> list) {

        if (list.isEmpty()) {
            return null
        }
        ObjectOutputStream oos = null
        ByteArrayOutputStream baos = null
        byte[] bytes = null
        try {
            baos = new ByteArrayOutputStream()
            oos = new ObjectOutputStream(baos)
            for (Object obj : list) {
                oos.writeObject(obj)
            }
            bytes = baos.toByteArray()
        } catch (Exception e) {
            e.printStackTrace()
        } finally {
            close(oos)
            close(baos)
        }
        return bytes
    }

    /**
     * 反序列化 list 集合
     *
     * @param
     * @return
     */
    static List<?> unserializeList(byte[] bytes) {
        if (bytes == null) {
            return null
        }

        List<Object> list = new ArrayList<Object>()
        ByteArrayInputStream bais = null
        ObjectInputStream ois = null
        try {
            // 反序列化
            bais = new ByteArrayInputStream(bytes)
            ois = new ObjectInputStream(bais)
            while (bais.available() > 0) {
                LinkedHashMap obj = (LinkedHashMap) ois.readObject()
                if (obj == null) {
                    break
                }
                list.add(obj)
            }
        } catch (Exception e) {
            e.printStackTrace()
        } finally {
            close(bais)
            close(ois)
        }
        return list
    }

    /**
     * 关闭io流对象
     *
     * @param closeable
     */
    static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close()
            } catch (Exception e) {
                e.printStackTrace()
            }
        }
    }

    /**
     * 设置对象
     * @param key
     * @param obj
     */
    static void setObject(String key ,Object obj){
        Jedis jedis = null
        String result = null
        try {
            jedis = redisFactory.getJedis()
            obj = obj == null ? new Object():obj
            jedis.set(key.getBytes(), serialize(obj))
        } catch (Exception e) {
            e.printStackTrace()
        }finally{
            redisFactory.close(jedis)
        }
    }

    /**
     * 获取对象
     * @param key
     * @return Object
     */
    static Object getObject(String key){
        Jedis jedis = redisFactory.getJedis()
        try{
            if(jedis == null || !jedis.exists(key)){
                return null
            }
            byte[] data = jedis.get(key.getBytes())
            return (Object)unserialize(data)
        }catch (Exception e){
            e.printStackTrace()
        }finally{
            redisFactory.close(jedis)
        }
    }

    /**
     * 设置List集合
     * @param key
     * @param list
     */
    static void setList(String key ,List<?> list){
        Jedis jedis = redisFactory.getJedis()
        try {
            if(!list.isEmpty()){
                jedis.set(key.getBytes(), serializeList(list))
            }else{//如果list为空,则设置一个空
                jedis.set(key.getBytes(), "".getBytes())
            }
        } catch (Exception e) {
            e.printStackTrace()
        }finally{
            redisFactory.close(jedis)
        }
    }

    /**
     * 获取List集合
     * @param key
     * @return
     */
    static List<?> getList(String key){
        Jedis jedis = redisFactory.getJedis()
        try{
            if(jedis == null || !jedis.exists(key)){
                return null
            }
            byte[] data = jedis.get(key.getBytes())
            return unserializeList(data)
        }catch (Exception e){
            e.printStackTrace()
        }finally{
            redisFactory.close(jedis)
        }

    }

    /**
     * 设置
     * @param key
     * @param value
     * @return
     */
    static String set(String key , String value) {
        Jedis jedis = null
        String result = null
        try {
            jedis = redisFactory.getJedis()
            result = jedis.set(key , value)
        } catch (Exception e) {
            e.printStackTrace()
        } finally {
            if(jedis != null) {
                redisFactory.close(jedis)
            }
        }
        return result
    }

    /**
     * 获取
     * @param key
     * @return
     */
    static String get(String key) {
        Jedis jedis = null;
        String result = null;
        try {
            jedis = redisFactory.getJedis();
            result = jedis.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(jedis != null) {
                redisFactory.close(jedis);
            }
        }
        return result;
    }

    /**
     * 删除
     * @param key
     * @return
     */
    static Long del(String key) {
        Jedis jedis = null;
        Long result = null;
        try {
            jedis = redisFactory.getJedis();
            result = jedis.del(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(jedis != null) {
                redisFactory.close(jedis);
            }
        }
        return result;
    }

    /**
     * 设置过期时间
     * @param key
     * @param seconds
     * @return
     */
    static Long expire(String key , int seconds) {
        Jedis jedis = null;
        Long result = null;
        try {
            jedis = redisFactory.getJedis();
            result = jedis.expire(key , seconds);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(jedis != null) {
                redisFactory.close(jedis);
            }
        }
        return result;
    }

}
