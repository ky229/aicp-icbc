package com.aicp.icbc.webhook.service.impl;

import com.aicp.icbc.webhook.dao.UserInfoExcelDao;
import com.aicp.icbc.webhook.dto.UserInfoDto;
import com.aicp.icbc.webhook.service.BusinessService;
import com.aicp.icbc.webhook.utils.CommonUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.beans.PropertyDescriptor;
import java.util.*;

/**
 * @DESC:核身流程server
 */
@Service("UserInfoService")
@Slf4j
public class UserInfoServiceImpl implements BusinessService {
    @Autowired
    UserInfoExcelDao userInfoExcelDao;


    @Override
    public boolean isServiceBeCalled(Map<String, Object> requestMap) {
        if (CommonUtils.isMapEmpty(requestMap)) {
            return false;
        }
        String action = (String) requestMap.get("action");
        if (StringUtils.isEmpty(action)) {
            return false;
        }
        if ("get_userinfo".equals(action)) {
            return true;
        }
        return false;
    }

    @Override
    public Map<String, Object> getResult(Map<String, Object> requestMap) {
//        UserInfoDto userInfoDto = JSONObject.parseObject((String) requestMap.get("userInfoStr"), UserInfoDto.class);
        String phoneNumber = (String) requestMap.get("query_text");
        List<UserInfoDto> resultList = userInfoExcelDao.getAllUserInfoList();
        Map<String, Object> data = new HashMap<>();
        if (resultList.size() > 0) {
            JSONArray jsonArray = new JSONArray();
            for (UserInfoDto perDto:resultList) {
                if(phoneNumber.equals(perDto.getContactPhoneNumber())){
                    jsonArray.add(JSON.toJSONString(perDto));
                }
            }
            data.put("value", jsonArray);
            Map<String, Object> returnContext = new HashMap<>();
            returnContext.put("api_response_status", true);
            data.put("context", returnContext);
        } else {
            Map<String, Object> returnContext = new HashMap<>();
            returnContext.put("api_response_status", false);
            data.put("context", returnContext);
        }
        return data;
    }

}
