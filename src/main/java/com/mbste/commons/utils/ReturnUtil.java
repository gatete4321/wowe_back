package com.mbste.commons.utils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nostalgie
 * on 2017/11/15.
 */

public class ReturnUtil {

    public static String resultSuccess() {
        JSONObject out = new JSONObject();
        out.put(BSysConstants.RETURN_CODE, 1);
        out.put(BSysConstants.RETURN_MSG, "Operation successful");
        return out.toString();
    }
    public static String resultSuccess(String info) {
        JSONObject out = new JSONObject();
        out.put(BSysConstants.RETURN_CODE, 1);
        out.put(BSysConstants.RETURN_MSG, info);
        return out.toString();
    }

    public static String resultSuccess(Map<String, Object> data) {
        JSONObject out = new JSONObject();
        out.put(BSysConstants.RETURN_CODE, 1);
        out.put(BSysConstants.RETURN_DATA, data);
        out.put(BSysConstants.RETURN_MSG, "Operation successful");

        Map map = new HashMap();
        map.put(BSysConstants.RETURN_CODE, 1);
        map.put(BSysConstants.RETURN_DATA, data);
        map.put(BSysConstants.RETURN_MSG, "Operation successful");
        String aa = JSONObject.toJSONString(map, SerializerFeature.WriteMapNullValue);
        return aa;
    }

    public static String resultFail() {
        JSONObject out = new JSONObject();
        out.put(BSysConstants.RETURN_CODE, 2);
        StringBuilder msg = new StringBuilder("Operation failure");
        out.put(BSysConstants.RETURN_MSG, msg.toString());
        return out.toString();
    }

    public static String resultFail(String info) {
        JSONObject out = new JSONObject();
        out.put(BSysConstants.RETURN_CODE, 2);
        StringBuilder msg = new StringBuilder("");
        if (StringUtils.hasText(info)) {
            msg.append(" " + info);
        }
        out.put(BSysConstants.RETURN_MSG, msg.toString());
        return out.toString();
    }

    public static String resultFail(Map<String, Object> data,String msg) {
        JSONObject out = new JSONObject();
        out.put(BSysConstants.RETURN_CODE, 2);
        out.put(BSysConstants.RETURN_DATA, data);
        out.put(BSysConstants.RETURN_MSG, msg);

        Map map = new HashMap();
        map.put(BSysConstants.RETURN_CODE, 2);
        map.put(BSysConstants.RETURN_DATA, data);
        map.put(BSysConstants.RETURN_MSG, msg);
        String aa = JSONObject.toJSONString(map, SerializerFeature.WriteMapNullValue);
        return aa;

    }

    public static String resultFailByToken() {
        JSONObject out = new JSONObject();
        out.put(BSysConstants.RETURN_CODE, 3);
        StringBuilder msg = new StringBuilder("Token does not exist, please login!");
        out.put(BSysConstants.RETURN_MSG, msg.toString());
        return out.toString();
    }
}
