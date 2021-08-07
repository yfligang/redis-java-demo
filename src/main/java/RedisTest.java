import redis.clients.jedis.Jedis;

public class RedisTest {
    //连接本地redis
    public void method(){
        Jedis jedis = new Jedis();
        jedis.set("cool","Baggioli");
        jedis.set("蛋蛋","杂谈");
        String str1 = jedis.get("cool");
        String str2 = jedis.get("蛋蛋");
        System.out.println(str1);
        System.out.println(str2);
    }
    public static void main(String[] args){
        RedisTest rt = new RedisTest();
        rt.method();
    }
}
