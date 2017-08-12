package cn.sierac.utils;

import java.util.UUID;

/**
 * UUID
 * Created by Jack on 2017/7/27.
 */
public class UuidUtils {

    public static String uuid ;

    public UuidUtils() {
         uuid = getUUID();
    }

    public static String getUUID(){
        String s = UUID.randomUUID().toString();
        return s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24);
    }
}
