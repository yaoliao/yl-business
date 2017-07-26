import com.yl.redis.RedisUtil;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaoliao on 2017/7/20.
 */
public class RedisTest {

    public static void main(String[] args) {
//        Jedis jedis = new Jedis("107.182.189.240",6379);
//        jedis.set("key001","value001");
////        jedis.del("key001");
//        System.out.println(jedis.get("key001"));
//
//        String ping = jedis.ping();
//        System.out.println(ping);

        RedisUtil redisUtil = new RedisUtil();
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        JedisShardInfo jedisShardInfo = new JedisShardInfo("107.182.189.240",6379,"instance1");
        List<JedisShardInfo> list = new ArrayList<JedisShardInfo>();
        list.add(jedisShardInfo);
        redisUtil.setShardedJedisPool(new ShardedJedisPool(jedisPoolConfig, list));
        redisUtil.setString("key001","value001");
        String s = redisUtil.getString("key001");
        System.out.println(s);
    }

}
