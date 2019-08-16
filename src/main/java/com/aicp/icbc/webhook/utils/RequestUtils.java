package com.aicp.icbc.webhook.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 请求信息功具类
 * @Author: 吴开云
 * @Date: 2019/8/16 0016
 * @Version： 1.0
 */
@Slf4j
public class RequestUtils {
    /**
     * 解析查询请求
     * @param requestBody
     * @return
     */
    public static Map<String, Object> getRequest(String requestBody)  {
        Map<String, Object> map = new HashMap<>();
        try {
            map = CommonUtils.JACKSON_OBJECT_MAPPER.readValue(requestBody, HashMap.class);
        }catch (IOException e){
            log.error(e.getMessage());
        }
        return map;
    }
}
