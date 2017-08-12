package cn.sierac.utils;

import org.apache.commons.lang3.text.translate.*;

/**
 * Created by Jack on 2017/7/26.
 */
public class StringEscapeUtils {

    public static CharSequenceTranslator UNESCAPE_HTML4;

    static {
        UNESCAPE_HTML4 = new AggregateTranslator(new CharSequenceTranslator[]{new LookupTranslator(EntityArrays.BASIC_UNESCAPE()), new LookupTranslator(EntityArrays.ISO8859_1_UNESCAPE()), new LookupTranslator(EntityArrays.HTML40_EXTENDED_UNESCAPE()), new NumericEntityUnescaper(new NumericEntityUnescaper.OPTION[0])});
    }

    public static final String unescapeHtml4(String input) {
        System.out.print(input);
        try {
            String s = UNESCAPE_HTML4.translate(input);
        }catch (Exception e){
            e.printStackTrace();
        }
        return UNESCAPE_HTML4.translate(input);
    }

}
