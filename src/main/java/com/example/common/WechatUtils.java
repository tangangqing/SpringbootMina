package com.example.common;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by daile on 2017/6/28.
 */
@Slf4j
public class WechatUtils {


    public static String controlDevice(String controlDto) {
        //Gson gson = new Gson();
        log.info("控制");
        String url = WechatConstant.CONTROL_URL;
        log.info("url==>"+url);
        String result = HttpUtils.sendHttpPostRequest(url, controlDto);
        return result;
    }

    public static String getAqi(String userOpenId, String deviceId) {
        //Gson gson = new Gson();
        String url = WechatConstant.GET_AQI + "/" + deviceId + "/" +userOpenId;
        String result = HttpUtils.sendHttpGetRequest(url);
        return result;
    }

    public static String controlDemo(String body) {
        String url = "https://shcloud-rd.sharp.cn/SharpCloudWeb/queen2/device/control?access_token=YmlndWl5dWFuLXNoYXJwLWFpcnB1cmlmaWVy";
        String result = HttpUtils.sendHttpPostRequest(url, body);
        return result;

    }

}
