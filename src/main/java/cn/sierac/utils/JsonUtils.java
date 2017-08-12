package cn.sierac.utils;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * json工具类
 * Created by Jack on 2017/7/28.
 */
public class JsonUtils {

    /**
     * java => Json字符串
     * @param obj
     * @return
     */
    public static String objectToJsonStr(Object obj) {
        JSONObject json = new JSONObject().fromObject(obj);
        String str = json.toString();
        return str ;
    }

    /**
     * Json字符串 => json对象
     * @param getJosn
     * @return
     */
    public static JSONArray findKeytoValueFromJson(String getJosn){
        String j1 = "\"";
        String jj = "\\";
        StringBuilder ss = new StringBuilder();

        for (int i = 0; i < getJosn.length(); i++) {
            if (j1.equals(String.valueOf(getJosn.charAt(i)))) {
                ss = ss.append(new StringBuilder(jj));
            }
            ss.append(getJosn.charAt(i));
        }
        String jsonStr = ss.toString();
        jsonStr ="["+getJosn+"]";
        JSONArray jkfJson =  JSONArray.fromObject(jsonStr);
        return jkfJson;
    }



    public static void main(String args[]){

        JsonIds jsonIds = new JsonIds();
        jsonIds.setCode("0");
        jsonIds.setDealerId("221");
        jsonIds.setWarehouseId("12121");

        String json =  objectToJsonStr(jsonIds);
        System.out.print(json);
        System.out.print( findKeytoValueFromJson(json));


    }



}
