/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.aicp.icbc.webhook;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * 创建人 : lixiaodong
 * 创建日期 : 18/10/25
 * 描述说明 : 构建所需要的对象,给容器托管
 */
@Configuration
public class WebHookConfig {

    @Bean
    public OkHttpClient okHttpClient() {
        // Bean注解是单例效果
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true);
        return builder.build();
    }

}
