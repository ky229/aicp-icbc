/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.aicp.icbc.webhook.service;

import java.util.Map;

/**
 * 创建人 : lixiaodong
 * 创建日期 : 18/10/25
 * 描述说明 : 业务服务接口
 */
public interface BusinessService {

    /**
     * 服务被触发判断逻辑
     * @param requestMap webhook请求参数
     * @return
     */
    public boolean isServiceBeCalled(Map<String, Object> requestMap);

    /**
     *
     * @param requestMap webhook请求参数
     * @return
     */
    public Map<String,Object> getResult(Map<String, Object> requestMap);

}
