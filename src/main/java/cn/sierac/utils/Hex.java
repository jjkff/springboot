package cn.sierac.utils;

import org.apache.commons.codec.DecoderException;

/**
 * Created by Jack on 2017/7/26.
 */
public class Hex {


    public static byte[] decodeHex(char[] data) throws DecoderException {
        int len = data.length;
        if((len & 1) != 0) {
            throw new DecoderException("Odd number of characters.");
        } else {
            byte[] out = new byte[len >> 1];
            int i = 0;

            for(int j = 0; j < len; ++i) {
                int f = toDigit(data[j], j) << 4;
                ++j;
                f |= toDigit(data[j], j);
                ++j;
                out[i] = (byte)(f & 255);
            }

            return out;
        }
    }

    protected static int toDigit(char ch, int index) throws DecoderException {
        int digit = Character.digit(ch, 16);
        if(digit == -1) {
            throw new DecoderException("Illegal hexadecimal character " + ch + " at index " + index);
        } else {
            return digit;
        }
    }
}
