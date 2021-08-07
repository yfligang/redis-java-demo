import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

public class RedisJavaDemo {

    public RedisJavaDemo(){
        //Java连接本地，数据类型为list
        Jedis jedis = new Jedis("localhost");
        //存储数据到列表中
        jedis.lpush("LG","China");
        jedis.lpush("ZL","Japan");
        jedis.lpush("CLF","UK");
        jedis.lpush("LG","123");
        jedis.lpush("LG","hospatol");
        jedis.lpush("LG","12","Hello");

        jedis.set("name","200");

        System.out.println(jedis.get("name"));

        System.out.println(jedis.lrange("LG",0,-1));

        //将redis列表中的数据取出来
        List<String> list = jedis.lrange("LG",0,-1);
        for (String str:list
             ) {
            System.out.println("redis中列表的数据为: " + str);
        }

    }

    public static void main(String[] args){
        //类的实例化，新建一个对象
        RedisJavaDemo rjd = new RedisJavaDemo();

        //使用Java连接本地redis
        Jedis jedis = new Jedis("localhost");
        //判断下redis是不是超时或者没有连接上
        if (!jedis.ping().equals("PONG")){
            System.out.println("本地redis超时了");
            return;
        }
        Long m = jedis.clientId();
        System.out.println(m);
        //确认redis服务是否运行
        System.out.println("服务正在运行: " + jedis.ping());
        String str = jedis.get("key");
        System.out.println(str);

        jedis.set("china","No.1");
        String str1 = jedis.get("china");
        System.out.println(str1);
    }

}
