package demo.utils;

import com.alibaba.fastjson.JSONObject;

/**
 * 序列化工具
 * @author Ning
 * @date Create in 2019/4/7
 */
public class JsonRedisSeriaziler {

    private static final String EMPTY_JSON = "{}";

    public JsonRedisSeriaziler(){}

    public String seriazileAsString(Object object) {

        if (object == null) {
            return EMPTY_JSON;
        }

        return JSONObject.toJSONString(object);
    }

    public <T> T deserializeAsObject(String str, Class<T> clazz) {

        if (str == null || clazz == null) {
            return null;
        }

        return JSONObject.parseObject(str, clazz);
    }
}
