package cn.sierac.utils;

/**
 * Created by Jack on 2017/7/26.
 */
public class Exceptions {

    public static RuntimeException unchecked(Exception e) {
        if (e instanceof RuntimeException) {
            return (RuntimeException) e;
        } else {
            return new RuntimeException(e);
        }
    }

}
