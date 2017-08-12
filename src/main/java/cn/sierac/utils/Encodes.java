package cn.sierac.utils;

import org.apache.commons.codec.DecoderException;

/**
 * 解码
 * Created by Jack on 2017/7/26.
 */
public class Encodes {
    public static String unescapeHtml(String htmlEscaped) {

        String s = StringEscapeUtils.unescapeHtml4(htmlEscaped);

        return StringEscapeUtils.unescapeHtml4(htmlEscaped);
    }

    /**
     * Hex解码.
     */
    public static byte[] decodeHex(String input) {
        try {
            char [] c = input.toCharArray();
            byte[] b = Hex.decodeHex(input.toCharArray());
            return Hex.decodeHex(input.toCharArray());
        } catch (DecoderException e) {
            throw  Encodes.unchecked(e);
        }
    }

    public static RuntimeException unchecked(Exception e) {
        if (e instanceof RuntimeException) {
            return (RuntimeException) e;
        } else {
            return new RuntimeException(e);
        }
    }

    /**
     * Hex编码.
     */
    public static String encodeHex(byte[] input) {
        String s = new String(org.apache.commons.codec.binary.Hex.encodeHex(input));
        return new String(org.apache.commons.codec.binary.Hex.encodeHex(input));
    }
}
