package cn.sierac.utils;

/**
 * 用户检验登录工具类
 * Created by Jack on 2017/7/26.
 */
public class UserUtils {

    public static final int HASH_INTERATIONS = 1024;

    public static boolean validatePassword(String plainPassword, String password) {
        String plain = Encodes.unescapeHtml(plainPassword);
        byte[] salt = Encodes.decodeHex(password.substring(0,16));
        byte[] hashPassword = Digests.sha1(plain.getBytes(), salt, HASH_INTERATIONS);
        boolean b = password.equals(Encodes.encodeHex(salt)+Encodes.encodeHex(hashPassword));
        return password.equals(Encodes.encodeHex(salt)+Encodes.encodeHex(hashPassword));
    }

}
