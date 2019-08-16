package com.aicp.icbc.webhook.enums;

import lombok.Getter;

/**
 * @Description:
 * @Author: 吴开云
 * @Date: 2019/8/16 0016
 * @Version： 1.0
 */
@Getter
public enum ResponseStatusEnum {
    /**
     * 请求成功
     */
    Success(200,"成功"),

    /**
     * 服务器内部错误
     */
    Error(500,"服务器内部错误"),

    /**
     * 无法匹配服务
     */
    ServerNotMatch(404, "无法匹配到正确服务"),

    /**
     * 请求不存在
     */
    NotFind(404,"找不到请求");

    private Integer status;
    private String message;

    ResponseStatusEnum(Integer status, String message) {
        this.status = status;
        this.message = message;
    }
}
