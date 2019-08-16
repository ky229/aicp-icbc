/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.aicp.icbc.webhook.rest;
import com.aicp.icbc.webhook.utils.CommonUtils;


public class ApiResponse {

    /**
     * TODO 状态码定义
     */
    public int code = 200;
    public long time = System.currentTimeMillis();
    public String msg = "ok";

    public Object data = null;

    public static ApiResponse getInstance() {
        return new ApiResponse();
    }

    @Override
    public String toString() {
        try {
            return CommonUtils.JACKSON_OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(this);
        } catch (Exception e) {
            return e.toString();
        }
    }
}
