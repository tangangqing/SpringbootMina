package com.example.common;

/**
 * Created by daile on 2017/6/28.
 */
public class WechatConstant {

    private static final String WECHAT_IP;

    static {
        WECHAT_IP = "http://localhost:18080/SharpCloudWeb/";
    }

    static final String CONTROL_URL = WECHAT_IP + "device/control";
    static final String GET_AQI = WECHAT_IP + "device/aqi";
}
