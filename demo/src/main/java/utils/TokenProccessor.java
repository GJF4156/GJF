package utils;

import java.util.UUID;

/**
 * Created by xiao on 2018/10/27.
 * 返回随机生成的36位字符串
 */
public class TokenProccessor {
    /*
    * 单例设计模式（保证类的对象在内存中只有一个）1、把类的构造函数私有2、自己创建一个类的对象3、对外提供一个公共的方法，返回类的对象
    */
    private TokenProccessor()
    {
    }

    private static final TokenProccessor instance = new TokenProccessor();

    /**
     * 返回类的对象
     *
     * @return
     */
    public static TokenProccessor getInstance()
    {
        return instance;
    }

    /**
     * 生成Token Token：36位
     *
     * @return
     */
    public String makeToken() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 生成token
     * @return
     */
    public static String GetTokenPattern()
    {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String genId(){
        String orderId =(System.currentTimeMillis() + "").substring(1) +(System.nanoTime() + "").substring(7, 10);
        System.out.println(orderId);
        return orderId;
    }

    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-", "");
    }
    public static int getNumUUID() {
        UUID uuid = UUID.randomUUID();
        int num = uuid.toString().replace("-", "").hashCode();
        return num > 0 ? num : -num;
    }
}
