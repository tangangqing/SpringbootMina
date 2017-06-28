package com.example.DtoVo;

import lombok.Data;

import java.util.Map;

/**
 * Created by daile on 2017/6/28.
 */
@Data
public class ControlResultDto {

    private String deviceId;
    private String userOpenId;
    private String controlkey;
    private Map<String, String> result;
    private String msgId;

}
